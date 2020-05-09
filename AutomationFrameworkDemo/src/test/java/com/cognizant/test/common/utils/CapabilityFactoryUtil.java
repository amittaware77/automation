package com.cognizant.test.common.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.cognizant.test.common.config.Config;
import com.cognizant.test.common.config.TestRun;


public class CapabilityFactoryUtil {

	//Set DesiredCapabilities
    public static void initiateDriver() {
    	DesiredCapabilities capabilities = new DesiredCapabilities();		 
		   		
			if (TestRun.isAndroid()) {		    		
				if (!TestRun.isLaunchExistingApp()){
						capabilities.setCapability("app", Config.ANDROID_APP_PATH);
					}
					capabilities.setCapability("appPackage", Config.APP_PCKAGE);
					capabilities.setCapability("appActivity", Config.APP_ACTIVITY);
					capabilities.setCapability("noReset", false);	
					capabilities.setCapability("udid", TestRun.getUdid());
				}
		
			//Common for Android & iOS
    		capabilities.setCapability("deviceName", TestRun.getDeviceName());		
    		capabilities.setCapability("platformName", TestRun.getPlatformName());		
    		capabilities.setCapability("platformVersion", TestRun.getPlatformVersion());
    		capabilities.setCapability("automationName", TestRun.getAutomationName());	

	DriverManagerUtil.initiateAppiumDriver(capabilities);
    }  

}
