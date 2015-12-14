package com.citrix.qa.webinar.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Base page class that every page should extend from.
 * 
 * @author kaavyar
 *
 */
public abstract class WebPage {
	protected WebDriver driver;

	public WebPage(WebDriver driver) {
		this.driver = driver;
		verifyCurrentPage();
	}

	/**
	 * Add any verification logic to check if on correct page
	 */
	public abstract void verifyCurrentPage();

	public WebElement find(By by) {
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					String.format("Element %s not found on page [%s]", by, this.getClass().getSimpleName()), e);
		}
	}

	/**
	 * Checks if an element is present or not. Will not throw exception if not
	 * present
	 * 
	 * @param by
	 *            for the element to check for
	 * @return true or false based on whether the element is found or not
	 */
	public boolean isPresent(By by) {
		try {
			find(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if an element is displayed or not. Will throw an exception if the
	 * element is not present at all
	 * 
	 * @param by
	 *            for the element to check for
	 * @return true or false based on whether the element is displayed or not
	 */
	public boolean isDisplayed(By by) {
		return find(by).isDisplayed();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
