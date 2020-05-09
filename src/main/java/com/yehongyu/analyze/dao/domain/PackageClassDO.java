package com.yehongyu.analyze.dao.domain;

import java.sql.Timestamp;

/**
 * package_class
 * @author yingyang
 * @since 2011-11-16
 */
public class PackageClassDO extends BaseDO {

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Long id;
	/** module_path **/
    private String modulePath;
	/** package_name **/
    private String packageName;
	/** class_name **/
    private String className;
	/** gmt_create **/
    private Timestamp gmtCreate;
	/** gmt_modified **/
    private Timestamp gmtModified;
	/** file_name **/
    private String fileName;

	
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
    * 获取属性:modulePath
    * module_path
    * @return modulePath
    */
   public String getModulePath() {
       return modulePath;
   }
   /**
    * 设置属性:modulePath
    * module_path
    * @param modulePath
    */
   public void setModulePath(String modulePath) {
       this.modulePath = modulePath;
   }
	
   /**
    * 获取属性:packageName
    * package_name
    * @return packageName
    */
   public String getPackageName() {
       return packageName;
   }
   /**
    * 设置属性:packageName
    * package_name
    * @param packageName
    */
   public void setPackageName(String packageName) {
       this.packageName = packageName;
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
	
   /**
    * 获取属性:fileName
    * file_name
    * @return fileName
    */
   public String getFileName() {
       return fileName;
   }
   /**
    * 设置属性:fileName
    * file_name
    * @param fileName
    */
   public void setFileName(String fileName) {
       this.fileName = fileName;
   }

}