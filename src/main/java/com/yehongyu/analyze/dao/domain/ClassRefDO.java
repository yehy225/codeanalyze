package com.yehongyu.analyze.dao.domain;

import java.sql.Timestamp;

/**
 * class_ref
 * @author yingyang
 * @since 2011-11-16
 */
public class ClassRefDO extends BaseDO {

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Long id;
	/** class_name **/
    private String className;
	/** ref_class **/
    private String refClass;
	/** gmt_create **/
    private Timestamp gmtCreate;
	/** gmt_modified **/
    private Timestamp gmtModified;

	
   /**
    * 获取属性:id
    * id
    * @return id
    */
   public Long getId() {
       return id;
   }
   /**
    * 设置属性:id
    * id
    * @param id
    */
   public void setId(Long id) {
       this.id = id;
   }
	
   /**
    * 获取属性:className
    * class_name
    * @return className
    */
   public String getClassName() {
       return className;
   }
   /**
    * 设置属性:className
    * class_name
    * @param className
    */
   public void setClassName(String className) {
       this.className = className;
   }
	
   /**
    * 获取属性:refClass
    * ref_class
    * @return refClass
    */
   public String getRefClass() {
       return refClass;
   }
   /**
    * 设置属性:refClass
    * ref_class
    * @param refClass
    */
   public void setRefClass(String refClass) {
       this.refClass = refClass;
   }
	
   /**
    * 获取属性:gmtCreate
    * gmt_create
    * @return gmtCreate
    */
   public Timestamp getGmtCreate() {
       return gmtCreate;
   }
   /**
    * 设置属性:gmtCreate
    * gmt_create
    * @param gmtCreate
    */
   public void setGmtCreate(Timestamp gmtCreate) {
       this.gmtCreate = gmtCreate;
   }
	
   /**
    * 获取属性:gmtModified
    * gmt_modified
    * @return gmtModified
    */
   public Timestamp getGmtModified() {
       return gmtModified;
   }
   /**
    * 设置属性:gmtModified
    * gmt_modified
    * @param gmtModified
    */
   public void setGmtModified(Timestamp gmtModified) {
       this.gmtModified = gmtModified;
   }

}