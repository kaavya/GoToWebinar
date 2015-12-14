package com.citrix.qa.webinar;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.citrix.qa.webinar.pages.LoginPage;
import com.citrix.qa.webinar.pages.MyWebinarsPage;
import com.citrix.qa.webinar.pages.SchedulePage;

public class BasicTest {
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void getTestData() {
		driver.get("https://global.gotowebinar.com/webinars.tmpl");
	}

	@Test
	public void scheduleWebinar() {
		LoginPage loginPage = new LoginPage(driver);
		MyWebinarsPage myWebinarsPage = loginPage.login("kaavya.r@gmail.com", "abcd1234");
		SchedulePage schedulePage = myWebinarsPage.scheduleAWebinar();
		schedulePage.setTimeZone("New Webinar");
		schedulePage.setDescription("Test Webinar Description");
		schedulePage.setStartDate(new Date());
		schedulePage.setStartTime("2:00", "PM");
		schedulePage.setEndTime("4:00", "PM");
		schedulePage.setTimeZone("(GMT-06:00) Mexico City");
		schedulePage.setLanguage("Español");
		myWebinarsPage = schedulePage.schedue();
		Assert.assertEquals(myWebinarsPage.getTitle(), "My Webinars");
	}

	@AfterClass
	public void cleanup() {
		driver.close();

	}

}
