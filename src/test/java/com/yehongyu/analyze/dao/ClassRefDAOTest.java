package com.yehongyu.analyze.dao;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.yehongyu.analyze.BaseDAOTestCase;
import com.yehongyu.analyze.dao.domain.ClassRefDO;
import com.yehongyu.analyze.dao.ibatis.ClassRefDAO;
import com.yehongyu.analyze.dao.query.ClassRefQuery;

/**
 * class_ref测试类
 * @author yingyang
 * @since 2011-11-16
 */
public class ClassRefDAOTest extends BaseDAOTestCase {
	@Resource
	private ClassRefDAO classRefDAO;

	@Test
	public final void testInsertUpdateQueryDeleteClassRefDO() {
		//准备测试数据
		ClassRefDO classRefDO = new ClassRefDO();
		classRefDO.setClassName("s2");	/*class_name*/
		classRefDO.setRefClass("s3");	/*ref_class*/
		Long id = null;
		try {
			//插入数据
			id = classRefDAO.insertClassRefDO(classRefDO);
			if(id!=null){
				//更新数据测试
				classRefDO = new ClassRefDO();
				classRefDO.setId(id);
				classRefDO.setClassName("ms2");	/*class_name*/
				classRefDO.setRefClass("ms3");	/*ref_class*/
				Integer rsUpdate = classRefDAO.updateClassRefDO(classRefDO);
				Assert.assertEquals(1, rsUpdate.intValue());
				//查询测试
				ClassRefQuery classRefQuery = new ClassRefQuery();
				classRefQuery.setId(id);
				ClassRefDO queryRs = classRefDAO.getClassRefDO(classRefQuery);
				Assert.assertEquals("ms2", queryRs.getClassName());	/*class_name*/
				Assert.assertEquals("ms3", queryRs.getRefClass());	/*ref_class*/
				//删除数据测试
				Integer rsDelete = classRefDAO.deleteClassRefDO(id);
				Assert.assertEquals(1, rsDelete.intValue());
			}else{
				Assert.assertFalse("happen Exception,not insert demo data", true);
			}
		} catch (Exception e) {
			logger.error("testInsertUpdateQueryDeleteClassRefDO() error", e);
			Assert.assertFalse("happen Exception", true);
		} finally {
			if(id!=null){
				try {
					classRefDAO.deleteClassRefDO(id);
				} catch (Exception e) {
					logger.error("testInsertUpdateQueryDeleteClassRefDO() error at finally delete demo data", e);
					Assert.assertFalse("happen Exception", true);
				}
			}
		}
	}

	@Test
	public final void testInsertUpdateQueryWithPageDeleteClassRefDOList() {
		//准备测试数据
		ClassRefDO classRefDO = new ClassRefDO();
		classRefDO.setClassName("s2");	/*class_name*/
		classRefDO.setRefClass("s3");	/*ref_class*/
		Long id = null;
		try {
			//插入数据
			id = classRefDAO.insertClassRefDO(classRefDO);
			if(id!=null){
				//批量更新数据测试
				classRefDO = new ClassRefDO();
				classRefDO.addIdList(id);
				classRefDO.setClassName("ms2");	/*class_name*/
				classRefDO.setRefClass("ms3");	/*ref_class*/
				Integer rs = classRefDAO.updateClassRefDOList(classRefDO);
				Assert.assertEquals(1, rs.intValue());
				//批量查询测试
				ClassRefQuery classRefQuery = new ClassRefQuery();
				classRefQuery.addIdList(id);
				classRefQuery.orderbyId(false);
				classRefQuery.orderbyClassName(false);
				classRefQuery.orderbyRefClass(false);
				classRefQuery.orderbyGmtCreate(false);
				classRefQuery.orderbyGmtModified(false);
				List<ClassRefDO> queryRs = classRefDAO.getClassRefDOList(classRefQuery);
				Assert.assertEquals(1,queryRs.size());
				Assert.assertEquals("ms2", queryRs.get(0).getClassName());	/*class_name*/
				Assert.assertEquals("ms3", queryRs.get(0).getRefClass());	/*ref_class*/
				//分页查询测试
				classRefQuery = new ClassRefQuery();
				classRefQuery.addIdList(id);
				classRefQuery.orderbyId(true);
				classRefQuery.orderbyClassName(true);
				classRefQuery.orderbyRefClass(true);
				classRefQuery.orderbyGmtCreate(true);
				classRefQuery.orderbyGmtModified(true);
				List<ClassRefDO> queryRsWithPage = classRefDAO.getClassRefDOListWithPage(classRefQuery);
				Assert.assertEquals(1,queryRsWithPage.size());
				Assert.assertEquals("ms2", queryRs.get(0).getClassName());	/*class_name*/
				Assert.assertEquals("ms3", queryRs.get(0).getRefClass());	/*ref_class*/
				//删除数据测试
				classRefQuery = new ClassRefQuery();
				classRefQuery.addIdList(id);
				Integer rsDelete = classRefDAO.deleteClassRefDOList(classRefQuery);
				Assert.assertEquals(1, rsDelete.intValue());
			}else{
				Assert.assertFalse("happen Exception,not insert demo data", true);
			}
		} catch (Exception e) {
			logger.error("testInsertUpdateQueryWithPageDeleteClassRefDOList() error", e);
			Assert.assertFalse("happen Exception", true);
		} finally{
			if(id!=null){
				try {
					classRefDAO.deleteClassRefDO(id);
				} catch (Exception e) {
					logger.error("testInsertUpdateQueryWithPageDeleteClassRefDOList() error at finally delete demo data", e);
					Assert.assertFalse("happen Exception", true);
				}
			}
		}
	}

}
