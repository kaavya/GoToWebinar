package com.citrix.qa.webinar.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.citrix.qa.webinar.core.WebPage;

public class SchedulePage extends WebPage {

	private final static By titleTextBox = By.id("name");
	private final static By descriptionTextArea = By.id("description");
	private final static By startDateTextBox = By.id("webinarTimesForm.dateTimes_0.baseDate");
	private final static By endDateTextBox = By.id("recurrenceForm.endDate");
	private final static By startTimeTextBox = By.id("webinarTimesForm.dateTimes_0.startTime");
	private final static By endTimeTextBox = By.id("webinarTimesForm.dateTimes_0.endTime");

	private final static By startTimeTrig = By.id("webinarTimesForm_dateTimes_0_startAmPm_trig");
	private final static By endTimeTrig = By.id("webinarTimesForm_dateTimes_0_endAmPm_trig");
	private final static By timeZoneTrig = By.id("webinarTimesForm_timeZone_trig");
	private final static By languageTrig = By.id("language_trig");
	private final static By recursTrig = By.id("recurrenceForm_recurs_trig");

	private final static By startTimeMenu = By.id("webinarTimesForm_dateTimes_0_startAmPm__menu");
	private final static By endTimeMenu = By.id("webinarTimesForm_dateTimes_0_endAmPm__menu");
	private final static By timeZoneMenu = By.id("webinarTimesForm_timeZone__menu");
	private final static By languageMenu = By.id("language__menu");
	private final static By recursMenu = By.id("recurrenceForm_recurs__menu");

	private final static String option = "li[title=<placeholder>]";

	private final static By scheduleSubmit = By.id("schedule.submit.button");

	public SchedulePage(WebDriver driver) {
		super(driver);
	}

	public void setTitle(String title) {
		find(titleTextBox).sendKeys(title);
	}

	public void setDescription(String description) {
		find(descriptionTextArea).sendKeys(description);
	}

	public void setRecurrence(String recurrence) {
		find(recursTrig).click();
		find(recursMenu).findElement(By.cssSelector(option.replace("<placeholder>", recurrence))).click();
	}

	public void setStartDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, YYYY");
		find(startDateTextBox).sendKeys(sdf.format(date));
	}

	public void setEndDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, YYYY");
		find(endDateTextBox).sendKeys(sdf.format(date));
	}

	public void setStartTime(String time, String meridian) {
		find(startTimeTextBox).sendKeys(time);
		find(startTimeTrig).click();
		find(startTimeMenu).findElement(By.cssSelector(option.replace("<placeholder>", meridian))).click();
	}

	public void setEndTime(String time, String meridian) {
		find(endTimeTextBox).sendKeys(time);
		find(endTimeTrig).click();
		find(endTimeMenu).findElement(By.cssSelector(option.replace("<placeholder>", meridian))).click();
	}

	public void setTimeZone(String timeZone) {
		find(timeZoneTrig).click();
		find(timeZoneMenu).findElement(By.cssSelector(option.replace("<placeholder>", timeZone))).click();
	}

	public void setLanguage(String language) {
		find(languageTrig).click();
		find(languageMenu).findElement(By.cssSelector(option.replace("<placeholder>", language))).click();
	}

	public MyWebinarsPage schedue() {
		find(scheduleSubmit).click();
		return new MyWebinarsPage(driver);
	}

	@Override
	public void verifyCurrentPage() {
		// TODO Auto-generated method stub

	}

}
