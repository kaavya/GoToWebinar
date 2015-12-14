package com.citrix.qa.webinar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.citrix.qa.webinar.core.WebPage;

/**
 * Landing page model
 * 
 * @author kaavyar
 */
public class MyWebinarsPage extends WebPage {

	private static final By headerLogo = By.className("header-logo");
	private static final By scheduleAWebinarLink = By.id("scheduleWebinar");

	public MyWebinarsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks on schedule meeting icon
	 * 
	 * @return
	 */
	public SchedulePage scheduleAWebinar() {
		find(scheduleAWebinarLink).click();
		return new SchedulePage(driver);
	}

	@Override
	public void verifyCurrentPage() {
		Assert.assertTrue(isDisplayed(headerLogo), "Verify headerLogo is displayed on LandingPage");
		Assert.assertTrue(isDisplayed(scheduleAWebinarLink), "Verify scheduleAWebinarLink is displayed on LandingPage");
	}

}
