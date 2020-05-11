package com.cognizant.test.step.definitions;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;

import com.cognizant.test.common.utils.CapabilityFactoryUtil;
import com.cognizant.test.common.utils.DriverManagerUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Class having cucumber annotations for Hooks
 * @author Amit Taware
 *
 */
public class Hooks {

	//Initiates appium driver for running session
	@Before
    public void scenarioSetUp(Scenario scenario) throws ExecuteException, IOException, InterruptedException {
		CapabilityFactoryUtil.initiateDriver();	
    }	
	
	//Terminates appium driver for running session
	@After
    public void scenarioTearDown(Scenario scenario){
		DriverManagerUtil.stopAppiumDriver();		
    }
}
