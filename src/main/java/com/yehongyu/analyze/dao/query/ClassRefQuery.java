package com.yehongyu.analyze.dao.query;

import java.util.ArrayList;
import java.util.List;

/**
 * class_ref查询对象
 * @author yingyang
 * @since 2011-11-16
 */
public class ClassRefQuery extends BaseQuery {

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
	/** class_name **/
    private String className;
	/**
    * 获取属性:className
    * class_name
    * @return className
    */
	public String getClassName () {
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
	/** ref_class **/
    private String refClass;
	/**
    * 获取属性:refClass
    * ref_class
    * @return refClass
    */
	public String getRefClass () {
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
	 * 设置排序按属性：class_name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyClassName(boolean isAsc){
		orderFields.add(new OrderField("class_name",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：ref_class
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyRefClass(boolean isAsc){
		orderFields.add(new OrderField("ref_class",isAsc?"ASC":"DESC"));
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
