package com.yehongyu.checkcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.yehongyu.analyze.dao.domain.AnalyzeFileDO;
import com.yehongyu.analyze.dao.domain.PackageClassDO;

public class ClassAnalyze {
	
	/** 日志记录 */
	private final static Logger logger = Logger.getLogger(ClassAnalyze.class);
	
	public static void main(String[] args) {
		//分析代码
		for(String s:sourceDir){
			List<String> list = ClassAnalyze.listFiles(s, null);
			logger.info("文件路径["+s+"]代码个数:"+list.size());
			for(String filename:list){
				System.out.println(filename);
				ClassAnalyze.analyzeFile(filename);
			}
		}
		
		/*//测试代码注释分析
		long flag = hasCodeOrCommentInLine("//public /*",0L);
		logger.info("code:"+FlagUtil.isBinaryBitMatched(flag,FlagUtil.B1));
		logger.info("comment:"+FlagUtil.isBinaryBitMatched(flag,FlagUtil.B2));
		logger.info("commentstart:"+FlagUtil.isBinaryBitMatched(flag,FlagUtil.B3));*/
//		ClassAnalyze.analyzeFile("D:/workspace/codeanalyze/src/main/java/com/yehongyu/checkcode/AppClass.java");
		
		//测试代码注释过滤并去除Imports
//		System.out.println(getImport("D:/workspace/codeanalyze/src/main/java/com/yehongyu/checkcode/ClassAnalyze.java"));
		
		
		/*//统计包路径
		List<PackageClassDO> l = new ArrayList<PackageClassDO>();
		for(String s:sourceDir){
			List<PackageClassDO> t = ClassAnalyze.listPackage(s+"/src/main/java", null, s+"/src/main/java");
			l.addAll(t);
			int count=0;
			for(PackageClassDO p:t){
				if(p.getClassName()!=null) count++;
			}
			logger.info("包路径[" + s +"]代码个数："+count);
			List<PackageClassDO> tTest = ClassAnalyze.listPackage(s+"/src/test/java", null, s+"/src/test/java");
			int countTest=0;
			for(PackageClassDO p:tTest){
				if(p.getClassName()!=null) countTest++;
			}
			logger.info("包路径[" + s +"]测试代码个数："+countTest);
		}*/
	}
	
	public static List<String> sourceDir = new ArrayList<String>();
	static {
		sourceDir.add("D:/workspace/touraland");
	}
	
	/**
	 * 根据没有注释的类文件，分析import导入
	 * @param classFileName
	 * @return
	 */
	public static List<String> getImport(String classFileName){
		String classStr = removeComment(classFileName,"D:/tmp.txt");	//写入没有注释的临时文件
		if(StringUtils.isBlank(classStr)) return null;
		
		//分析 {之前的import导入
		if(classStr.indexOf("{")<0) return null;
		classStr = classStr.substring(0, classStr.indexOf("{"));
		if(StringUtils.isBlank(classStr)) return null;
		String[] str = classStr.split(";");
		if(str.length==0) return null;
		List<String> imports = new ArrayList<String>();
		String tmp;
		for(String s:str){
			if(s.trim().startsWith("import")){
				tmp = s.trim().substring(6).trim();
				if(tmp.startsWith("static")) tmp = tmp.substring(6);	//是静态导入
				if(tmp.endsWith("*")) tmp = tmp.substring(0,tmp.length()-1);	//是包导入
				imports.add(tmp.trim());
			}
		}
		//TODO 分析本包类导入
		return imports;
	}
	
	/**
	 * 去除注释类
	 * @author yingyang
	 * @since 2011-11-17
	 */
	private class Comment{
		private String linestr;
		private StringBuffer afterline;
		private boolean commendend;
		public String getLinestr() {
			return linestr;
		}
		public void setLinestr(String linestr) {
			this.linestr = linestr;
		}
		
		public void clearAfterline() {
			this.afterline = null;
		}
		public String getAfterline() {
			return afterline!=null?afterline.toString():"";
		}
		public void setAfterline(String afterline) {
			if(this.afterline==null) this.afterline = new StringBuffer();
			this.afterline.append(afterline);
		}
		public boolean isCommendend() {
			return commendend;
		}
		public void setCommendend(boolean commendend) {
			this.commendend = commendend;
		}
	}
	
	/**
	 * 清楚Java代码中的注释
	 * @param filename 源代码
	 * @param outfile 输出代码
	 */
	public static String removeComment(String filename,String outfile){
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
			Comment commentLine = new ClassAnalyze().new Comment();
			commentLine.setCommendend(true);
			String linestr;
			int line =1;
			while((linestr=in.readLine())!=null){
				commentLine.setLinestr(linestr);
				commentLine = removeCommentInLine(commentLine);
				if(line!=1) out.newLine();
				line++;
				out.write(commentLine.getAfterline().toString(),0,commentLine.getAfterline().length());
				commentLine.clearAfterline();
//				logger.info(commentLine.isCommendend());
			}
			out.flush();
			out.close();
			in.close();
			
			//从文件中读取出去除注释后的Java代码
			BufferedReader inStr = new BufferedReader(new FileReader(outfile));
			StringBuffer sb = new StringBuffer();
			String tmpLine = inStr.readLine();
	        while (tmpLine != null) {
	        	sb.append(tmpLine);
	            tmpLine = inStr.readLine();
	        }
	        inStr.close();
	        return sb.toString();
		} catch (FileNotFoundException e) {
			logger.error("analyzeFile FileNotFoundException error", e);
		} catch (IOException e) {
			logger.error("analyzeFile IOException error", e);
		}
		return "";
	}
	
	/**
	 * 逐行去除注释
	 * @param commentLine
	 * @return
	 */
	private static Comment removeCommentInLine(Comment commentLine){
		if(StringUtils.isBlank(commentLine.getLinestr())){
			return commentLine;
		}
		if(commentLine.isCommendend()){	//注释未开始
			int oneComment = commentLine.getLinestr().indexOf("//");
			int multiComment = commentLine.getLinestr().indexOf("/*");
			if(oneComment<0&&multiComment<0){	//只有代码,两种注释都没有
				commentLine.setAfterline(commentLine.getLinestr());
				return commentLine;
			}else if(oneComment>=0&&multiComment<0){	//只有单行注释
				//截取代码直到//前
				commentLine.setAfterline(commentLine.getLinestr().substring(0, oneComment));
				return commentLine;
			}else if(oneComment<0&&multiComment>=0){	//只有多行注释
				//截取代码直到/*前，并递归处理
				commentLine.setCommendend(false);
				commentLine.setAfterline(commentLine.getLinestr().substring(0, multiComment));
				commentLine.setLinestr(commentLine.getLinestr().substring(multiComment+2));
				removeCommentInLine(commentLine);
				return commentLine;
			}else if(oneComment>=0&&multiComment>=0){	//两种注释都有
				if(multiComment>oneComment){
					//截取代码直到//前
					commentLine.setAfterline(commentLine.getLinestr().substring(0, oneComment));
					return commentLine;
				}else{	//多行注释
					//截取代码直到/*前，并递归处理
					commentLine.setCommendend(false);
					commentLine.setAfterline(commentLine.getLinestr().substring(0, multiComment));
					commentLine.setLinestr(commentLine.getLinestr().substring(multiComment+2));
					removeCommentInLine(commentLine);
					return commentLine;
				}
			}else{
				Assert.fail("这边不应该来的");
			}
		}else{
			int end = commentLine.getLinestr().trim().indexOf("*/");
			if(end>=0){
				//从*/后继续寻找代码，进行截取
				commentLine.setCommendend(true);
				commentLine.setLinestr(commentLine.getLinestr().trim().substring(end+2));
				removeCommentInLine(commentLine);
				return commentLine;
			}else{	//注释代码未结束,不再寻找
				//没有代码，返回空行
				return commentLine;
			}
		}
		Assert.fail("这边不应该来的2");
		return commentLine;
	}
	
	/**
	 * 分析Java代码文件，返回代码行数，注释行数，空白行数。
	 * @param filename Java文件名全路径
	 * @return 分析后的AnalyzeFileDO对象
	 */
	public static AnalyzeFileDO analyzeFile(String filename){
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader in = new BufferedReader(fr);
			int comment=0;
			int blank=0;
			int code=0;
			int line=0;
			String linestr;
			Long flag = 0L;	//注释代码未开始
			while((linestr=in.readLine())!=null){
				line++;
				if(StringUtils.isBlank(linestr)){
					blank++;
					continue;
				}
				
				flag = hasCodeOrCommentInLine(linestr,flag);
				if(FlagUtil.isBinaryBitMatched(flag,FlagUtil.B1)){
					code++;
				}
				if(FlagUtil.isBinaryBitMatched(flag,FlagUtil.B2)){
					comment++;
				}
				//重置为代码注释开始标识
				if(FlagUtil.isBinaryBitMatched(flag,FlagUtil.B3)){
					flag = FlagUtil.onBit(0L, FlagUtil.B3);
				}else{
					flag = 0L;
				}
			}
			AnalyzeFileDO analyzeFileDO = new AnalyzeFileDO();
			analyzeFileDO.setFilename(filename);
			analyzeFileDO.setLinecount(line);
			analyzeFileDO.setCodecount(code);
			analyzeFileDO.setCommentcount(comment);
			analyzeFileDO.setBlankcount(blank);
			logger.info("line:"+line+",code:"+code+",comment:"+comment+",blank:"+blank+".filename:"+filename);
			in.close();
			return analyzeFileDO;
		} catch (FileNotFoundException e) {
			logger.error("analyzeFile FileNotFoundException error", e);
		} catch (IOException e) {
			logger.error("analyzeFile IOException error", e);
		}
		return null;
	}
	/**
	 * 逐行分析代码及注释：B1-code,B2-comment,B3-commentstart
	 * @param str
	 * @param flag
	 * @return
	 */
	private static Long hasCodeOrCommentInLine(String str,Long flag){
		if(StringUtils.isBlank(str)) return FlagUtil.onBit(flag, 0L);
		if(!FlagUtil.isBinaryBitMatched(flag, FlagUtil.B3)){	//注释未开始
			int oneComment = str.trim().indexOf("//");
			int multiComment = str.trim().indexOf("/*");
			if(oneComment<0&&multiComment<0){	//只有代码,两种注释都没有
				return FlagUtil.onBit(flag, FlagUtil.B1);
			}else if(oneComment>=0&&multiComment<0){	//只有单行注释
				if(oneComment>0){	//代码+注释
					return FlagUtil.onBit(FlagUtil.onBit(flag, FlagUtil.B1),FlagUtil.B2);
				}else{	//注释
					return FlagUtil.onBit(flag, FlagUtil.B2);
				}
			}else if(oneComment<0&&multiComment>=0){	//只有多行注释
				if(multiComment>0){
					flag = FlagUtil.onBit(FlagUtil.onBit(flag, FlagUtil.B1),FlagUtil.B2);
				}else{
					flag = FlagUtil.onBit(flag,FlagUtil.B2);
				}	
				flag = FlagUtil.onBit(flag, FlagUtil.B3);	//注释代码开始
				return hasCodeOrCommentInLine(str.trim().substring(multiComment+2),flag);
			}else if(oneComment>=0&&multiComment>=0){	//两种注释都有
				if(multiComment>0&&oneComment>0){
					flag = FlagUtil.onBit(FlagUtil.onBit(flag, FlagUtil.B1),FlagUtil.B2);
				}else{
					flag = FlagUtil.onBit(flag,FlagUtil.B2);
				}
				if(multiComment>oneComment){
					return flag;
				}else{	//多行注释
					flag = FlagUtil.onBit(flag, FlagUtil.B3);	//注释代码开始
					return hasCodeOrCommentInLine(str.trim().substring(multiComment+2),flag);
				}
			}else{
				Assert.fail("这边不应该来的");
			}
		}else{
			flag = FlagUtil.onBit(flag,FlagUtil.B2);
			int end = str.trim().indexOf("*/");
			if(end>=0){
				flag = FlagUtil.offBit(flag,FlagUtil.B3);//继续寻找
				return hasCodeOrCommentInLine(str.trim().substring(end+2),flag);
			}else{	//注释代码未结束,不再寻找
				return flag;
			}
		}
		Assert.fail("这边不应该来的2");
		return 0L;
	}
	
	/**
	 * 递归列出目录下所有Java文件的路径全名
	 * @param rp 指定目录
	 * @param fileList 文件全名列表
	 * @return 全名列表
	 */
	public static List<String> listFiles(String rp,List<String> fileList) {
		if(fileList==null) fileList = new ArrayList<String>();
		File file = new File(rp);
		File list[] = file.listFiles();
		if(!file.exists()) return fileList;
		for (int i = 0; i < list.length; i++) {
			try {
				if (list[i].isDirectory()) {
//					logger.info(list[i].toString());
					if(!list[i].toString().endsWith("target")) listFiles(list[i].toString(),fileList);	//如果是target表示生成目录，不统计Java源文件
				}else if(list[i].getName().endsWith(".java")){
					fileList.add(list[i].getAbsolutePath());
				}
			} catch (Exception ex) {
				logger.error("Access deny：" + list[i].getAbsolutePath(),ex);
			}
		}
		return fileList;
	}
	
	/**
	 * 递归列出Java源代码路径下包及类信息
	 * @param rp 指定Java源代码目录
	 * @param l 包及类信息列表对象
	 * @param classPackagePath 类包所在路径
	 * @return
	 */
	public static List<PackageClassDO> listPackage(String rp,List<PackageClassDO> l,String classPackagePath) {
		if(l==null) l = new ArrayList<PackageClassDO>();
		String packagestr;
		String classstr;
		File file = new File(rp);
		if(!file.exists()) return l;
		File list[] = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			try {
				PackageClassDO p = new PackageClassDO();
				p.setModulePath(classPackagePath);
				if (list[i].isDirectory()) {	//包信息
					packagestr = list[i].getAbsolutePath().substring(classPackagePath.length()+1).replace("\\", ".");
					p.setPackageName(packagestr);
					p.setClassName(null);
					l.add(p);
//					logger.info(packagestr);
					listPackage(list[i].toString(),l,classPackagePath);
				}else if(list[i].getName().endsWith(".java")){	//类信息
					classstr = list[i].getAbsolutePath().substring(classPackagePath.length()+1,list[i].getAbsolutePath().indexOf(".")).replace("\\", ".");
					p.setPackageName(file.getAbsolutePath().substring(classPackagePath.length()+1).replace("\\", "."));
					p.setClassName(classstr);
					p.setFileName(list[i].getAbsolutePath());
					l.add(p);
//					logger.info(classstr);
				}
			} catch (Exception ex) {
				logger.error("Access deny：" + list[i].getAbsolutePath(),ex);
			}
		}
		return l;
	}

}
