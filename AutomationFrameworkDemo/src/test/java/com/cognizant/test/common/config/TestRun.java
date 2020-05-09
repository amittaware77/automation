package com.cognizant.test.common.config;

public class TestRun {
		//Common for Android & iOS
		private static ThreadLocal<String> udid = new ThreadLocal<String>();
		private static ThreadLocal<String> launchExistingApp = new ThreadLocal<String>();	
		private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
		private static ThreadLocal<String> platformName = new ThreadLocal<String>();
		private static ThreadLocal<String> platformVersion = new ThreadLocal<String>();
		private static ThreadLocal<String> automationName = new ThreadLocal<String>();
		private static ThreadLocal<String> browserName = new ThreadLocal<String>();	
		private static ThreadLocal<String> url = new ThreadLocal<String>();
								
	  

	    public static synchronized void setLaunchExistingApp(String launchExistingApp) {
	        TestRun.launchExistingApp.set(launchExistingApp);
	    }
		
	    public static synchronized String getLaunchExistingApp() {
	        return TestRun.launchExistingApp.get();
	    }
	    
	    public static synchronized Boolean isLaunchExistingApp() {
	    	return getLaunchExistingApp().equalsIgnoreCase("Yes");
	    }
	    
	    public static synchronized String getDeviceName() {
	        return TestRun.deviceName.get();
	    }
	    
	    public static synchronized void setDeviceName(String deviceName) {
	        TestRun.deviceName.set(deviceName);
	    }
	    
	    public static synchronized void setPlatformName(String platformName) {
	        TestRun.platformName.set(platformName);
	    }
	    
	    public static synchronized String getPlatformName() {
	        return TestRun.platformName.get();
	    }  
	    
	    public static synchronized Boolean isIos() {
	    	return getPlatformName().equalsIgnoreCase("IOS");
	    }
	    
	    public static synchronized Boolean isAndroid() {
	    	return getPlatformName().equalsIgnoreCase("ANDROID");
	    }  
	    
	    public static synchronized void setPlatformVersion(String platformVersion) {
	        TestRun.platformVersion.set(platformVersion);
	    }
	    
	    public static synchronized String getPlatformVersion() {
	        return TestRun.platformVersion.get();
	    } 
	    
	    public static synchronized void setAutomationName(String automationName) {
	        TestRun.automationName.set(automationName);
	    }
	    
	    public static synchronized String getAutomationName() {
	        return TestRun.automationName.get();
	    }          
	    
	    public static synchronized void setbrowserName(String browserName) {
	        TestRun.browserName.set(browserName);
	    }
	    
	    public static synchronized String getbrowserName() {
	        return TestRun.browserName.get();
	    }
	    
	    public static synchronized void setUrl(String url) {
	        TestRun.url.set(url);
	    }
	    
	    public static synchronized String getUrl() {
	        return TestRun.url.get();
	    }
	    
	    public static synchronized void setUdid(String udid) {
	        TestRun.udid.set(udid);
	    }
	   
	    public static synchronized String getUdid() {
	        return TestRun.udid.get();
	    }
	    
}
