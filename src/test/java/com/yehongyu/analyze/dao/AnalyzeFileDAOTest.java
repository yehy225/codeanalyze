package com.yehongyu.analyze.dao;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.yehongyu.analyze.BaseDAOTestCase;
import com.yehongyu.analyze.dao.domain.AnalyzeFileDO;
import com.yehongyu.analyze.dao.ibatis.AnalyzeFileDAO;
import com.yehongyu.analyze.dao.query.AnalyzeFileQuery;

/**
 * analyze_file测试类
 * @author yingyang
 * @since 2011-11-16
 */
public class AnalyzeFileDAOTest extends BaseDAOTestCase {
	@Resource
	private AnalyzeFileDAO analyzeFileDAO;

	@Test
	public final void testInsertUpdateQueryDeleteAnalyzeFileDO() {
		//准备测试数据
		AnalyzeFileDO analyzeFileDO = new AnalyzeFileDO();
		analyzeFileDO.setFilename("s2");	/*filename*/
		analyzeFileDO.setLinecount(3);	/*linecount*/
		analyzeFileDO.setCodecount(4);	/*codecount*/
		analyzeFileDO.setCommentcount(5);	/*commentcount*/
		analyzeFileDO.setBlankcount(6);	/*blankcount*/
		Long id = null;
		try {
			//插入数据
			id = analyzeFileDAO.insertAnalyzeFileDO(analyzeFileDO);
			if(id!=null){
				//更新数据测试
				analyzeFileDO = new AnalyzeFileDO();
				analyzeFileDO.setId(id);
				analyzeFileDO.setFilename("ms2");	/*filename*/
				analyzeFileDO.setLinecount(13);	/*linecount*/
				analyzeFileDO.setCodecount(14);	/*codecount*/
				analyzeFileDO.setCommentcount(15);	/*commentcount*/
				analyzeFileDO.setBlankcount(16);	/*blankcount*/
				Integer rsUpdate = analyzeFileDAO.updateAnalyzeFileDO(analyzeFileDO);
				Assert.assertEquals(1, rsUpdate.intValue());
				//查询测试
				AnalyzeFileQuery analyzeFileQuery = new AnalyzeFileQuery();
				analyzeFileQuery.setId(id);
				AnalyzeFileDO queryRs = analyzeFileDAO.getAnalyzeFileDO(analyzeFileQuery);
				Assert.assertEquals("ms2", queryRs.getFilename());	/*filename*/
				Assert.assertEquals(13, queryRs.getLinecount().intValue());	/*linecount*/
				Assert.assertEquals(14, queryRs.getCodecount().intValue());	/*codecount*/
				Assert.assertEquals(15, queryRs.getCommentcount().intValue());	/*commentcount*/
				Assert.assertEquals(16, queryRs.getBlankcount().intValue());	/*blankcount*/
				//删除数据测试
				Integer rsDelete = analyzeFileDAO.deleteAnalyzeFileDO(id);
				Assert.assertEquals(1, rsDelete.intValue());
			}else{
				Assert.assertFalse("happen Exception,not insert demo data", true);
			}
		} catch (Exception e) {
			logger.error("testInsertUpdateQueryDeleteAnalyzeFileDO() error", e);
			Assert.assertFalse("happen Exception", true);
		} finally {
			if(id!=null){
				try {
					analyzeFileDAO.deleteAnalyzeFileDO(id);
				} catch (Exception e) {
					logger.error("testInsertUpdateQueryDeleteAnalyzeFileDO() error at finally delete demo data", e);
					Assert.assertFalse("happen Exception", true);
				}
			}
		}
	}

	@Test
	public final void testInsertUpdateQueryWithPageDeleteAnalyzeFileDOList() {
		//准备测试数据
		AnalyzeFileDO analyzeFileDO = new AnalyzeFileDO();
		analyzeFileDO.setFilename("s2");	/*filename*/
		analyzeFileDO.setLinecount(3);	/*linecount*/
		analyzeFileDO.setCodecount(4);	/*codecount*/
		analyzeFileDO.setCommentcount(5);	/*commentcount*/
		analyzeFileDO.setBlankcount(6);	/*blankcount*/
		Long id = null;
		try {
			//插入数据
			id = analyzeFileDAO.insertAnalyzeFileDO(analyzeFileDO);
			if(id!=null){
				//批量更新数据测试
				analyzeFileDO = new AnalyzeFileDO();
				analyzeFileDO.addIdList(id);
				analyzeFileDO.setFilename("ms2");	/*filename*/
				analyzeFileDO.setLinecount(13);	/*linecount*/
				analyzeFileDO.setCodecount(14);	/*codecount*/
				analyzeFileDO.setCommentcount(15);	/*commentcount*/
				analyzeFileDO.setBlankcount(16);	/*blankcount*/
				Integer rs = analyzeFileDAO.updateAnalyzeFileDOList(analyzeFileDO);
				Assert.assertEquals(1, rs.intValue());
				//批量查询测试
				AnalyzeFileQuery analyzeFileQuery = new AnalyzeFileQuery();
				analyzeFileQuery.addIdList(id);
				analyzeFileQuery.orderbyId(false);
				analyzeFileQuery.orderbyFilename(false);
				analyzeFileQuery.orderbyLinecount(false);
				analyzeFileQuery.orderbyCodecount(false);
				analyzeFileQuery.orderbyCommentcount(false);
				analyzeFileQuery.orderbyBlankcount(false);
				analyzeFileQuery.orderbyGmtCreate(false);
				analyzeFileQuery.orderbyGmtModified(false);
				List<AnalyzeFileDO> queryRs = analyzeFileDAO.getAnalyzeFileDOList(analyzeFileQuery);
				Assert.assertEquals(1,queryRs.size());
				Assert.assertEquals("ms2", queryRs.get(0).getFilename());	/*filename*/
				Assert.assertEquals(13, queryRs.get(0).getLinecount().intValue());	/*linecount*/
				Assert.assertEquals(14, queryRs.get(0).getCodecount().intValue());	/*codecount*/
				Assert.assertEquals(15, queryRs.get(0).getCommentcount().intValue());	/*commentcount*/
				Assert.assertEquals(16, queryRs.get(0).getBlankcount().intValue());	/*blankcount*/
				//分页查询测试
				analyzeFileQuery = new AnalyzeFileQuery();
				analyzeFileQuery.addIdList(id);
				analyzeFileQuery.orderbyId(true);
				analyzeFileQuery.orderbyFilename(true);
				analyzeFileQuery.orderbyLinecount(true);
				analyzeFileQuery.orderbyCodecount(true);
				analyzeFileQuery.orderbyCommentcount(true);
				analyzeFileQuery.orderbyBlankcount(true);
				analyzeFileQuery.orderbyGmtCreate(true);
				analyzeFileQuery.orderbyGmtModified(true);
				List<AnalyzeFileDO> queryRsWithPage = analyzeFileDAO.getAnalyzeFileDOListWithPage(analyzeFileQuery);
				Assert.assertEquals(1,queryRsWithPage.size());
				Assert.assertEquals("ms2", queryRs.get(0).getFilename());	/*filename*/
				Assert.assertEquals(13, queryRs.get(0).getLinecount().intValue());	/*linecount*/
				Assert.assertEquals(14, queryRs.get(0).getCodecount().intValue());	/*codecount*/
				Assert.assertEquals(15, queryRs.get(0).getCommentcount().intValue());	/*commentcount*/
				Assert.assertEquals(16, queryRs.get(0).getBlankcount().intValue());	/*blankcount*/
				//删除数据测试
				analyzeFileQuery = new AnalyzeFileQuery();
				analyzeFileQuery.addIdList(id);
				Integer rsDelete = analyzeFileDAO.deleteAnalyzeFileDOList(analyzeFileQuery);
				Assert.assertEquals(1, rsDelete.intValue());
			}else{
				Assert.assertFalse("happen Exception,not insert demo data", true);
			}
		} catch (Exception e) {
			logger.error("testInsertUpdateQueryWithPageDeleteAnalyzeFileDOList() error", e);
			Assert.assertFalse("happen Exception", true);
		} finally{
			if(id!=null){
				try {
					analyzeFileDAO.deleteAnalyzeFileDO(id);
				} catch (Exception e) {
					logger.error("testInsertUpdateQueryWithPageDeleteAnalyzeFileDOList() error at finally delete demo data", e);
					Assert.assertFalse("happen Exception", true);
				}
			}
		}
	}

}
