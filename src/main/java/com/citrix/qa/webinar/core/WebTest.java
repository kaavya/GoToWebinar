package com.citrix.qa.webinar.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.citrix.qa.webinar.pages.GenericPage;
import com.citrix.qa.webinar.util.Constants;

public class WebTest {
	protected WebDriver driver;

	@Parameters({ "browser", "chromedriverpath" })
	@BeforeClass
	public void setup(@Optional("chrome") String browser, @Optional("chromedriver") String chromedriver) {
		driver = WebDriverFactory.create(browser, chromedriver);
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
