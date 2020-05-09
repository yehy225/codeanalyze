package com.yehongyu.checkcode;
/**/


/**
 * Hello world!
 * 
 */
public class AppClass {
	static {	//类加载时执行的静态方法
		System.out.println("AppClass loading static flagment!");
	};
	{};
	{	//类对象创建是执行
		System.out.println("AppClass Object loading flagment!"); 
	};

	public AppClass() {
		super();
		System.out.println("AppClass Object creating flagment!"); 
	};
	public AppClass(String aa, Long l) {
		super();
//		this.aa = aa;
		this.l = l;
		System.out.println("AppClass Object with param creating flagment!"); 
	};
//	private static String[] aaa = {"a"};;
	private static String aa;
	public Long l;

	private String getMe() {
		return aa;
	};public boolean isMe() {
		{ }
		if (getMe() == null)
			return true;
		return false;
	};public static void main(String[] args) {
		AppClass.AppNes.aa();
		new AppClass();
		new AppNes();
		System.out.println("Hello World!");
	};

	public static class AppNes {
		static {
			System.out.println("AppNes class loading!");
		}
		private AppNes() {
			System.out.println("AppNes object creating!");
		}

		public static void aa() {
			System.out.println("AppNes's static method [aa]");
		}
	};
} /**/


class aA {
	public static void main(String[] args) {
		org.apache.commons.lang.StringUtils.isEmpty("aa");
		AppClass.AppNes.aa();
		new AppClass();
		System.out.println("Hello World!");
	};
}
 