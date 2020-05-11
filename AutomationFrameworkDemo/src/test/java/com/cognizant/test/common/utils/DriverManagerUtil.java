package com.cognizant.test.common.utils;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cognizant.test.common.config.TestRun;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Class to setup Driver instances
 * @author Amit Taware
 *
 */
public class DriverManagerUtil {
	
	//ThreadLocal is used to support parallel execution.
	private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();
	private static ThreadLocal<AndroidDriver<MobileElement>> androidDriver = new ThreadLocal<AndroidDriver<MobileElement>>();
	private static ThreadLocal<AppiumDriver<MobileElement>> appiumDriver = new ThreadLocal<AppiumDriver<MobileElement>>();
    
	//Sets the Remote WebDriver instance for the running session.
    public static synchronized void setWebDriver(RemoteWebDriver driver) {
        webDriver.set(driver);
    }
    
    //Gets the Remote WebDriver instance for the running session.
    public static synchronized RemoteWebDriver getWebDriver() {
        return webDriver.get();
    }
    
    //Sets the Appium Driver instance for the running session.
    public static synchronized void setAppiumDriver(AppiumDriver<MobileElement> driver) {
        appiumDriver.set(driver);
    }
    
    //Gets the Appium Driver instance for the running session.
    public static synchronized AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver.get();
    }
    
    //Sets the Android Driver instance for the running session.
    public static synchronized void setAndroidDriver(AndroidDriver<MobileElement> driver) {
        androidDriver.set(driver);
    }
    
    //Gets the Android Driver instance for the running session.
    public static synchronized AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver.get();
    }
    
    
    //Sets the Driver instance for the running session.
	public static void initiateAppiumDriver(DesiredCapabilities capabilities) { 		
		String url = null;
		url = TestRun.getUrl();
	
        if (TestRun.isAndroid()) {
        	androidDriver(url, capabilities);	               
        }
	}
	
	//Set Android Driver instance for the running session.
	public static void androidDriver(String url, DesiredCapabilities capabilities) {
		try {
			 appiumDriver.set(new AndroidDriver<MobileElement>(new URL(url), capabilities));
             setAppiumDriver(appiumDriver.get());
             androidDriver.set((AndroidDriver<MobileElement>) appiumDriver.get());
             setAndroidDriver(androidDriver.get());
		 } catch (Exception e) {
            LoggerUtil.logConsoleMessage("Android Session could not be created.");
            e.printStackTrace();
         }
		
		 if (appiumDriver == null) {
            LoggerUtil.logConsoleMessage("The driver was not properly initiated.");
		 }  
    }
	
	//Stops Driver instance for the running session
	public static void stopAppiumDriver() {    	
		try {			
				getAppiumDriver().closeApp();				
				getAppiumDriver().close();
				getAppiumDriver().quit();	
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.logConsoleMessage("Error while closing the app.");
		}
	}	
}
