package com.yehongyu.analyze.dao.validate;

import com.yehongyu.analyze.dao.domain.AnalyzeFileDO;
import com.yehongyu.analyze.dao.query.AnalyzeFileQuery;

/**
 * analyze_file校验类
 * 将在×ServiceClient、×ServiceImpl、×DAOImpl三层共同统一校验机制
 * @author yingyang
 * @since 2011-11-16
 */
public class AnalyzeFileValidate extends BaseValidate {
	
	//AnalyzeFile字符字段长度值
	public final static int BYTELENGTH_OF_FILENAME = 200;
	
	/**
	 * 单个查询条件验证ID不为空
	 * @param analyzeFileQuery
	 * @throws IllegalArgumentException
	 */
	public static void getAnalyzeFileDO(AnalyzeFileQuery analyzeFileQuery) throws IllegalArgumentException{
		if(analyzeFileQuery==null||analyzeFileQuery.getId()==null || analyzeFileQuery.getId()<=0){
			throw new IllegalArgumentException("analyzeFileQuery Parameter is not correct,analyzeFileQuery:" + analyzeFileQuery);
		}
	}
	
	/**
	 * 批量查询条件不校验
	 * @param analyzeFileQuery
	 * @throws IllegalArgumentException
	 */
	public static void getAnalyzeFileDOList(AnalyzeFileQuery analyzeFileQuery) throws IllegalArgumentException{

	}
	
	/**
	 * 批量翻页查询条件不校验
	 * @param analyzeFileQuery
	 * @throws IllegalArgumentException
	 */
	public static void getAnalyzeFileDOListWithPage(AnalyzeFileQuery analyzeFileQuery) throws IllegalArgumentException{

	}
	
	/**
	 * 新增记录对象校验不为空，长度校验
	 * @param analyzeFileDO
	 * @throws IllegalArgumentException
	 */
	public static void insertAnalyzeFileDO(AnalyzeFileDO analyzeFileDO) throws IllegalArgumentException{
		if (null == analyzeFileDO) {
			throw new IllegalArgumentException("analyzeFileDO Parameter is null!");
		}
		if(analyzeFileDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validateAnalyzeFileDOFieldLength(analyzeFileDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("insertAnalyzeFileDO Parameter verify not correct,analyzeFileDO:"+sb.toString());
		}
		analyzeFileDO.setValidate(true);	//设置成校验过了。
	}

	/**
	 * 新增和修改记录是需要验证对象长度
	 * @param analyzeFileDO
	 * @param sb
	 * @return
	 */
	private static StringBuffer validateAnalyzeFileDOFieldLength(AnalyzeFileDO analyzeFileDO,StringBuffer sb) {
		sb = checkLength(analyzeFileDO.getFilename(),BYTELENGTH_OF_FILENAME,sb,"filename");
		return sb;
	}
	
	/**
	 * 修改记录时验证ID不为空及字段长度
	 * @param analyzeFileDO
	 * @throws IllegalArgumentException
	 */
	public static void updateAnalyzeFileDO(AnalyzeFileDO analyzeFileDO) throws IllegalArgumentException{
		if (null == analyzeFileDO || analyzeFileDO.getId() == null||analyzeFileDO.getId()<1) {
			throw new IllegalArgumentException("updateAnalyzeFileDO Parameter verify not correct,analyzeFileDO:" + analyzeFileDO);
		}
		if(analyzeFileDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validateAnalyzeFileDOFieldLength(analyzeFileDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("updateAnalyzeFileDO Parameter verify not correct,analyzeFileDO:" + sb.toString());
		}
		analyzeFileDO.setValidate(true);	//设置成校验过了。
	}
	
	/**
	 * 批量修改记录时验证IDList不为空及字段长度
	 * @param analyzeFileDO
	 * @throws IllegalArgumentException
	 */
	public static void updateAnalyzeFileDOList(AnalyzeFileDO analyzeFileDO) throws IllegalArgumentException{
		if (null == analyzeFileDO || analyzeFileDO.getIdList() == null||analyzeFileDO.getIdList().isEmpty()) {
			throw new IllegalArgumentException("batch updateAnalyzeFileDO Parameter verify not correct,analyzeFileDO:" + analyzeFileDO);
		}
		if(analyzeFileDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validateAnalyzeFileDOFieldLength(analyzeFileDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("batch updateAnalyzeFileDOList Parameter verify not correct,analyzeFileDO:" + sb.toString());
		}
		analyzeFileDO.setValidate(true);	//设置成校验过了。
	}
	
	/**
	 * 单个删除记录时验证ID不为空
	 * @param id
	 * @throws IllegalArgumentException
	 */
	public static void deleteAnalyzeFileDO(Long id) throws IllegalArgumentException{
		if (null == id || id < 1) {
			throw new IllegalArgumentException("deleteAnalyzeFileDO Parameter verify not correct,id:" + id);
		}
	}
	
	/**
	 * 批量删除记录时验证IDList不为空
	 * @param analyzeFileQuery
	 * @throws IllegalArgumentException
	 */
	public static void deleteAnalyzeFileDOList(AnalyzeFileQuery analyzeFileQuery) throws IllegalArgumentException{
		if (null == analyzeFileQuery || analyzeFileQuery.getIdList() == null||analyzeFileQuery.getIdList().isEmpty()) {
			throw new IllegalArgumentException("deleteAnalyzeFileDO Parameter verify not correct,analyzeFileQuery:" + analyzeFileQuery);
		}
	}
	
}
