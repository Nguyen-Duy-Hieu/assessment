Feature: Access aCalendar app
  Veirfy create new meeting is success in aCalendar APP

  @regression
  Scenario Outline: Access aCalendar App
    Given I have launched the Calendar App
    When It is not a weekend
    And It is not a public holiday
    Then I want to book a meeting with the title <title>
    And Set Meeting duration as <duration> in the evening
    And I invite <people>
    And I save the meeting
    Then I Check if the meeting is created as expected Note <people>

    Examples:
      |title|duration|people|
      |Introduction|30'|A Cau Loi|