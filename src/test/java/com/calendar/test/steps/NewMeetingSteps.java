package com.calendar.test.steps;

import com.calendar.base.BasePOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class NewMeetingSteps extends BasePOM {

    @Then("^I want to book a meeting with the title (.*)$")
    public void iWantToBookAMeetingWithTheTitleTitle(String title) {
        homePage().createNewMeeting();
        newMeetingPage().setTitle(title);
    }

    @And("^Set Meeting duration as (.*) in the evening$")
    public void setMeetingDurationAsDurationInTheEvening(String duration) {
        newMeetingPage().selectDuration(duration);
    }

    @And("^I invite (.*)$")
    public void iInvitePeople(String contact) {
        newMeetingPage().selectContact(contact);
    }

    @And("^I save the meeting$")
    public void iSaveTheMeeting() {
        newMeetingPage().saveMeeting();
    }
}
