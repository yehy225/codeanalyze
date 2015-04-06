package com.yehongyu.analyze.dao.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * DAO基类
 * @author yingyang
 * @since 2011-11-16
 */
public class BaseDAO {
	
	/** 数据库操作对象 */
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

}
