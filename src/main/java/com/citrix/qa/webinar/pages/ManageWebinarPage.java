package com.citrix.qa.webinar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageWebinarPage extends GenericPage {

	private static final By title = By.id("trainingName");
	private static final By dateAndTime = By.cssSelector("#dateTime .time");

	public ManageWebinarPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyCurrentPage() {
		Assert.assertEquals(driver.getTitle(), "Manage Webinar");
	}

	public String getTitle() {
		return find(title).getText();
	}

	public String getDateAndTime() {
		return find(dateAndTime).getText();
	}

}
