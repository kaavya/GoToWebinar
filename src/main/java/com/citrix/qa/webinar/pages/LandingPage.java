package com.citrix.qa.webinar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Landing page model
 * 
 * @author kaavyar
 */
public class LandingPage {

	@FindBy(id = "emailAddress")
	public WebElement emailTextBox;

	@FindBy(id = "password")
	public WebElement passwordTextBox;

	@FindBy(id = "submit")
	public WebElement submitButton;

	@FindBy(className = "header-logo")
	public WebElement headerLogo;

	@FindBy(className = "icon schedule-meeting")
	public WebElement scheduleMeetingIcon;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
		emailTextBox.sendKeys(email);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		submitButton.click();
	}
}
