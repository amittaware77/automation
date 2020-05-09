package com.cognizant.test.testrunner;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import com.cognizant.test.common.config.TestRun;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.cognizant.test.step.definitions"},
        tags = {"@Purchase65inchTV"},
        monochrome = true,
    	dryRun = false
      )

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests{

	@BeforeTest
	public void testSetUp(ITestContext context) {	
		
		//Launching existing app
		String launchExistingApp = context.getCurrentXmlTest().getParameter("launchExistingApp");
		TestRun.setLaunchExistingApp(launchExistingApp);
			
		//Common in Android & iOS
		String deviceName = context.getCurrentXmlTest().getParameter("deviceName");
		TestRun.setDeviceName(deviceName);
		
		String platformName = context.getCurrentXmlTest().getParameter("platformName");
		TestRun.setPlatformName(platformName);
		
		String platformVersion = context.getCurrentXmlTest().getParameter("platformVersion");
		TestRun.setPlatformVersion(platformVersion);
		
		String automationName = context.getCurrentXmlTest().getParameter("automationName");
		TestRun.setAutomationName(automationName);
				
		String url = context.getCurrentXmlTest().getParameter("url");
		TestRun.setUrl(url);
		
		String udid = context.getCurrentXmlTest().getParameter("udid");
		TestRun.setUdid(udid);
	}	
}
