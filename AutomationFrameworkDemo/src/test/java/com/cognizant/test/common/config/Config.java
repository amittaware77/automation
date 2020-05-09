package com.cognizant.test.common.config;

public class Config {
	public static String ANDROID_APP_PATH;
	
	public Config(){
		ANDROID_APP_PATH = System.getProperty("user.dir")+"//src//test//resources//Apps//Amazon_shopping.apk";
	}
	
	public static final int XSMALL_PAUSE = 5;
	public static final int SMALL_PAUSE = 15;
	public static final int MEDIUM_PAUSE = 30;
	public static final int LARGE_PAUSE = 60;
	
	public static final String APP_PCKAGE = "com.amazon.mShop.android.shopping";
	public static final String APP_ACTIVITY = "com.amazon.mShop.android.home.HomeActivity";

}
