package com.cognizant.test.common.config;

/**
 * Class to set and get TestNG parameter data
 * @author Amit Taware
 *
 */
public class TestRun {
		//ThreadLocal is used to support parallel execution
		//Common desiredcapabilities for Android & iOS 
		private static ThreadLocal<String> udid = new ThreadLocal<String>();
		private static ThreadLocal<String> launchExistingApp = new ThreadLocal<String>();	
		private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
		private static ThreadLocal<String> platformName = new ThreadLocal<String>();
		private static ThreadLocal<String> platformVersion = new ThreadLocal<String>();
		private static ThreadLocal<String> automationName = new ThreadLocal<String>();
		private static ThreadLocal<String> browserName = new ThreadLocal<String>();	
		private static ThreadLocal<String> url = new ThreadLocal<String>();
								
	  
		//Sets the LaunchExistingApp value for the running session.
	    public static synchronized void setLaunchExistingApp(String launchExistingApp) {
	        TestRun.launchExistingApp.set(launchExistingApp);
	    }
		
	    //Gets the LaunchExistingApp value for the running session.
	    public static synchronized String getLaunchExistingApp() {
	        return TestRun.launchExistingApp.get();
	    }
	    
	    //Returns true or false for isLaunchExistingApp() for the running session.
	    public static synchronized Boolean isLaunchExistingApp() {
	    	return getLaunchExistingApp().equalsIgnoreCase("Yes");
	    }
	    
	    //Gets the DeviceName value for the running session.
	    public static synchronized String getDeviceName() {
	        return TestRun.deviceName.get();
	    }
	    
	    //Sets the DeviceName value for the running session.
	    public static synchronized void setDeviceName(String deviceName) {
	        TestRun.deviceName.set(deviceName);
	    }
	    
	    //Sets the PlatformName value for the running session.
	    public static synchronized void setPlatformName(String platformName) {
	        TestRun.platformName.set(platformName);
	    }
	    //Gets the PlatformName value for the running session.
	    public static synchronized String getPlatformName() {
	        return TestRun.platformName.get();
	    }  
	    
	    //Returns true or false for isIos() for running session
	    public static synchronized Boolean isIos() {
	    	return getPlatformName().equalsIgnoreCase("IOS");
	    }
	    
	    //Returns true or false for isAndroid() for running session
	    public static synchronized Boolean isAndroid() {
	    	return getPlatformName().equalsIgnoreCase("ANDROID");
	    }  
	    
	    //Sets the PlatformVersion value for the running session.
	    public static synchronized void setPlatformVersion(String platformVersion) {
	        TestRun.platformVersion.set(platformVersion);
	    }
	    
	    //Gets the PlatformVersion value for the running session.
	    public static synchronized String getPlatformVersion() {
	        return TestRun.platformVersion.get();
	    } 
	    
	    //Sets the AutomationName value for the running session.
	    public static synchronized void setAutomationName(String automationName) {
	        TestRun.automationName.set(automationName);
	    }
	    
	    //Gets the AutomationName value for the running session.
	    public static synchronized String getAutomationName() {
	        return TestRun.automationName.get();
	    }          
	    
	    //Sets the BrowserName value for the running session.
	    public static synchronized void setbrowserName(String browserName) {
	        TestRun.browserName.set(browserName);
	    }
	    
	    //Gets the BrowserName value for the running session.
	    public static synchronized String getbrowserName() {
	        return TestRun.browserName.get();
	    }
	    
	    //Sets the Url value for the running session.
	    public static synchronized void setUrl(String url) {
	        TestRun.url.set(url);
	    }
	    
	    //Gets the PlatformName value for the running session.
	    public static synchronized String getUrl() {
	        return TestRun.url.get();
	    }
	    
	    //Sets the Udid value for the running session.
	    public static synchronized void setUdid(String udid) {
	        TestRun.udid.set(udid);
	    }
	   
	    //Gets the Udid value for the running session.
	    public static synchronized String getUdid() {
	        return TestRun.udid.get();
	    }    
}
