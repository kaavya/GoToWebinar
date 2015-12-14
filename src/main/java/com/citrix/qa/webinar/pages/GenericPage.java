package com.citrix.qa.webinar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.citrix.qa.webinar.core.WebPage;
import com.citrix.qa.webinar.util.Constants;

/**
 * Page class for common header and footer functionalities
 * 
 * @author kaavyar
 *
 */
public class GenericPage extends WebPage {

	private static final By logoutLink = By.name("topNavLnk_logout");

	public GenericPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyCurrentPage() {
		// TODO Auto-generated method stub
	}

	/**
	 * Logs out a user if already logged in
	 */
	public LoginPage logout() {
		if (isPresent(logoutLink)) {
			find(logoutLink).click();
		}
		driver.get(Constants.url);
		return new LoginPage(driver);
	}

}
