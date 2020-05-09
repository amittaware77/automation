package com.cognizant.test.uitest.android.utils;

import java.util.Collection;

import com.cognizant.test.common.utils.LoggerUtil;
import com.cognizant.test.common.utils.MobileInteractUtil;
import com.cognizant.test.uitest.android.pageobjects.BasePageAndroid;
import com.cognizant.test.uitest.interfaces.BaseInterface;

public class BaseUtilAndroid implements BaseInterface{
	protected BasePageAndroid basePageAndroid;

	public BaseUtilAndroid() {
		basePageAndroid = new BasePageAndroid();
	}
		
	@Override
	public boolean verifyTitle(String title) {
		boolean status = false;
		
		switch (title) {
			case "Welcome": {
				status = MobileInteractUtil.verifyAttribute(basePageAndroid.welcomeTxt, "text", title);			
				break;
			}
			case "Login": {
				status = MobileInteractUtil.verifyAttribute(basePageAndroid.loginTxt, "text", title);
				break;
			}
			case "Home": {
				status = MobileInteractUtil.isPresent(basePageAndroid.cameraImg);
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

	@Override
	public boolean enterText(String mobileElementTitle, String text) {
		boolean status = false;
		
		switch (mobileElementTitle) {
			case "Email": {
				status = MobileInteractUtil.sendKeys(basePageAndroid.emailTxb, text);
				break;
			}
			case "Password": {
				status = MobileInteractUtil.sendKeys(basePageAndroid.passwordTxb, text);
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
		} else {
			if(mobileElementTitle.equals("Email")) {
				LoggerUtil.logMessage("Text " + text + " not enterd in " + mobileElementTitle + " text field on Welcome screen.");
			}
			else if(mobileElementTitle.equals("Password")) {
				LoggerUtil.logMessage("Text " + text + " not enterd in " + mobileElementTitle + " text field on Login screen.");

			}
		}
		return status;	
	}
	
	@Override
	public boolean clearText(String mobileElementTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyText(String mobileElementTitle, String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyTextContains(String mobileElementTitle, String text) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean verifyLabel(String label) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tapOnElement(String mobileElementTitle) {
		boolean status = false;		
		
		switch(mobileElementTitle) {
			case "Sign in": {
				status = MobileInteractUtil.click(basePageAndroid.signInBtn);						
				break;
			}
			case "Continue": {
				status = MobileInteractUtil.click(basePageAndroid.continueBtn);						
				break;
			}
			
			case "Login": {
				status = MobileInteractUtil.click(basePageAndroid.loginBtns.get(0));						
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
	
	@Override
	public boolean isElementDisplayed(String mobileElementTitle) {
		boolean status = false;		
		
		switch(mobileElementTitle) {
			case "Sign in to your account": {
				status = MobileInteractUtil.isPresent(basePageAndroid.signInToYourAccountTxt);						
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

	@Override
	public boolean isElementEnabled(String mobileElementTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean IsElementSelected(String checkBox) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyEmailId() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turnWifiOff(Collection<String> collection) {
		// TODO Auto-generated method stub
		return false;
	}
}
