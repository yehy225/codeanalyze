package com.yehongyu.analyze.dao.validate;

import com.yehongyu.analyze.dao.domain.ClassRefDO;
import com.yehongyu.analyze.dao.query.ClassRefQuery;

/**
 * class_ref校验类
 * 将在×ServiceClient、×ServiceImpl、×DAOImpl三层共同统一校验机制
 * @author yingyang
 * @since 2011-11-16
 */
public class ClassRefValidate extends BaseValidate {
	
	//ClassRef字符字段长度值
	public final static int BYTELENGTH_OF_CLASS_NAME = 200;
	public final static int BYTELENGTH_OF_REF_CLASS = 200;
	
	/**
	 * 单个查询条件验证ID不为空
	 * @param classRefQuery
	 * @throws IllegalArgumentException
	 */
	public static void getClassRefDO(ClassRefQuery classRefQuery) throws IllegalArgumentException{
		if(classRefQuery==null||classRefQuery.getId()==null || classRefQuery.getId()<=0){
			throw new IllegalArgumentException("classRefQuery Parameter is not correct,classRefQuery:" + classRefQuery);
		}
	}
	
	/**
	 * 批量查询条件不校验
	 * @param classRefQuery
	 * @throws IllegalArgumentException
	 */
	public static void getClassRefDOList(ClassRefQuery classRefQuery) throws IllegalArgumentException{

	}
	
	/**
	 * 批量翻页查询条件不校验
	 * @param classRefQuery
	 * @throws IllegalArgumentException
	 */
	public static void getClassRefDOListWithPage(ClassRefQuery classRefQuery) throws IllegalArgumentException{

	}
	
	/**
	 * 新增记录对象校验不为空，长度校验
	 * @param classRefDO
	 * @throws IllegalArgumentException
	 */
	public static void insertClassRefDO(ClassRefDO classRefDO) throws IllegalArgumentException{
		if (null == classRefDO) {
			throw new IllegalArgumentException("classRefDO Parameter is null!");
		}
		if(classRefDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validateClassRefDOFieldLength(classRefDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("insertClassRefDO Parameter verify not correct,classRefDO:"+sb.toString());
		}
		classRefDO.setValidate(true);	//设置成校验过了。
	}

	/**
	 * 新增和修改记录是需要验证对象长度
	 * @param classRefDO
	 * @param sb
	 * @return
	 */
	private static StringBuffer validateClassRefDOFieldLength(ClassRefDO classRefDO,StringBuffer sb) {
		sb = checkLength(classRefDO.getClassName(),BYTELENGTH_OF_CLASS_NAME,sb,"className");
		sb = checkLength(classRefDO.getRefClass(),BYTELENGTH_OF_REF_CLASS,sb,"refClass");
		return sb;
	}
	
	/**
	 * 修改记录时验证ID不为空及字段长度
	 * @param classRefDO
	 * @throws IllegalArgumentException
	 */
	public static void updateClassRefDO(ClassRefDO classRefDO) throws IllegalArgumentException{
		if (null == classRefDO || classRefDO.getId() == null||classRefDO.getId()<1) {
			throw new IllegalArgumentException("updateClassRefDO Parameter verify not correct,classRefDO:" + classRefDO);
		}
		if(classRefDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validateClassRefDOFieldLength(classRefDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("updateClassRefDO Parameter verify not correct,classRefDO:" + sb.toString());
		}
		classRefDO.setValidate(true);	//设置成校验过了。
	}
	
	/**
	 * 批量修改记录时验证IDList不为空及字段长度
	 * @param classRefDO
	 * @throws IllegalArgumentException
	 */
	public static void updateClassRefDOList(ClassRefDO classRefDO) throws IllegalArgumentException{
		if (null == classRefDO || classRefDO.getIdList() == null||classRefDO.getIdList().isEmpty()) {
			throw new IllegalArgumentException("batch updateClassRefDO Parameter verify not correct,classRefDO:" + classRefDO);
		}
		if(classRefDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validateClassRefDOFieldLength(classRefDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("batch updateClassRefDOList Parameter verify not correct,classRefDO:" + sb.toString());
		}
		classRefDO.setValidate(true);	//设置成校验过了。
	}
	
	/**
	 * 单个删除记录时验证ID不为空
	 * @param id
	 * @throws IllegalArgumentException
	 */
	public static void deleteClassRefDO(Long id) throws IllegalArgumentException{
		if (null == id || id < 1) {
			throw new IllegalArgumentException("deleteClassRefDO Parameter verify not correct,id:" + id);
		}
	}
	
	/**
	 * 批量删除记录时验证IDList不为空
	 * @param classRefQuery
	 * @throws IllegalArgumentException
	 */
	public static void deleteClassRefDOList(ClassRefQuery classRefQuery) throws IllegalArgumentException{
		if (null == classRefQuery || classRefQuery.getIdList() == null||classRefQuery.getIdList().isEmpty()) {
			throw new IllegalArgumentException("deleteClassRefDO Parameter verify not correct,classRefQuery:" + classRefQuery);
		}
	}
	
}
