package com.citrix.qa.webinar;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.citrix.qa.webinar.core.WebTest;
import com.citrix.qa.webinar.pages.LoginPage;
import com.citrix.qa.webinar.pages.ManageWebinarPage;
import com.citrix.qa.webinar.pages.MyWebinarsPage;
import com.citrix.qa.webinar.pages.SchedulePage;
import com.citrix.qa.webinar.util.Constants;
import com.citrix.qa.webinar.util.Utility;

public class BasicTest extends WebTest {

	@Test
	public void verifyWebinarCreatedWithCorrectTitleAndDate() {
		LoginPage loginPage = new LoginPage(driver);
		MyWebinarsPage myWebinarsPage = loginPage.login("kaavya.r@gmail.com", "abcd1234");
		SchedulePage schedulePage = myWebinarsPage.scheduleAWebinar();

		String webinarTitle = "Webinar " + Utility.getUniqueSuffix();
		Date webinarDate = Utility.getXDaysFromNow(3);

		schedulePage.setTitle(webinarTitle);
		schedulePage.setStartDate(webinarDate);
		ManageWebinarPage manageWebinarPage = schedulePage.schedule();

		Assert.assertEquals(manageWebinarPage.getTitle(), webinarTitle,
				"Verifying webinar created with correct title.");
		System.out.println(manageWebinarPage.getDateAndTime());
		System.out.println(Constants.webinarDateFormat.format(webinarDate));
		Assert.assertTrue(
				manageWebinarPage.getDateAndTime().startsWith(Constants.webinarDateFormat.format(webinarDate)),
				"Verifying webinar created with correct date.");
	}
}
