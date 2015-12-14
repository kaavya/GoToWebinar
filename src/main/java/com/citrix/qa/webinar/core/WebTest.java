package com.citrix.qa.webinar.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.citrix.qa.webinar.pages.GenericPage;
import com.citrix.qa.webinar.util.Constants;

public class WebTest {
	protected WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Constants.url);
	}

	@BeforeMethod
	public void prepare() {
		GenericPage genericPage = new GenericPage(driver);
		genericPage.logout();
	}

	@AfterClass
	public void cleanup() {
		driver.quit();
	}
}
