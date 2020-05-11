package com.cognizant.test.testrunner;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import com.cognizant.test.common.config.TestRun;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Class having Cucumber Options and test setup for execution
 * @author Amit Taware
 *
 */
@CucumberOptions(
        features = {"src/test/resources/features"},                        //Path of feature files
        glue = {"com.cognizant.test.step.definitions"},                    //Path of step definitions
        tags = {"@Purchase65inchTV"},                                      //Feature(Testcase) to be executed should be mentioned here
        monochrome = true,                                                 //Set true for better readability on console output
    	dryRun = false                                                     //Set true to generate glue codes for feature steps otherwise false
      )

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests{

	@BeforeTest
	public void testSetUp(ITestContext context) {	
		
		//Common desiredcapabilities for Android & iOS fetching from TestNG parameters
		//Launching existing app
		String launchExistingApp = context.getCurrentXmlTest().getParameter("launchExistingApp");
		TestRun.setLaunchExistingApp(launchExistingApp);
			
		//Provides device name for running session.
		String deviceName = context.getCurrentXmlTest().getParameter("deviceName");
		TestRun.setDeviceName(deviceName);
		
		//Provides platform name for running session.
		String platformName = context.getCurrentXmlTest().getParameter("platformName");
		TestRun.setPlatformName(platformName);
		
		//Provides platform version for running session.
		String platformVersion = context.getCurrentXmlTest().getParameter("platformVersion");
		TestRun.setPlatformVersion(platformVersion);
		
		//Provides automation name for running session.
		String automationName = context.getCurrentXmlTest().getParameter("automationName");
		TestRun.setAutomationName(automationName);
				
		//Provides url for running session.
		String url = context.getCurrentXmlTest().getParameter("url");
		TestRun.setUrl(url);
		
		//Provides udid of device for running session.
		String udid = context.getCurrentXmlTest().getParameter("udid");
		TestRun.setUdid(udid);
	}	
}
