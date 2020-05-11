package com.cognizant.test.step.definitions;

import org.testng.Assert;

import com.cognizant.test.androidpages.BasePageAndroid;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class having step definitions
 * @author Amit Taware
 *
 */
public class BaseStepDefinition {
	protected BasePageAndroid basePageAndroid;
	
	
	public BaseStepDefinition() {
		   basePageAndroid = new BasePageAndroid();
	}
	
	//Verify present on landing screen
  	@Given("^I am on the Landing screen$")
  	public void i_am_on_the_Landing_screen() throws Throwable {
  		boolean status = basePageAndroid.isElementDisplayed("Sign in to your account");
		Assert.assertTrue(status, "Sign in to your account text is not displayed on Landing screen.");
  	}
  	
  	//Verify all Screen title
  	@Then("^I should be navigated to the \"([^\"]*)\" screen$")
  	public void i_should_be_navigated_to_the_screen(String title) throws Throwable {
  		boolean status = basePageAndroid.verifyTitle(title);
  		Assert.assertTrue(status, "I am not navigated to " + title + " screen.");		
  	}	

	//Tap the button on Landing screen
  	@Then("^I tap on the \"([^\"]*)\" button on Landing screen$")
  	public void i_tap_on_the_button_on_Landing_screen(String button) throws Throwable {
  		boolean status = basePageAndroid.tapOnElement(button);
  		Assert.assertTrue(status, "Unable to tap on "+ button +" button on Landing screen.");	
  	}

  	//Enter the email in text field on Welcome screen
  	@Then("^I enter the \"([^\"]*)\" in the text field on Welcome screen$")
  	public void i_enter_the_in_the_text_field_on_Welcome_screen(String email) throws Throwable {
  		boolean status = basePageAndroid.enterText("Email", email);
		Assert.assertTrue(status, "Text " + email + " not entered properly in Email text field on Welcome screen.");	
  	}

  	//Tap the button on Landing screen
  	@When("^I tap on the \"([^\"]*)\" button on the Welcome screen$")
  	public void i_tap_on_the_button_on_the_Welcome_screen(String button) throws Throwable {
  		boolean status = basePageAndroid.tapOnElement(button);
  		Assert.assertTrue(status, "Unable to tap on "+ button +" button on Welcome screen.");	
  	}

  //Enter the password in text field on Login screen
  	@Then("^I enter the \"([^\"]*)\" in the text field on Login screen$")
  	public void i_enter_the_in_the_text_field_on_Login_screen(String password) throws Throwable {
  		boolean status = basePageAndroid.enterText("Password", password);
		Assert.assertTrue(status, "Text " + password + " not entered properly in Email text field on Welcome screen.");	
  	}

  	//Tap the button on Login screen
  	@When("^I tap on the \"([^\"]*)\" button on Login screen$")
  	public void i_tap_on_the_button_on_Login_screen(String button) throws Throwable {
  		boolean status = basePageAndroid.tapOnElement(button);
  		Assert.assertTrue(status, "Unable to tap on "+ button +" button on Login screen.");	
  	}

  	/*@Then("^I enter the\"([^\"]*)\" in search box$")
  	public void i_enter_the_in_search_box(String arg1) throws Throwable {
  	}

  	@Then("^I purchase the random product from list$")
  	public void i_purchase_the_random_product_from_list() throws Throwable {
  	}

  	@When("^I go to the Checkout screen$")
  	public void i_go_to_the_Checkout_screen() throws Throwable {
  	}

  	@Then("^I should see the purchased \"([^\"]*)\" on Checkout screen$")
  	public void i_should_see_the_purchased_on_Checkout_screen(String arg1) throws Throwable {
  	}*/
}
