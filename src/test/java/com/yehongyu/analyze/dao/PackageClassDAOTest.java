package com.yehongyu.analyze.dao;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.yehongyu.analyze.BaseDAOTestCase;
import com.yehongyu.analyze.dao.domain.PackageClassDO;
import com.yehongyu.analyze.dao.ibatis.PackageClassDAO;
import com.yehongyu.analyze.dao.query.PackageClassQuery;

/**
 * package_class测试类
 * @author yingyang
 * @since 2011-11-16
 */
public class PackageClassDAOTest extends BaseDAOTestCase {
	@Resource
	private PackageClassDAO packageClassDAO;

	@Test
	public final void testInsertUpdateQueryDeletePackageClassDO() {
		//准备测试数据
		PackageClassDO packageClassDO = new PackageClassDO();
		packageClassDO.setModulePath("s2");	/*module_path*/
		packageClassDO.setPackageName("s3");	/*package_name*/
		packageClassDO.setClassName("s4");	/*class_name*/
		packageClassDO.setFileName("s7");	/*file_name*/
		Long id = null;
		try {
			//插入数据
			id = packageClassDAO.insertPackageClassDO(packageClassDO);
			if(id!=null){
				//更新数据测试
				packageClassDO = new PackageClassDO();
				packageClassDO.setId(id);
				packageClassDO.setModulePath("ms2");	/*module_path*/
				packageClassDO.setPackageName("ms3");	/*package_name*/
				packageClassDO.setClassName("ms4");	/*class_name*/
				packageClassDO.setFileName("ms7");	/*file_name*/
				Integer rsUpdate = packageClassDAO.updatePackageClassDO(packageClassDO);
				Assert.assertEquals(1, rsUpdate.intValue());
				//查询测试
				PackageClassQuery packageClassQuery = new PackageClassQuery();
				packageClassQuery.setId(id);
				PackageClassDO queryRs = packageClassDAO.getPackageClassDO(packageClassQuery);
				Assert.assertEquals("ms2", queryRs.getModulePath());	/*module_path*/
				Assert.assertEquals("ms3", queryRs.getPackageName());	/*package_name*/
				Assert.assertEquals("ms4", queryRs.getClassName());	/*class_name*/
				Assert.assertEquals("ms7", queryRs.getFileName());	/*file_name*/
				//删除数据测试
				Integer rsDelete = packageClassDAO.deletePackageClassDO(id);
				Assert.assertEquals(1, rsDelete.intValue());
			}else{
				Assert.assertFalse("happen Exception,not insert demo data", true);
			}
		} catch (Exception e) {
			logger.error("testInsertUpdateQueryDeletePackageClassDO() error", e);
			Assert.assertFalse("happen Exception", true);
		} finally {
			if(id!=null){
				try {
					packageClassDAO.deletePackageClassDO(id);
				} catch (Exception e) {
					logger.error("testInsertUpdateQueryDeletePackageClassDO() error at finally delete demo data", e);
					Assert.assertFalse("happen Exception", true);
				}
			}
		}
	}

	@Test
	public final void testInsertUpdateQueryWithPageDeletePackageClassDOList() {
		//准备测试数据
		PackageClassDO packageClassDO = new PackageClassDO();
		packageClassDO.setModulePath("s2");	/*module_path*/
		packageClassDO.setPackageName("s3");	/*package_name*/
		packageClassDO.setClassName("s4");	/*class_name*/
		packageClassDO.setFileName("s7");	/*file_name*/
		Long id = null;
		try {
			//插入数据
			id = packageClassDAO.insertPackageClassDO(packageClassDO);
			if(id!=null){
				//批量更新数据测试
				packageClassDO = new PackageClassDO();
				packageClassDO.addIdList(id);
				packageClassDO.setModulePath("ms2");	/*module_path*/
				packageClassDO.setPackageName("ms3");	/*package_name*/
				packageClassDO.setClassName("ms4");	/*class_name*/
				packageClassDO.setFileName("ms7");	/*file_name*/
				Integer rs = packageClassDAO.updatePackageClassDOList(packageClassDO);
				Assert.assertEquals(1, rs.intValue());
				//批量查询测试
				PackageClassQuery packageClassQuery = new PackageClassQuery();
				packageClassQuery.addIdList(id);
				packageClassQuery.orderbyId(false);
				packageClassQuery.orderbyModulePath(false);
				packageClassQuery.orderbyPackageName(false);
				packageClassQuery.orderbyClassName(false);
				packageClassQuery.orderbyGmtCreate(false);
				packageClassQuery.orderbyGmtModified(false);
				packageClassQuery.orderbyFileName(false);
				List<PackageClassDO> queryRs = packageClassDAO.getPackageClassDOList(packageClassQuery);
				Assert.assertEquals(1,queryRs.size());
				Assert.assertEquals("ms2", queryRs.get(0).getModulePath());	/*module_path*/
				Assert.assertEquals("ms3", queryRs.get(0).getPackageName());	/*package_name*/
				Assert.assertEquals("ms4", queryRs.get(0).getClassName());	/*class_name*/
				Assert.assertEquals("ms7", queryRs.get(0).getFileName());	/*file_name*/
				//分页查询测试
				packageClassQuery = new PackageClassQuery();
				packageClassQuery.addIdList(id);
				packageClassQuery.orderbyId(true);
				packageClassQuery.orderbyModulePath(true);
				packageClassQuery.orderbyPackageName(true);
				packageClassQuery.orderbyClassName(true);
				packageClassQuery.orderbyGmtCreate(true);
				packageClassQuery.orderbyGmtModified(true);
				packageClassQuery.orderbyFileName(true);
				List<PackageClassDO> queryRsWithPage = packageClassDAO.getPackageClassDOListWithPage(packageClassQuery);
				Assert.assertEquals(1,queryRsWithPage.size());
				Assert.assertEquals("ms2", queryRs.get(0).getModulePath());	/*module_path*/
				Assert.assertEquals("ms3", queryRs.get(0).getPackageName());	/*package_name*/
				Assert.assertEquals("ms4", queryRs.get(0).getClassName());	/*class_name*/
				Assert.assertEquals("ms7", queryRs.get(0).getFileName());	/*file_name*/
				//删除数据测试
				packageClassQuery = new PackageClassQuery();
				packageClassQuery.addIdList(id);
				Integer rsDelete = packageClassDAO.deletePackageClassDOList(packageClassQuery);
				Assert.assertEquals(1, rsDelete.intValue());
			}else{
				Assert.assertFalse("happen Exception,not insert demo data", true);
			}
		} catch (Exception e) {
			logger.error("testInsertUpdateQueryWithPageDeletePackageClassDOList() error", e);
			Assert.assertFalse("happen Exception", true);
		} finally{
			if(id!=null){
				try {
					packageClassDAO.deletePackageClassDO(id);
				} catch (Exception e) {
					logger.error("testInsertUpdateQueryWithPageDeletePackageClassDOList() error at finally delete demo data", e);
					Assert.assertFalse("happen Exception", true);
				}
			}
		}
	}

}
