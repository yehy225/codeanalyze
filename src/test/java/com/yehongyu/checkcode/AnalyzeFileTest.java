package com.yehongyu.checkcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import com.yehongyu.analyze.BaseDAOTestCase;
import com.yehongyu.analyze.dao.domain.AnalyzeFileDO;
import com.yehongyu.analyze.dao.domain.ClassRefDO;
import com.yehongyu.analyze.dao.domain.PackageClassDO;
import com.yehongyu.analyze.dao.ibatis.AnalyzeFileDAO;
import com.yehongyu.analyze.dao.ibatis.ClassRefDAO;
import com.yehongyu.analyze.dao.ibatis.PackageClassDAO;
import com.yehongyu.analyze.dao.query.AnalyzeFileQuery;
import com.yehongyu.analyze.dao.query.PackageClassQuery;

public class AnalyzeFileTest extends BaseDAOTestCase {
	@Resource
	AnalyzeFileDAO analyzeFileDAO;
	@Resource
	PackageClassDAO packageClassDAO;
	@Resource
	ClassRefDAO classRefDAO;
	
	@Test
	public final void testAnalyzeFile() {
		//先删除DB数据
		List<AnalyzeFileDO> aList = analyzeFileDAO.getAnalyzeFileDOList(null);
		logger.info("aList in DB size:" + aList!=null?aList.size():0);
		AnalyzeFileQuery analyzeFileQuery = new AnalyzeFileQuery();
		for(AnalyzeFileDO a:aList){
			analyzeFileQuery.addIdList(a.getId());
		}
		if(analyzeFileQuery!=null&&analyzeFileQuery.getIdList()!=null&&!analyzeFileQuery.getIdList().isEmpty()){
			int a = analyzeFileDAO.deleteAnalyzeFileDOList(analyzeFileQuery);
			logger.info("aList delte in DB size:" + a);
		}
		//统计到数据库
		for(String s:ClassAnalyze.sourceDir){
			List<String> filelist = ClassAnalyze.listFiles(s+"/src/main/java", null);
			AnalyzeFileDO analyzeFileDO;
			for(String f:filelist){
				analyzeFileDO = ClassAnalyze.analyzeFile(f);
				if(analyzeFileDO!=null) analyzeFileDAO.insertAnalyzeFileDO(analyzeFileDO);
			}
		}
	}
	
	@Test
	public final void testListPackages(){
		//先删除DB数据
		List<PackageClassDO> aList = packageClassDAO.getPackageClassDOList(null);
		logger.info("aList in DB size:" + aList!=null?aList.size():0);
		PackageClassQuery packageClassQuery = new PackageClassQuery();
		for(PackageClassDO a:aList){
			packageClassQuery.addIdList(a.getId());
		}
		if(packageClassQuery!=null&&packageClassQuery.getIdList()!=null&&!packageClassQuery.getIdList().isEmpty()){
			int a = packageClassDAO.deletePackageClassDOList(packageClassQuery);
			logger.info("aList delte in DB size:" + a);
		}
		//统计到数据库
		List<PackageClassDO> l = new ArrayList<PackageClassDO>();
		for(String s:ClassAnalyze.sourceDir){
			List<PackageClassDO> t = ClassAnalyze.listPackage(s+"/src/main/java", null, s+"/src/main/java");
			l.addAll(t);
//			int count=0;
//			for(PackageClassDO p:t){
//				if(p.getClassName()!=null) count++;
//			}
//			logger.info("包路径[" + s +"]代码个数："+count);
//			List<PackageClassDO> tTest = ClassAnalyze.listPackage(s+"/src/test/java", null, s+"/src/test/java");
//			int countTest=0;
//			for(PackageClassDO p:tTest){
//				if(p.getClassName()!=null) countTest++;
//			}
//			logger.info("包路径[" + s +"]测试代码个数："+countTest);
		}
		for(PackageClassDO p:l){
			packageClassDAO.insertPackageClassDO(p);
		}
	}
	
	@Test
	public final void testPrintActionOrScreen(){
		List<PackageClassDO> l = packageClassDAO.getPackageClassDOList(null);
		List<PackageClassDO> actions = new ArrayList<PackageClassDO>();
		List<PackageClassDO> screens = new ArrayList<PackageClassDO>();
		for(PackageClassDO p:l){
			if(p.getClassName()==null) continue;
			if(p.getClassName().contains(".module.action")){
				actions.add(p);
			}else if(p.getClassName().contains(".module.screen")){
				screens.add(p);
			}
		}
		for(PackageClassDO p:actions){
			logger.info("Action类【"+p.getClassName()+"】,所在的Module【" + p.getModulePath() + "】");
		}
		logger.info("Action类的个数: " + actions.size());
		for(PackageClassDO p:screens){
			logger.info("Screen类【"+p.getClassName()+"】,所在的Module【" + p.getModulePath() + "】");
		}
		logger.info("Screen类的个数: " + screens.size());
	}
	
	@Test
	public final void testAnalyzeImport(){
		//TODO 本包引用未解决，接口引用未解决，Action\Screen引用需要人工
		List<PackageClassDO> l = packageClassDAO.getPackageClassDOList(null);
		Set<String> packSet = new HashSet<String>();
		for(PackageClassDO p:l){
			packSet.add(p.getPackageName());
		}
		logger.info(l.size() + ":" + packSet.size());
		List<ClassRefDO> cList = new ArrayList<ClassRefDO>();
		ClassRefDO c;
		List<String> refs;
		for(PackageClassDO p:l){
			if(p.getFileName()==null) continue;
			refs = ClassAnalyze.getImport(p.getFileName());
			if(refs!=null&&refs.size()>0){
				for(String s:refs){
					if(!packSet.contains(s.substring(0,s.lastIndexOf(".")))) continue;
					c = new ClassRefDO();
					c.setClassName(p.getClassName());
					c.setRefClass(s);
					logger.info("类【"+p.getClassName()+"】引用：" + s);
					cList.add(c);
					//写入数据库
					ClassRefDO classRefDO = new ClassRefDO();
					classRefDO.setClassName(p.getClassName());
					classRefDO.setRefClass(s);
					classRefDAO.insertClassRefDO(classRefDO);
				}
			}else{
				logger.warn("类【"+p.getClassName()+"】没有引用本包其他类！");
			}
		}
		logger.info(cList.size());
	}

}
