package com.citrix.qa.webinar.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manage page model
 * 
 * @author kaavyar
 */
public class ManagePage {

	@FindBy(id = "schedule.submit.button")
	public WebElement scheduleSubmitButton;

	public ManagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
