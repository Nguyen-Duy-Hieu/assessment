package com.calendar.test.steps;

import com.calendar.base.BasePOM;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HomePageSteps extends BasePOM {
    @Given("^I have launched the Calendar App$")
    public void userAccessedApp() {
        System.out.println("Calendar App is loading");
        getDriver();
        String str = "";
    }

    @When("^It is not a weekend$")
    public void itIsNotAWeekend() {
    }
}
