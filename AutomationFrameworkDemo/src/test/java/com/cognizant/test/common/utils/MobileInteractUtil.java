package com.cognizant.test.common.utils;

import java.util.Set;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.test.common.config.Config;

import io.appium.java_client.MobileElement;

/**
 * Class having mobile specific reusable methods
 * @author Amit Taware
 *
 */
public class MobileInteractUtil {

	//Switches to WebView
	public boolean switchToWebView() {
		boolean status = false;
		
		Set<String> contextNames = DriverManagerUtil.getAppiumDriver().getContextHandles(); 
	    for (String contextName : contextNames) { 
	        if (contextName.contains("WEBVIEW")) { 
	        	DriverManagerUtil.getAppiumDriver().context(contextName); 
	        	status = true;
	        	break;
	        } 
	    }
	    
	    return status;
	}

	//Waits for mobile element and clicks on it
    public static boolean click(MobileElement mobileElement) {
    	boolean status = false;
		try {
				WebDriverWait wait = new WebDriverWait(DriverManagerUtil.getAppiumDriver(), Config.MEDIUM_PAUSE);
				wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).click();
				status = true;
		} catch (StaleElementReferenceException e1) {
			for (int i = 0; i <= 10; ++i) {
				try {
					WebDriverWait wait = new WebDriverWait(DriverManagerUtil.getAppiumDriver(), Config.MEDIUM_PAUSE);
					wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).click();	
					status = true;
					break;
				} catch (Exception e) {
					continue;
				}	
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			LoggerUtil.logErrorMessage("Unable to click mobileElement: " + mobileElement.toString());
		}
		
		return status;
	}
    
    //Waits for mobile element and enters text in it
    public static boolean sendKeys(MobileElement mobileElement, String text) {
    	boolean status = false;
		try {
				WebDriverWait wait = new WebDriverWait(DriverManagerUtil.getAppiumDriver(), Config.MEDIUM_PAUSE);
				wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
				mobileElement.clear();
				mobileElement.sendKeys(text);
				status = true;
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.logErrorMessage("Unable to set text in mobileElement: " + mobileElement.toString());
		}
		
		return status;
	}
    
    //Waits for mobile element and clears text in it
    public static boolean clear(MobileElement mobileElement) {
    	boolean status = false;
		try {
				WebDriverWait wait = new WebDriverWait(DriverManagerUtil.getAppiumDriver(), Config.MEDIUM_PAUSE);
				wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).clear();
				status = true;
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.logErrorMessage("Unable to clear text in mobileElement: " + mobileElement.toString());
		}
		
		return status;
	}     
         
    //Waits for mobile element visibility
    public static boolean waitForVisible(MobileElement mobileElement, int timeOut) {
    	boolean status = false;
		try {
				WebDriverWait wait = new WebDriverWait(DriverManagerUtil.getAppiumDriver(), timeOut);
				wait.until(ExpectedConditions.visibilityOf(mobileElement));
				status = true;
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.logErrorMessage("WebElement not visible: " + mobileElement.toString());
		}
		
		return status;
	}
    
    //Verifies element is present
   	public static boolean isPresent(MobileElement mobileElement) {
	   	boolean status = false;
	   	
	   	waitForVisible(mobileElement, Config.MEDIUM_PAUSE);   
	   	try {
	   			status = mobileElement.isDisplayed();
   	} catch(Exception e) {
			e.printStackTrace();
			LoggerUtil.logErrorMessage("MobileElement is present: " + mobileElement.toString());
	   	}
		  
       return status;
   	} 
   	 
   	//Verifies element is enabled
   	public static boolean isEnabled(MobileElement mobileElement) {
	   	boolean status = false;
	   	
	   	waitForVisible(mobileElement, Config.MEDIUM_PAUSE);   
	   	try {
	   			status = mobileElement.isEnabled();				 		    
	   	} catch(Exception e) {
			e.printStackTrace();
			LoggerUtil.logErrorMessage("MobileElement is disabled: " + mobileElement.toString());
	   	}
		  
       return status;
   	} 
 
    //Fetches elements specific attribute value
    public static String getAttribute(MobileElement mobileElement, String attribute) {
    	String attributeValue = "";   
    	
    	waitForVisible(mobileElement, Config.MEDIUM_PAUSE);
 	   	try {
 	   			attributeValue = mobileElement.getAttribute(attribute);
         } catch (Exception e) {
        	 e.printStackTrace();
        	 LoggerUtil.logErrorMessage("Unable to get attribute for mobileElement: " + mobileElement.toString());
         }
 	   	
         return attributeValue;
     }
     
    //Determines if an element has a specific text value or not
    public static boolean verifyText(MobileElement mobileElement, String text) {
    	boolean status = false;
    	
    	waitForVisible(mobileElement, Config.MEDIUM_PAUSE);
 	   	try { 	   		
 	   			status = mobileElement.getText().equalsIgnoreCase(text);  
         } catch (Exception e) {        	                
        	 e.printStackTrace();
 			LoggerUtil.logErrorMessage("Unable to verify text for mobileElement: " + mobileElement.toString());
         }
 	   	
         return status;
     }
      
    //Determines if an element has a specific attribute value or not
    public static boolean verifyAttribute(MobileElement mobileElement, String attribute, String attributeValue) {
    	 boolean status = false;
      	
    	 waitForVisible(mobileElement, Config.LARGE_PAUSE);
   	   	 try {
   	   			status = mobileElement.getAttribute(attribute).equalsIgnoreCase(attributeValue);  
             } catch (Exception e) {        	                
            	 e.printStackTrace();
            	 LoggerUtil.logErrorMessage("Unable to verify attribute for mobileElement: " + mobileElement.toString());
             }
   	   	
         return status;
     }
       
    //Determines if an element has a specific attribute value or not
    public static boolean verifyAttributeContains(MobileElement mobileElement, String attribute, String attributeValue) {
    	boolean status = false;   

    	waitForVisible(mobileElement, Config.MEDIUM_PAUSE);    	
	   	try {
		  	status = mobileElement.getAttribute(attribute).contains(attributeValue);  	               	   	 	
	   	  } catch (Exception e) {  	   		  
	        e.printStackTrace();
			LoggerUtil.logErrorMessage("Unable to verify attribute contains for mobileElement: " + mobileElement.toString());
	   	  }
        return status;
    }
	    
}
