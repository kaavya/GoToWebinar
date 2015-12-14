package com.citrix.qa.webinar.pages;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.citrix.qa.webinar.utils.DateUtility;

public class SchedulePage {

	@FindBy(id = "emailAddress")
	public WebElement signinEmail;

	@FindBy(id = "name")
	public WebElement titleBox;

	@FindBy(id = "description")
	public WebElement descBox;

	@FindBy(id = "webinarTimesForm.dateTimes_0.startTime")
	public WebElement startTime;

	@FindBy(id = "webinarTimesForm_dateTimes_0_startAmPm_trig")
	public WebElement startTimeSelect;

	@FindBy(id = "webinarTimesForm.dateTimes_0.endTime")
	public WebElement endTime;

	@FindBy(id = "webinarTimesForm_dateTimes_0_endAmPm_trig")
	public WebElement endTimeSelect;

	@FindBy(id = "webinarTimesForm_timeZone_trig")
	public WebElement timeZone;

	@FindBy(id = "schedule.submit.button")
	public WebElement scheduleSubmit;

	public SchedulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String setName() {
		String n;
		n = DateUtility.getName();
		titleBox.sendKeys(n.subSequence(0, n.length()));
		return n;
	}

	public void setDate() {
		Date today = new Date();
		Date sd;
		sd = DateUtility.addDays(today, 3);
		startTime.clear();
		startTime.sendKeys(sd.toString());

	}

}
