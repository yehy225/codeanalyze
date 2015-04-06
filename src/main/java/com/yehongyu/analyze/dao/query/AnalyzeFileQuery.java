package com.yehongyu.analyze.dao.query;

import java.util.ArrayList;
import java.util.List;

/**
 * analyze_file查询对象
 * @author yingyang
 * @since 2011-11-16
 */
public class AnalyzeFileQuery extends BaseQuery {

	/** 序列化ID */
	private static final long serialVersionUID = 1L;
	
	/** ====================查询唯一单条记录使用==========================**/
	
	/**==============================批量查询、更新、删除时的Where条件设置==================================**/
	/** id **/
    private Long id;
	/**
    * 获取属性:id
    * id
    * @return id
    */
	public Long getId () {
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
	/** filename **/
    private String filename;
	/**
    * 获取属性:filename
    * filename
    * @return filename
    */
	public String getFilename () {
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
	/** linecount **/
    private Integer linecount;
	/**
    * 获取属性:linecount
    * linecount
    * @return linecount
    */
	public Integer getLinecount () {
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
	/** codecount **/
    private Integer codecount;
	/**
    * 获取属性:codecount
    * codecount
    * @return codecount
    */
	public Integer getCodecount () {
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
	/** commentcount **/
    private Integer commentcount;
	/**
    * 获取属性:commentcount
    * commentcount
    * @return commentcount
    */
	public Integer getCommentcount () {
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
	/** blankcount **/
    private Integer blankcount;
	/**
    * 获取属性:blankcount
    * blankcount
    * @return blankcount
    */
	public Integer getBlankcount () {
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

	/**==============================批量查询时的Order条件顺序设置==================================**/
	/**排序列表字段**/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * 设置排序按属性：id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：filename
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyFilename(boolean isAsc){
		orderFields.add(new OrderField("filename",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：linecount
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyLinecount(boolean isAsc){
		orderFields.add(new OrderField("linecount",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：codecount
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyCodecount(boolean isAsc){
		orderFields.add(new OrderField("codecount",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：commentcount
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyCommentcount(boolean isAsc){
		orderFields.add(new OrderField("commentcount",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：blankcount
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyBlankcount(boolean isAsc){
		orderFields.add(new OrderField("blankcount",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：gmt_create
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyGmtCreate(boolean isAsc){
		orderFields.add(new OrderField("gmt_create",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：gmt_modified
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyGmtModified(boolean isAsc){
		orderFields.add(new OrderField("gmt_modified",isAsc?"ASC":"DESC"));
	}

}
