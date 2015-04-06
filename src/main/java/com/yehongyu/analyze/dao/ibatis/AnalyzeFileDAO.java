package com.yehongyu.analyze.dao.ibatis;

import java.util.List;

import com.yehongyu.analyze.dao.domain.AnalyzeFileDO;
import com.yehongyu.analyze.dao.query.AnalyzeFileQuery;

/**
 * analyze_file操作类
 * @author yingyang
 * @since 2011-11-16
 */
public interface AnalyzeFileDAO {

	/**
	 * 获取analyze_file记录
	 * @param analyzeFileQuery
	 * @return 唯一记录
	 */
	AnalyzeFileDO getAnalyzeFileDO(AnalyzeFileQuery analyzeFileQuery);

	/**
	 * 获取analyze_file记录列表
	 * @param analyzeFileQuery
	 * @return 记录列表
	 */
	List<AnalyzeFileDO> getAnalyzeFileDOList(AnalyzeFileQuery analyzeFileQuery);

	/**
	 * 按分页获取analyze_file记录列表
	 * @param analyzeFileQuery
	 * @return 记录列表
	 */
	List<AnalyzeFileDO> getAnalyzeFileDOListWithPage(AnalyzeFileQuery analyzeFileQuery);

	/**
	 * 插入analyze_file记录
	 * @param analyzeFileDO
	 * @return 插入成功的条数
	 */
	Long insertAnalyzeFileDO(AnalyzeFileDO analyzeFileDO);
	
	/**
	 * 按ID更新analyze_file记录
	 * @param analyzeFileDO
	 * @return 成功更新的条数，正常为1
	 */
	Integer updateAnalyzeFileDO(AnalyzeFileDO analyzeFileDO);
	
	/**
	 * 按idList批量更新analyze_file记录
	 * @param analyzeFileDO
	 * @return 成功更新的条数
	 */
	Integer updateAnalyzeFileDOList(AnalyzeFileDO analyzeFileDO);

	/**
	 * 删除analyze_file记录
	 * @param id
	 * @return 成功删除的条数
	 */
	Integer deleteAnalyzeFileDO(Long id) ;

	/**
	 * 按条件批量删除analyze_file记录
	 * @param analyzeFileQuery
	 * @return 成功删除的条数
	 */
	Integer deleteAnalyzeFileDOList(AnalyzeFileQuery analyzeFileQuery) ;
}
