package com.cognizant.test.androidpages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.test.common.config.Config;
import com.cognizant.test.common.utils.DriverManagerUtil;
import com.cognizant.test.common.utils.LoggerUtil;
import com.cognizant.test.common.utils.MobileInteractUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Class having page elements and methods for base page android
 * @author Amit Taware
 *
 */
public class BasePageAndroid {

	@AndroidFindBy(id = Config.APP_PCKAGE + ":id/signin_to_yourAccount")
	public MobileElement signInToYourAccountTxt;
	
	@AndroidFindBy(id = Config.APP_PCKAGE + ":id/sign_in_button")
	public MobileElement signInBtn;
	
	@AndroidFindBy(id = Config.APP_PCKAGE + ":id/rs_search_src_text")
	public MobileElement searchTbx;
	
	@AndroidFindBy(id = Config.APP_PCKAGE + ":id/search_right_cam_img")
	public MobileElement cameraImg;

	@AndroidFindBy(className = "android.widget.EditText")
	public MobileElement emailTxb;

	@AndroidFindBy(className = "android.widget.Button")
	public MobileElement continueBtn;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public MobileElement passwordTxb;
	
	@AndroidFindBy(className = "android.widget.Button")
	public List<MobileElement> loginBtns;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Welcome']")
	public MobileElement welcomeTxt;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Login']")
	public MobileElement loginTxt;
	
	
	public BasePageAndroid() {  
		PageFactory.initElements(new AppiumFieldDecorator(DriverManagerUtil.getAppiumDriver()), this); 
	}
	
	//Checks whether the element is displayed or not
	public boolean isElementDisplayed(String mobileElementTitle) {
		boolean status = false;		
		
		switch(mobileElementTitle) {
			case "Sign in to your account": {
				status = MobileInteractUtil.isPresent(signInToYourAccountTxt);						
				break;
			}
		}		
		
		if(status) {
			LoggerUtil.logMessage(mobileElementTitle + " text is displayed on the Landing screen.");			
		}
		else
			LoggerUtil.logMessage(mobileElementTitle + " text is not displayed on the Landing screen.");
		
		return status;
	}
	
	//Checks the title of the page
	public boolean verifyTitle(String title) {
		boolean status = false;
		
		switch (title) {
			case "Welcome": {
				status = MobileInteractUtil.verifyAttribute(welcomeTxt, "text", title);			
				break;
			}
			case "Login": {
				status = MobileInteractUtil.verifyAttribute(loginTxt, "text", title);
				break;
			}
			case "Home": {
				status = MobileInteractUtil.isPresent(cameraImg);
				break;
			}
		}
		
		if (status) {
			LoggerUtil.logMessage("I am navigated to " + title + " screen.");
			}
		else {
			LoggerUtil.logMessage("I am not navigated to " + title + " screen.");
		}
				
		return status;
	}
	
	//Performs click operation on element
	public boolean tapOnElement(String mobileElementTitle) {
		boolean status = false;		
		
		switch(mobileElementTitle) {
			case "Sign in": {
				status = MobileInteractUtil.click(signInBtn);						
				break;
			}
			case "Continue": {
				status = MobileInteractUtil.click(continueBtn);						
				break;
			}
			
			case "Login": {
				status = MobileInteractUtil.click(loginBtns.get(0));						
				break;
			}
		}
		
		if(status) {
			if(mobileElementTitle.equals("Sign in")) {
				LoggerUtil.logMessage("Clicked on " + mobileElementTitle + " button on Landing screen.");	
			}
			else if(mobileElementTitle.equals("Continue")) {
				LoggerUtil.logMessage("Clicked on " + mobileElementTitle + " button on Welcome screen.");	
			}
			else if(mobileElementTitle.equals("Login")) {
				LoggerUtil.logMessage("Clicked on " + mobileElementTitle + " button on Login screen.");	
			}
		}
		else
			if(mobileElementTitle.equals("Sign in")) {
				LoggerUtil.logMessage("Could not click on " + mobileElementTitle + " button on Landing screen.");
			}
			else if(mobileElementTitle.equals("Continue")) {
				LoggerUtil.logMessage("Could not click on " + mobileElementTitle + " button on Welcome screen.");
			}
			else if(mobileElementTitle.equals("Login")) {
				LoggerUtil.logMessage("Could not click on " + mobileElementTitle + " button on Login screen.");
			}
		
		return status;
	}
	
	//Enters text in the text field
	public boolean enterText(String mobileElementTitle, String text) {
		boolean status = false;
		
		switch (mobileElementTitle) {
			case "Email": {
				status = MobileInteractUtil.sendKeys(emailTxb, text);
				break;
			}
			case "Password": {
				status = MobileInteractUtil.sendKeys(passwordTxb, text);
				break;
			}
		}
		
		
		if (status) {
			if(mobileElementTitle.equals("Email")) {
				LoggerUtil.logMessage("Text " + text + " enterd in " + mobileElementTitle + " text field on Welcome screen.");
			}
			else if(mobileElementTitle.equals("Password")) {
				LoggerUtil.logMessage("Text " + text + " enterd in " + mobileElementTitle + " text field on Login screen.");

			}
		}
		else {
			if(mobileElementTitle.equals("Email")) {
				LoggerUtil.logMessage("Text " + text + " not enterd in " + mobileElementTitle + " text field on Welcome screen.");
			}
			else if(mobileElementTitle.equals("Password")) {
				LoggerUtil.logMessage("Text " + text + " not enterd in " + mobileElementTitle + " text field on Login screen.");

			}
		}
		return status;	
	}
}
