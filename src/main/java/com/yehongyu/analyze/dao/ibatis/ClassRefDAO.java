package com.yehongyu.analyze.dao.ibatis;

import java.util.List;

import com.yehongyu.analyze.dao.domain.ClassRefDO;
import com.yehongyu.analyze.dao.query.ClassRefQuery;

/**
 * class_ref操作类
 * @author yingyang
 * @since 2011-11-16
 */
public interface ClassRefDAO {

	/**
	 * 获取class_ref记录
	 * @param classRefQuery
	 * @return 唯一记录
	 */
	ClassRefDO getClassRefDO(ClassRefQuery classRefQuery);

	/**
	 * 获取class_ref记录列表
	 * @param classRefQuery
	 * @return 记录列表
	 */
	List<ClassRefDO> getClassRefDOList(ClassRefQuery classRefQuery);

	/**
	 * 按分页获取class_ref记录列表
	 * @param classRefQuery
	 * @return 记录列表
	 */
	List<ClassRefDO> getClassRefDOListWithPage(ClassRefQuery classRefQuery);

	/**
	 * 插入class_ref记录
	 * @param classRefDO
	 * @return 插入成功的条数
	 */
	Long insertClassRefDO(ClassRefDO classRefDO);
	
	/**
	 * 按ID更新class_ref记录
	 * @param classRefDO
	 * @return 成功更新的条数，正常为1
	 */
	Integer updateClassRefDO(ClassRefDO classRefDO);
	
	/**
	 * 按idList批量更新class_ref记录
	 * @param classRefDO
	 * @return 成功更新的条数
	 */
	Integer updateClassRefDOList(ClassRefDO classRefDO);

	/**
	 * 删除class_ref记录
	 * @param id
	 * @return 成功删除的条数
	 */
	Integer deleteClassRefDO(Long id) ;

	/**
	 * 按条件批量删除class_ref记录
	 * @param classRefQuery
	 * @return 成功删除的条数
	 */
	Integer deleteClassRefDOList(ClassRefQuery classRefQuery) ;
}
