package com.yehongyu.analyze.dao.ibatis.impl;

import java.util.List;

import javax.annotation.Resource;

import com.yehongyu.analyze.dao.domain.ClassRefDO;
import com.yehongyu.analyze.dao.ibatis.BaseDAO;
import com.yehongyu.analyze.dao.ibatis.ClassRefDAO;
import com.yehongyu.analyze.dao.query.ClassRefQuery;
import com.yehongyu.analyze.dao.validate.ClassRefValidate;

/**
 * class_ref操作实现类
 * @author yingyang
 * @since 2011-11-16
 */
public class ClassRefDAOImpl implements ClassRefDAO {
	@Resource
	private BaseDAO baseDAO;
	
	public ClassRefDO getClassRefDO(ClassRefQuery classRefQuery){
		ClassRefValidate.getClassRefDO(classRefQuery);
		return (ClassRefDO)baseDAO.getSqlMapClientTemplate().queryForObject("ClassRefDAO.getClassRefDO", classRefQuery);
	}
	
	@SuppressWarnings("unchecked")
	public List<ClassRefDO> getClassRefDOList(ClassRefQuery classRefQuery){
		if(classRefQuery==null) classRefQuery = new ClassRefQuery();
		ClassRefValidate.getClassRefDOList(classRefQuery);
		//如果是Oracle且查询条件有IdList,则SQL语句要优化下
		return (List<ClassRefDO>)baseDAO.getSqlMapClientTemplate().queryForList("ClassRefDAO.getClassRefDOList", classRefQuery);
	}

	@SuppressWarnings("unchecked")
	public List<ClassRefDO> getClassRefDOListWithPage(ClassRefQuery classRefQuery){
		if(classRefQuery==null) classRefQuery = new ClassRefQuery();
		ClassRefValidate.getClassRefDOListWithPage(classRefQuery);
		//如果是Oracle且查询条件有IdList,则SQL语句要优化下
		int count = (Integer)baseDAO.getSqlMapClientTemplate().queryForObject("ClassRefDAO.getClassRefDOListCount",classRefQuery);
		classRefQuery.setTotalItem(count);
		return (List<ClassRefDO>)baseDAO.getSqlMapClientTemplate().queryForList("ClassRefDAO.getClassRefDOListWithPage", classRefQuery);
	}

	public Long insertClassRefDO(ClassRefDO classRefDO){
		ClassRefValidate.insertClassRefDO(classRefDO);
		return (Long)baseDAO.getSqlMapClientTemplate().insert("ClassRefDAO.insertClassRefDO", classRefDO);
	}

	public Integer updateClassRefDO(ClassRefDO classRefDO){
		ClassRefValidate.updateClassRefDO(classRefDO);
		return baseDAO.getSqlMapClientTemplate().update("ClassRefDAO.updateClassRefDO", classRefDO);
	}

	public Integer updateClassRefDOList(ClassRefDO classRefDO){
		ClassRefValidate.updateClassRefDOList(classRefDO);
		return baseDAO.getSqlMapClientTemplate().update("ClassRefDAO.updateClassRefDOList", classRefDO);
	}
	
	public Integer deleteClassRefDO(Long id){
		ClassRefValidate.deleteClassRefDO(id);
		return baseDAO.getSqlMapClientTemplate().delete("ClassRefDAO.deleteClassRefDO", id);
	}
	
	public Integer deleteClassRefDOList(ClassRefQuery classRefQuery){
		ClassRefValidate.deleteClassRefDOList(classRefQuery);
		return baseDAO.getSqlMapClientTemplate().delete("ClassRefDAO.deleteClassRefDOList", classRefQuery);
	}

}
