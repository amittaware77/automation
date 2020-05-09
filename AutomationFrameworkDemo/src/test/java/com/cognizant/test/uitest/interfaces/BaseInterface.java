package com.cognizant.test.uitest.interfaces;

import java.util.Collection;

public interface BaseInterface {
	public boolean verifyTitle(String title);
	
	public boolean enterText(String mobileElementTitle, String text);
	
	public boolean clearText(String mobileElementTitle); 
	
	public boolean verifyText(String mobileElementTitle, String text);
	
	public boolean verifyTextContains(String mobileElementTitle, String text);
	
	public boolean verifyLabel(String label);

	public boolean tapOnElement(String mobileElementTitle);

	public boolean isElementDisplayed(String mobileElementTitle);
	
	public boolean isElementEnabled(String mobileElementTitle);

	public boolean IsElementSelected(String checkBox);

	public boolean verifyEmailId();

	public boolean turnWifiOff(Collection<String> collection);

}
