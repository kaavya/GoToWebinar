package com.citrix.qa.webinar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.citrix.qa.webinar.core.WebPage;

public class LoginPage extends WebPage {
	private static final By emailTextBox = By.id("emailAddress");
	private static final By passwordTextBox = By.id("password");
	private static final By submitButton = By.id("submit");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get("https://global.gotowebinar.com/webinars.tmpl");
	}

	/**
	 * Login method
	 * 
	 * @param email
	 * @param password
	 */
	public MyWebinarsPage login(String email, String password) {
		find(emailTextBox).sendKeys(email);
		find(passwordTextBox).clear();
		find(passwordTextBox).sendKeys(password);
		find(submitButton).click();
		return new MyWebinarsPage(driver);
	}

	@Override
	public void verifyCurrentPage() {
		Assert.assertTrue(isDisplayed(emailTextBox), "Verify emailTextBox is displayed on LandingPage");
		Assert.assertTrue(isDisplayed(passwordTextBox), "Verify passwordTextBox is displayed on LandingPage");
		Assert.assertTrue(isDisplayed(submitButton), "Verify submitButton is displayed on LandingPage");
	}

}
