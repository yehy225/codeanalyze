package com.yehongyu.checkcode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yehongyu.analyze.dao.domain.PackageClassDO;

public class ClassReflect {
	

	/** 日志记录 */
	private final static Logger logger = Logger.getLogger(ClassReflect.class);
	
	public static void main(String[] args){
//		List<String> classList = new ClassReflect().listClass(System.getProperty("user.dir") + "/src/main/java", null,System.getProperty("user.dir") + "/src/main/java");
//		for(String cstr:classList){
//			analyzeClass(cstr);
//		}
		analyzeClass("com.yehongyu.checkcode.AppClass");
		
		List<PackageClassDO> l = new ArrayList<PackageClassDO>();
		for(String s:ClassAnalyze.sourceDir){
			List<PackageClassDO> t = ClassAnalyze.listPackage(s+"/src/main/java", null, s+"/src/main/java");
			l.addAll(t);
		}
		logger.info("所有包及类个数：" + l.size());
		int classlength = 0;	//所有类个数
		int interfacecount = 0;	//接口个数
		int enumcount = 0;	//枚举个数
		int classcount = 0;	//Class类个数
		for(PackageClassDO p:l){
			if(p.getClassName()!=null){
				classlength++;
				try {
					Class<?> c = ClassLoader.getSystemClassLoader().loadClass(p.getClassName());
					if(c.isInterface()){
						interfacecount++;
					}else if(c.isEnum()){
						enumcount++;
					}else{
						classcount++;
					}
				}catch (ClassNotFoundException e) {
					logger.error("类找不到异常：", e);
				}
			}
		}
	}
	
	public static void analyzeClass(String classpackagestr){
		try {
			Class<?> c = ClassLoader.getSystemClassLoader().loadClass(classpackagestr);
			//类自身信息
			logger.info("c.getClass():" + c);	//类对象(java.lang.Class<?>)
			if(c.getClasses()!=null){
				logger.info("c.getClasses().length:" + c.getClasses().length);	//类对象个数
				for(int i=0;i<c.getClasses().length;i++){
					logger.info("getClasses()["+i+"]:" + c.getClasses()[i].toString());
				}
			}
			logger.info("c.getClassLoader():" + c.getClassLoader());	//类加载器(java.lang.ClassLoader)
			logger.info("c.getModifiers():" + Modifier.toString(c.getModifiers()));	//类的修饰符(int)
			logger.info("c.getName():" + c.getName());	//类的名字
			logger.info("c.getCanonicalName():" + c.getCanonicalName());	//类及包路径全名
			logger.info("c.getSimpleName():" + c.getSimpleName());	//类的简单名字
			logger.info("c.getPackage():" + c.getPackage());	//类的包名(java.lang.Package)
			logger.info("c.getProtectionDomain():" + c.getProtectionDomain());	//类的保护域(java.security.ProtectionDomain)
			logger.info("c.getSigners():" + c.getSigners());	//类的签名数组(java.lang.Object)
			if(c.getSigners()!=null){
				logger.info("c.getSigners().length:" + c.getSigners().length);	//类的签名数组个数
				for(int i=0;i<c.getSigners().length;i++){
					logger.info("c.getSigners()["+i+"]:" + c.getSigners()[i].toString());
				}
			}
			
			//类的属性信息
			logger.info("c.isArray():" + c.isArray());	//是否数组类型
			logger.info("c.isEnum():" + c.isEnum());	//是否Enum类型
			logger.info("c.isInterface():" + c.isInterface());	//是否接口类型
			logger.info("c.isAnnotation():" + c.isAnnotation());	//是否Annotation类型，Annotation都是Interface类型
			
			logger.info("c.isLocalClass():" + c.isLocalClass());	//是否本地类
			logger.info("c.isMemberClass():" + c.isMemberClass());	//是否成员类
			logger.info("c.isAnonymousClass():" + c.isAnonymousClass());	//是否匿名内部类
			
			logger.info("c.isPrimitive():" + c.isPrimitive());	//是否是原始类型
			logger.info("c.isSynthetic():" + c.isSynthetic());	//是否复合类型
			
			//类的声明信息（实现的注释、接口、超类等类型）
			logger.info("c.getAnnotations():" + c.getAnnotations());	//类中包含的Annotation数组
			if(c.getAnnotations()!=null){
				logger.info("c.getAnnotations().length:" + c.getAnnotations().length);	//类中包含的Annotation的数组个数
				for(int i=0;i<c.getAnnotations().length;i++){
					logger.info("c.getAnnotations()["+i+"]:" + c.getAnnotations()[i].annotationType());
				}
			}
			logger.info("c.getDeclaredAnnotations():" + c.getDeclaredAnnotations());	//类直接定义的Annotation数组
			if(c.getDeclaredAnnotations()!=null){
				logger.info("c.getDeclaredAnnotations().length:" + c.getDeclaredAnnotations().length);	//类直接定义的Annotation数组个数
				for(int i=0;i<c.getDeclaredAnnotations().length;i++){
					logger.info("c.getDeclaredAnnotations()["+i+"]:" + c.getDeclaredAnnotations()[i].annotationType());
				}
			}
			logger.info("c.getInterfaces():" + c.getInterfaces());	//类所实现的接口(java.lang.Class<?>)数组
			if(c.getInterfaces()!=null){
				logger.info("c.getInterfaces().length:" + c.getInterfaces().length);	//类所实现的接口(java.lang.Class<?>)数组个数
				for(int i=0;i<c.getInterfaces().length;i++){
					logger.info("c.getInterfaces()["+i+"]:" + c.getInterfaces()[i].toString());
				}
			}
			logger.info("c.getSuperclass():" + c.getSuperclass());	//类所继承的类(java.lang.Class)
			logger.info("c.getGenericInterfaces():" + c.getGenericInterfaces());	//类所实现的接口类型(java.lang.reflect.Type)数组
			if(c.getGenericInterfaces()!=null){
				logger.info("c.getGenericInterfaces().length:" + c.getGenericInterfaces().length);	//类所实现的接口类型(java.lang.reflect.Type)数组个数
				for(int i=0;i<c.getGenericInterfaces().length;i++){
					logger.info("c.getGenericInterfaces()["+i+"]:" + c.getGenericInterfaces()[i].toString());
				}
			}
			logger.info("c.getGenericSuperclass():" + c.getGenericSuperclass());	//类所继承的类类型(java.lang.reflect.Type)
			logger.info("c.getTypeParameters():" + c.getTypeParameters());	//类型参数(java.lang.reflect.TypeVariable)数组
			if(c.getTypeParameters()!=null){
				logger.info("c.getTypeParameters().length:" + c.getTypeParameters().length);	//类型参数(java.lang.reflect.TypeVariable)数组个数
				for(int i=0;i<c.getTypeParameters().length;i++){
					logger.info("c.getTypeParameters()["+i+"]:" + c.getTypeParameters()[i].toString());
				}
			}
			
			//类的成员信息（构造方法、字段、方法）
			logger.info("c.getConstructors():" + c.getConstructors());	//构造器(java.lang.reflect.Constructor)数组
			if(c.getConstructors()!=null){
				logger.info("c.getConstructors().length:" + c.getConstructors().length);	//构造器(java.lang.reflect.Constructor)的数组个数
				for(int i=0;i<c.getConstructors().length;i++){
					logger.info("c.getConstructors()=========================["+i+"]:" + c.getConstructors()[i].toGenericString());
				}
			}
			logger.info("c.getDeclaredFields():" + c.getDeclaredFields());	//类直接定义的字段(java.lang.reflect.Field)数组
			if(c.getDeclaredFields()!=null){
				logger.info("c.getDeclaredFields().length:" + c.getDeclaredFields().length);	//类直接定义的字段(java.lang.reflect.Field)数组个数
				for(int i=0;i<c.getDeclaredFields().length;i++){
					logger.info("c.getDeclaredFields()=========================["+i+"]:" + c.getDeclaredFields()[i].toGenericString());
					analyzeField(c.getDeclaredFields()[i]);
				}
			}
			logger.info("c.getDeclaredMethods():" + c.getDeclaredMethods());	//类直接定义的方法(java.lang.reflect.Method)数组
			if(c.getDeclaredMethods()!=null){
				logger.info("c.getDeclaredMethods().length:" + c.getDeclaredMethods().length);	//类直接定义的方法(java.lang.reflect.Method)数组个数
				for(int i=0;i<c.getDeclaredMethods().length;i++){
					logger.info("c.getDeclaredMethods()=========================["+i+"]:" + c.getDeclaredMethods()[i].toGenericString());
					analyzeMethod(c.getDeclaredMethods()[i]);
				}
			}

			logger.info("c.getFields():" + c.getFields());	//类所有可访问的public字段及继承的public字段(java.lang.reflect.Field)数组
			logger.info("c.getFields().length:" + c.getFields().length);	//类所有可访问的public字段及继承的public字段(java.lang.reflect.Field)数组个数
			logger.info("c.getMethods():" + c.getMethods());	//类所有可访问的public方法及继承的public方法(java.lang.reflect.Method)数组
			logger.info("c.getMethods().length:" + c.getMethods().length);	//类所有可访问的public方法及继承的public方法(java.lang.reflect.Method)数组个数

			//类的包含信息（内部类、方法、构造器；引用类）
			logger.info("c.getDeclaringClass():" + c.getDeclaringClass());	//定义它的类(java.lang.Class)-组合引用类
			logger.info("c.getEnclosingClass():" + c.getEnclosingClass());	//包含它的类(java.lang.Class)-内部引用类
			logger.info("c.getEnclosingConstructor():" + c.getEnclosingConstructor());	//包含它的构造器(java.lang.reflect.Constructor)-内部或匿名引用构造器
			logger.info("c.getEnclosingMethod():" + c.getEnclosingMethod());//包含它的方法(java.lang.reflect.Method)-内部或匿名引用方法
			
			//数组或Enum类信息
			logger.info("c.getComponentType():" + (c.getComponentType()!=null?c.getComponentType():"非数组类型"));	//如果是数组，则为数组的类型。否则为空
			logger.info("c.getEnumConstants():" + (c.getEnumConstants()!=null?c.getEnumConstants():"非Enum类型"));	//如果是Enum，则为Enum的常量数组。否则为空
			if(c.getEnumConstants()!=null){
				logger.info("c.getEnumConstants().length:" + c.getEnumConstants().length);	//如果是Enum，则为Enum的常量数组的个数
				for(int i=0;i<c.getEnumConstants().length;i++){
					logger.info("c.getEnumConstants()["+i+"]:" + c.getEnumConstants()[i].toString());
				}
			}
		} catch (ClassNotFoundException e) {
			logger.error("类找不到异常：", e);
		}
	}
	
	private static void analyzeField(Field field){
		logger.info("field.getClass():"+field.getClass());
		logger.info("field.hashCode():"+field.hashCode());
		logger.info("field.isAccessible():"+field.isAccessible());
		logger.info("field.isSynthetic():"+field.isSynthetic());
		logger.info("field.toGenericString():"+field.toGenericString());
		logger.info("field.toString():"+field.toString());
		logger.info("field.getModifiers():"+Modifier.toString(field.getModifiers()));
		logger.info("field.getName():"+field.getName());
		logger.info("field.getDeclaringClass():"+field.getDeclaringClass());
		
		logger.info("field.getAnnotations():"+field.getAnnotations());
		if(field.getAnnotations()!=null){
			logger.info("getAnnotations--------------------length:"+field.getAnnotations().length);
			for(int i=0;i<field.getAnnotations().length;i++){
				logger.info("getAnnotations--------------------["+i+"]:"+field.getAnnotations()[i].toString());
			}
		}
		logger.info("field.getDeclaredAnnotations():"+field.getDeclaredAnnotations());
		if(field.getDeclaredAnnotations()!=null){
			logger.info("getDeclaredAnnotations--------------------length:"+field.getDeclaredAnnotations().length);
			for(int i=0;i<field.getDeclaredAnnotations().length;i++){
				logger.info("getDeclaredAnnotations--------------------["+i+"]:"+field.getDeclaredAnnotations()[i].toString());
			}
		}
		logger.info("field.getGenericType():"+field.getGenericType());
		logger.info("field.getType():"+field.getType());
		
		logger.info("field.isEnumConstant():"+field.isEnumConstant());
	}
	
	private static void analyzeMethod(Method method){
		logger.info("method.getClass():"+method.getClass());
		logger.info("method.hashCode():"+method.hashCode());
		logger.info("method.isAccessible():"+method.isAccessible());
		logger.info("method.isSynthetic():"+method.isSynthetic());
		logger.info("method.toGenericString():"+method.toGenericString());
		logger.info("method.toString():"+method.toString());
		logger.info("method.getModifiers():"+Modifier.toString(method.getModifiers()));
		logger.info("method.getName():"+method.getName());
		logger.info("method.getDeclaringClass():"+method.getDeclaringClass());
		
		logger.info("method.getAnnotations():"+method.getAnnotations());
		if(method.getAnnotations()!=null){
			logger.info("getAnnotations--------------------length:"+method.getAnnotations().length);
			for(int i=0;i<method.getAnnotations().length;i++){
				logger.info("getAnnotations--------------------["+i+"]:"+method.getAnnotations()[i].annotationType());
			}
		}
		logger.info("method.getDeclaredAnnotations():"+method.getDeclaredAnnotations());
		if(method.getDeclaredAnnotations()!=null){
			logger.info("getDeclaredAnnotations--------------------length:"+method.getDeclaredAnnotations().length);
			for(int i=0;i<method.getDeclaredAnnotations().length;i++){
				logger.info("getDeclaredAnnotations--------------------["+i+"]:"+method.getDeclaredAnnotations()[i].toString());
			}
		}
		logger.info("method.getGenericReturnType():"+method.getGenericReturnType());
		logger.info("method.getReturnType():"+method.getReturnType());
		
		logger.info("--------------------method.getGenericExceptionTypes():"+method.getGenericExceptionTypes());
		if(method.getGenericExceptionTypes()!=null){
			logger.info("getGenericExceptionTypes--------------------length:"+method.getGenericExceptionTypes().length);
			for(int i=0;i<method.getGenericExceptionTypes().length;i++){
				logger.info("getGenericExceptionTypes--------------------["+i+"]:"+method.getGenericExceptionTypes()[i].toString());
			}
		}
		logger.info("method.getExceptionTypes():"+method.getExceptionTypes());
		logger.info("method.getGenericParameterTypes():"+method.getGenericParameterTypes());
		if(method.getGenericParameterTypes()!=null){
			logger.info("getGenericParameterTypes--------------------length:"+method.getGenericParameterTypes().length);
			logger.info("method.getParameterAnnotations():"+method.getParameterAnnotations());
			if(method.getParameterAnnotations()!=null){
				logger.info("getParameterAnnotations--------------------length:"+method.getParameterAnnotations().length);
			}
			for(int i=0;i<method.getGenericParameterTypes().length;i++){
				logger.info("getGenericParameterTypes--------------------["+i+"]:"+method.getGenericParameterTypes()[i].toString());
				for(int j=0;j<method.getParameterAnnotations()[i].length;j++){
					logger.info("getParameterAnnotations--------------------["+i+","+j+"]:"+method.getParameterAnnotations()[i][j].annotationType());
				}
			}
		}
		logger.info("method.getParameterTypes():"+method.getParameterTypes());
		logger.info("-------------------method.getTypeParameters():"+method.getTypeParameters());
		if(method.getTypeParameters()!=null&&method.getTypeParameters().length>0){
			for(TypeVariable<Method> t:method.getTypeParameters()){
				logger.info("TypeVariable<Method>-------------------getName():"+t.getName());
				logger.info("TypeVariable<Method>-------------------getClass():"+t.getClass());
				logger.info("TypeVariable<Method>-------------------toString():"+t.toString());
				logger.info("TypeVariable<Method>-------------------getGenericDeclaration():"+t.getGenericDeclaration());
				logger.info("TypeVariable<Method>-------------------getBounds():"+t.getBounds());
			}
		}
		logger.info("method.getDefaultValue():"+method.getDefaultValue());
		logger.info("method.isBridge():"+method.isBridge());
		logger.info("method.isVarArgs():"+method.isVarArgs());
		
	}
	
}

