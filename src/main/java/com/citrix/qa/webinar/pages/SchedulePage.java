package com.citrix.qa.webinar.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page model for Schedule Webinar Page
 * 
 * @author kaavyar
 *
 */
public class SchedulePage extends GenericPage {

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

	private final static By uiDatePickerNext = By.xpath("//span[text()='Next']");
	private final static By uiDatePickerMonth = By.className("ui-datepicker-month");
	private final static By uiDatePickerYear = By.className("ui-datepicker-year");

	private final static String dayXPath = "//td[@data-handler='selectDay']//*[text()=<placeholder>]";

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
		find(startDateTextBox).click();
		setDateInUIDatePicker(date);
	}

	public void setEndDate(Date date) {
		find(endDateTextBox).click();
		setDateInUIDatePicker(date);
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

	public ManageWebinarPage schedule() {
		find(scheduleSubmit).click();
		return new ManageWebinarPage(driver);
	}

	// Sets a date in ui date picker on the page
	private void setDateInUIDatePicker(Date date) {
		// Validate start date
		if (date.before(new Date())) {
			throw new IllegalArgumentException("Start date cannot be before today");
		}
		SimpleDateFormat month = new SimpleDateFormat("MMMM");
		SimpleDateFormat year = new SimpleDateFormat("YYYY");
		SimpleDateFormat day = new SimpleDateFormat("d");

		// Move next till month and year are as expected
		while (!month.format(date).equals(find(uiDatePickerMonth).getText())
				|| !year.format(date).equals(find(uiDatePickerYear).getText())) {
			find(uiDatePickerNext).click();
		}

		// Once month and day are selected click on the desired day
		find(By.xpath(dayXPath.replace("<placeholder>", day.format(date)))).click();
	}

	@Override
	public void verifyCurrentPage() {
		// TODO ADD VERIFICATION HERE
	}

}
