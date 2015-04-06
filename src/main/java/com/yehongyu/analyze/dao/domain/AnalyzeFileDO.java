package com.yehongyu.analyze.dao.domain;

import java.sql.Timestamp;

/**
 * analyze_file
 * @author yingyang
 * @since 2011-11-16
 */
public class AnalyzeFileDO extends BaseDO {

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Long id;
	/** filename **/
    private String filename;
	/** linecount **/
    private Integer linecount;
	/** codecount **/
    private Integer codecount;
	/** commentcount **/
    private Integer commentcount;
	/** blankcount **/
    private Integer blankcount;
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
    * 获取属性:filename
    * filename
    * @return filename
    */
   public String getFilename() {
       return filename;
   }
   /**
    * 设置属性:filename
    * filename
    * @param filename
    */
   public void setFilename(String filename) {
       this.filename = filename;
   }
	
   /**
    * 获取属性:linecount
    * linecount
    * @return linecount
    */
   public Integer getLinecount() {
       return linecount;
   }
   /**
    * 设置属性:linecount
    * linecount
    * @param linecount
    */
   public void setLinecount(Integer linecount) {
       this.linecount = linecount;
   }
	
   /**
    * 获取属性:codecount
    * codecount
    * @return codecount
    */
   public Integer getCodecount() {
       return codecount;
   }
   /**
    * 设置属性:codecount
    * codecount
    * @param codecount
    */
   public void setCodecount(Integer codecount) {
       this.codecount = codecount;
   }
	
   /**
    * 获取属性:commentcount
    * commentcount
    * @return commentcount
    */
   public Integer getCommentcount() {
       return commentcount;
   }
   /**
    * 设置属性:commentcount
    * commentcount
    * @param commentcount
    */
   public void setCommentcount(Integer commentcount) {
       this.commentcount = commentcount;
   }
	
   /**
    * 获取属性:blankcount
    * blankcount
    * @return blankcount
    */
   public Integer getBlankcount() {
       return blankcount;
   }
   /**
    * 设置属性:blankcount
    * blankcount
    * @param blankcount
    */
   public void setBlankcount(Integer blankcount) {
       this.blankcount = blankcount;
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