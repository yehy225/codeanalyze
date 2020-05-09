package com.yehongyu.analyze.dao.query;

import java.util.ArrayList;
import java.util.List;

/**
 * package_class查询对象
 * @author yingyang
 * @since 2011-11-16
 */
public class PackageClassQuery extends BaseQuery {

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
	/** module_path **/
    private String modulePath;
	/**
    * 获取属性:modulePath
    * module_path
    * @return modulePath
    */
	public String getModulePath () {
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
	/** package_name **/
    private String packageName;
	/**
    * 获取属性:packageName
    * package_name
    * @return packageName
    */
	public String getPackageName () {
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
	/** file_name **/
    private String fileName;
	/**
    * 获取属性:fileName
    * file_name
    * @return fileName
    */
	public String getFileName () {
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
	 * 设置排序按属性：module_path
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyModulePath(boolean isAsc){
		orderFields.add(new OrderField("module_path",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：package_name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyPackageName(boolean isAsc){
		orderFields.add(new OrderField("package_name",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：class_name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyClassName(boolean isAsc){
		orderFields.add(new OrderField("class_name",isAsc?"ASC":"DESC"));
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
	/**
	 * 设置排序按属性：file_name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyFileName(boolean isAsc){
		orderFields.add(new OrderField("file_name",isAsc?"ASC":"DESC"));
	}

}
