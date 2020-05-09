package com.cognizant.test.uitest.android.pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cognizant.test.common.config.Config;
import com.cognizant.test.common.utils.DriverManagerUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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

}
