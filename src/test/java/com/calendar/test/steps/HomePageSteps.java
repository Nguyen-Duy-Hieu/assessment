package com.calendar.test.steps;

import com.calendar.base.BasePOM;
import com.calendar.utils.DateTimeUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.template.utility.DateUtil;


public class HomePageSteps extends BasePOM {
    @Given("^I have launched the Calendar App$")
    public void userAccessedApp() {
        System.out.println("Calendar App is loading");
        getDriver();
        homePage().clickOnSkipButton();
        homePage().clickOnStartButton();
        homePage().acceptPhoneContactAndCalendar();;
    }

    @When("^It is not a weekend$")
    public void IsItNotAWeekend() throws Exception {
        /*if(DateTimeUtils.isWeekend(DateTimeUtils.getCurrentDateSydney()))
            throw new Exception("Today is weekend");*/
    }


    @And("^It is not a public holiday$")
    public void IsItNotAPublicHoliday() throws Exception {
        if(DateTimeUtils.isHoliday(DateTimeUtils.getCurrentDateSydney()))
            throw new Exception("Today is holiday");
    }

    @Then("^I Check if the meeting is created as expected Note (.*)$")
    public void iCheckIfTheMeetingIsCreatedAsExpectedNote(String contact) {
        homePage().verifyMeeting(contact);
    }
}
