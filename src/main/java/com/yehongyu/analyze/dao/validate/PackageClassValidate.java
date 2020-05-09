package com.yehongyu.analyze.dao.validate;

import com.yehongyu.analyze.dao.domain.PackageClassDO;
import com.yehongyu.analyze.dao.query.PackageClassQuery;

/**
 * package_class校验类
 * 将在×ServiceClient、×ServiceImpl、×DAOImpl三层共同统一校验机制
 * @author yingyang
 * @since 2011-11-16
 */
public class PackageClassValidate extends BaseValidate {
	
	//PackageClass字符字段长度值
	public final static int BYTELENGTH_OF_MODULE_PATH = 200;
	public final static int BYTELENGTH_OF_PACKAGE_NAME = 200;
	public final static int BYTELENGTH_OF_CLASS_NAME = 200;
	public final static int BYTELENGTH_OF_FILE_NAME = 200;
	
	/**
	 * 单个查询条件验证ID不为空
	 * @param packageClassQuery
	 * @throws IllegalArgumentException
	 */
	public static void getPackageClassDO(PackageClassQuery packageClassQuery) throws IllegalArgumentException{
		if(packageClassQuery==null||packageClassQuery.getId()==null || packageClassQuery.getId()<=0){
			throw new IllegalArgumentException("packageClassQuery Parameter is not correct,packageClassQuery:" + packageClassQuery);
		}
	}
	
	/**
	 * 批量查询条件不校验
	 * @param packageClassQuery
	 * @throws IllegalArgumentException
	 */
	public static void getPackageClassDOList(PackageClassQuery packageClassQuery) throws IllegalArgumentException{

	}
	
	/**
	 * 批量翻页查询条件不校验
	 * @param packageClassQuery
	 * @throws IllegalArgumentException
	 */
	public static void getPackageClassDOListWithPage(PackageClassQuery packageClassQuery) throws IllegalArgumentException{

	}
	
	/**
	 * 新增记录对象校验不为空，长度校验
	 * @param packageClassDO
	 * @throws IllegalArgumentException
	 */
	public static void insertPackageClassDO(PackageClassDO packageClassDO) throws IllegalArgumentException{
		if (null == packageClassDO) {
			throw new IllegalArgumentException("packageClassDO Parameter is null!");
		}
		if(packageClassDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validatePackageClassDOFieldLength(packageClassDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("insertPackageClassDO Parameter verify not correct,packageClassDO:"+sb.toString());
		}
		packageClassDO.setValidate(true);	//设置成校验过了。
	}

	/**
	 * 新增和修改记录是需要验证对象长度
	 * @param packageClassDO
	 * @param sb
	 * @return
	 */
	private static StringBuffer validatePackageClassDOFieldLength(PackageClassDO packageClassDO,StringBuffer sb) {
		sb = checkLength(packageClassDO.getModulePath(),BYTELENGTH_OF_MODULE_PATH,sb,"modulePath");
		sb = checkLength(packageClassDO.getPackageName(),BYTELENGTH_OF_PACKAGE_NAME,sb,"packageName");
		sb = checkLength(packageClassDO.getClassName(),BYTELENGTH_OF_CLASS_NAME,sb,"className");
		sb = checkLength(packageClassDO.getFileName(),BYTELENGTH_OF_FILE_NAME,sb,"fileName");
		return sb;
	}
	
	/**
	 * 修改记录时验证ID不为空及字段长度
	 * @param packageClassDO
	 * @throws IllegalArgumentException
	 */
	public static void updatePackageClassDO(PackageClassDO packageClassDO) throws IllegalArgumentException{
		if (null == packageClassDO || packageClassDO.getId() == null||packageClassDO.getId()<1) {
			throw new IllegalArgumentException("updatePackageClassDO Parameter verify not correct,packageClassDO:" + packageClassDO);
		}
		if(packageClassDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validatePackageClassDOFieldLength(packageClassDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("updatePackageClassDO Parameter verify not correct,packageClassDO:" + sb.toString());
		}
		packageClassDO.setValidate(true);	//设置成校验过了。
	}
	
	/**
	 * 批量修改记录时验证IDList不为空及字段长度
	 * @param packageClassDO
	 * @throws IllegalArgumentException
	 */
	public static void updatePackageClassDOList(PackageClassDO packageClassDO) throws IllegalArgumentException{
		if (null == packageClassDO || packageClassDO.getIdList() == null||packageClassDO.getIdList().isEmpty()) {
			throw new IllegalArgumentException("batch updatePackageClassDO Parameter verify not correct,packageClassDO:" + packageClassDO);
		}
		if(packageClassDO.isValidate()) return;	//已经校验过了
		//校验主体
		StringBuffer sb = new StringBuffer();
		sb = validatePackageClassDOFieldLength(packageClassDO, sb);
		//校验结尾
		if(!"".equals(sb.toString())){
			throw new IllegalArgumentException("batch updatePackageClassDOList Parameter verify not correct,packageClassDO:" + sb.toString());
		}
		packageClassDO.setValidate(true);	//设置成校验过了。
	}
	
	/**
	 * 单个删除记录时验证ID不为空
	 * @param id
	 * @throws IllegalArgumentException
	 */
	public static void deletePackageClassDO(Long id) throws IllegalArgumentException{
		if (null == id || id < 1) {
			throw new IllegalArgumentException("deletePackageClassDO Parameter verify not correct,id:" + id);
		}
	}
	
	/**
	 * 批量删除记录时验证IDList不为空
	 * @param packageClassQuery
	 * @throws IllegalArgumentException
	 */
	public static void deletePackageClassDOList(PackageClassQuery packageClassQuery) throws IllegalArgumentException{
		if (null == packageClassQuery || packageClassQuery.getIdList() == null||packageClassQuery.getIdList().isEmpty()) {
			throw new IllegalArgumentException("deletePackageClassDO Parameter verify not correct,packageClassQuery:" + packageClassQuery);
		}
	}
	
}
