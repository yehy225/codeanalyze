package com.yehongyu.analyze.dao.ibatis;

import java.util.List;

import com.yehongyu.analyze.dao.domain.PackageClassDO;
import com.yehongyu.analyze.dao.query.PackageClassQuery;

/**
 * package_class操作类
 * @author yingyang
 * @since 2011-11-16
 */
public interface PackageClassDAO {

	/**
	 * 获取package_class记录
	 * @param packageClassQuery
	 * @return 唯一记录
	 */
	PackageClassDO getPackageClassDO(PackageClassQuery packageClassQuery);

	/**
	 * 获取package_class记录列表
	 * @param packageClassQuery
	 * @return 记录列表
	 */
	List<PackageClassDO> getPackageClassDOList(PackageClassQuery packageClassQuery);

	/**
	 * 按分页获取package_class记录列表
	 * @param packageClassQuery
	 * @return 记录列表
	 */
	List<PackageClassDO> getPackageClassDOListWithPage(PackageClassQuery packageClassQuery);

	/**
	 * 插入package_class记录
	 * @param packageClassDO
	 * @return 插入成功的条数
	 */
	Long insertPackageClassDO(PackageClassDO packageClassDO);
	
	/**
	 * 按ID更新package_class记录
	 * @param packageClassDO
	 * @return 成功更新的条数，正常为1
	 */
	Integer updatePackageClassDO(PackageClassDO packageClassDO);
	
	/**
	 * 按idList批量更新package_class记录
	 * @param packageClassDO
	 * @return 成功更新的条数
	 */
	Integer updatePackageClassDOList(PackageClassDO packageClassDO);

	/**
	 * 删除package_class记录
	 * @param id
	 * @return 成功删除的条数
	 */
	Integer deletePackageClassDO(Long id) ;

	/**
	 * 按条件批量删除package_class记录
	 * @param packageClassQuery
	 * @return 成功删除的条数
	 */
	Integer deletePackageClassDOList(PackageClassQuery packageClassQuery) ;
}
