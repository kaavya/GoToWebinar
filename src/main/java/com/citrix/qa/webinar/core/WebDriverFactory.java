package com.citrix.qa.webinar.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverFactory {
	public static WebDriver create(String browser, String chromedriver) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromedriver);
			return new ChromeDriver();
		} else {
			return new HtmlUnitDriver();
		}
	}
}
