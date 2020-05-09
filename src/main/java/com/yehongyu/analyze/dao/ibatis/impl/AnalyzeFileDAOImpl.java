package com.yehongyu.analyze.dao.ibatis.impl;

import java.util.List;

import javax.annotation.Resource;

import com.yehongyu.analyze.dao.domain.AnalyzeFileDO;
import com.yehongyu.analyze.dao.ibatis.BaseDAO;
import com.yehongyu.analyze.dao.ibatis.AnalyzeFileDAO;
import com.yehongyu.analyze.dao.query.AnalyzeFileQuery;
import com.yehongyu.analyze.dao.validate.AnalyzeFileValidate;

/**
 * analyze_file操作实现类
 * @author yingyang
 * @since 2011-11-16
 */
public class AnalyzeFileDAOImpl implements AnalyzeFileDAO {
	@Resource
	private BaseDAO baseDAO;
	
	public AnalyzeFileDO getAnalyzeFileDO(AnalyzeFileQuery analyzeFileQuery){
		AnalyzeFileValidate.getAnalyzeFileDO(analyzeFileQuery);
		return (AnalyzeFileDO)baseDAO.getSqlMapClientTemplate().queryForObject("AnalyzeFileDAO.getAnalyzeFileDO", analyzeFileQuery);
	}
	
	@SuppressWarnings("unchecked")
	public List<AnalyzeFileDO> getAnalyzeFileDOList(AnalyzeFileQuery analyzeFileQuery){
		if(analyzeFileQuery==null) analyzeFileQuery = new AnalyzeFileQuery();
		AnalyzeFileValidate.getAnalyzeFileDOList(analyzeFileQuery);
		//如果是Oracle且查询条件有IdList,则SQL语句要优化下
		return (List<AnalyzeFileDO>)baseDAO.getSqlMapClientTemplate().queryForList("AnalyzeFileDAO.getAnalyzeFileDOList", analyzeFileQuery);
	}

	@SuppressWarnings("unchecked")
	public List<AnalyzeFileDO> getAnalyzeFileDOListWithPage(AnalyzeFileQuery analyzeFileQuery){
		if(analyzeFileQuery==null) analyzeFileQuery = new AnalyzeFileQuery();
		AnalyzeFileValidate.getAnalyzeFileDOListWithPage(analyzeFileQuery);
		//如果是Oracle且查询条件有IdList,则SQL语句要优化下
		int count = (Integer)baseDAO.getSqlMapClientTemplate().queryForObject("AnalyzeFileDAO.getAnalyzeFileDOListCount",analyzeFileQuery);
		analyzeFileQuery.setTotalItem(count);
		return (List<AnalyzeFileDO>)baseDAO.getSqlMapClientTemplate().queryForList("AnalyzeFileDAO.getAnalyzeFileDOListWithPage", analyzeFileQuery);
	}

	public Long insertAnalyzeFileDO(AnalyzeFileDO analyzeFileDO){
		AnalyzeFileValidate.insertAnalyzeFileDO(analyzeFileDO);
		return (Long)baseDAO.getSqlMapClientTemplate().insert("AnalyzeFileDAO.insertAnalyzeFileDO", analyzeFileDO);
	}

	public Integer updateAnalyzeFileDO(AnalyzeFileDO analyzeFileDO){
		AnalyzeFileValidate.updateAnalyzeFileDO(analyzeFileDO);
		return baseDAO.getSqlMapClientTemplate().update("AnalyzeFileDAO.updateAnalyzeFileDO", analyzeFileDO);
	}

	public Integer updateAnalyzeFileDOList(AnalyzeFileDO analyzeFileDO){
		AnalyzeFileValidate.updateAnalyzeFileDOList(analyzeFileDO);
		return baseDAO.getSqlMapClientTemplate().update("AnalyzeFileDAO.updateAnalyzeFileDOList", analyzeFileDO);
	}
	
	public Integer deleteAnalyzeFileDO(Long id){
		AnalyzeFileValidate.deleteAnalyzeFileDO(id);
		return baseDAO.getSqlMapClientTemplate().delete("AnalyzeFileDAO.deleteAnalyzeFileDO", id);
	}
	
	public Integer deleteAnalyzeFileDOList(AnalyzeFileQuery analyzeFileQuery){
		AnalyzeFileValidate.deleteAnalyzeFileDOList(analyzeFileQuery);
		return baseDAO.getSqlMapClientTemplate().delete("AnalyzeFileDAO.deleteAnalyzeFileDOList", analyzeFileQuery);
	}

}
