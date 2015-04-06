package com.yehongyu.analyze.dao.ibatis.impl;

import java.util.List;

import javax.annotation.Resource;

import com.yehongyu.analyze.dao.domain.PackageClassDO;
import com.yehongyu.analyze.dao.ibatis.BaseDAO;
import com.yehongyu.analyze.dao.ibatis.PackageClassDAO;
import com.yehongyu.analyze.dao.query.PackageClassQuery;
import com.yehongyu.analyze.dao.validate.PackageClassValidate;

/**
 * package_class操作实现类
 * @author yingyang
 * @since 2011-11-16
 */
public class PackageClassDAOImpl implements PackageClassDAO {
	@Resource
	private BaseDAO baseDAO;
	
	public PackageClassDO getPackageClassDO(PackageClassQuery packageClassQuery){
		PackageClassValidate.getPackageClassDO(packageClassQuery);
		return (PackageClassDO)baseDAO.getSqlMapClientTemplate().queryForObject("PackageClassDAO.getPackageClassDO", packageClassQuery);
	}
	
	@SuppressWarnings("unchecked")
	public List<PackageClassDO> getPackageClassDOList(PackageClassQuery packageClassQuery){
		if(packageClassQuery==null) packageClassQuery = new PackageClassQuery();
		PackageClassValidate.getPackageClassDOList(packageClassQuery);
		//如果是Oracle且查询条件有IdList,则SQL语句要优化下
		return (List<PackageClassDO>)baseDAO.getSqlMapClientTemplate().queryForList("PackageClassDAO.getPackageClassDOList", packageClassQuery);
	}

	@SuppressWarnings("unchecked")
	public List<PackageClassDO> getPackageClassDOListWithPage(PackageClassQuery packageClassQuery){
		if(packageClassQuery==null) packageClassQuery = new PackageClassQuery();
		PackageClassValidate.getPackageClassDOListWithPage(packageClassQuery);
		//如果是Oracle且查询条件有IdList,则SQL语句要优化下
		int count = (Integer)baseDAO.getSqlMapClientTemplate().queryForObject("PackageClassDAO.getPackageClassDOListCount",packageClassQuery);
		packageClassQuery.setTotalItem(count);
		return (List<PackageClassDO>)baseDAO.getSqlMapClientTemplate().queryForList("PackageClassDAO.getPackageClassDOListWithPage", packageClassQuery);
	}

	public Long insertPackageClassDO(PackageClassDO packageClassDO){
		PackageClassValidate.insertPackageClassDO(packageClassDO);
		return (Long)baseDAO.getSqlMapClientTemplate().insert("PackageClassDAO.insertPackageClassDO", packageClassDO);
	}

	public Integer updatePackageClassDO(PackageClassDO packageClassDO){
		PackageClassValidate.updatePackageClassDO(packageClassDO);
		return baseDAO.getSqlMapClientTemplate().update("PackageClassDAO.updatePackageClassDO", packageClassDO);
	}

	public Integer updatePackageClassDOList(PackageClassDO packageClassDO){
		PackageClassValidate.updatePackageClassDOList(packageClassDO);
		return baseDAO.getSqlMapClientTemplate().update("PackageClassDAO.updatePackageClassDOList", packageClassDO);
	}
	
	public Integer deletePackageClassDO(Long id){
		PackageClassValidate.deletePackageClassDO(id);
		return baseDAO.getSqlMapClientTemplate().delete("PackageClassDAO.deletePackageClassDO", id);
	}
	
	public Integer deletePackageClassDOList(PackageClassQuery packageClassQuery){
		PackageClassValidate.deletePackageClassDOList(packageClassQuery);
		return baseDAO.getSqlMapClientTemplate().delete("PackageClassDAO.deletePackageClassDOList", packageClassQuery);
	}

}
