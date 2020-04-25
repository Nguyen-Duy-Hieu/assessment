Feature: Access aCalendar app
  Veirfy create new meeting is success in aCalendar APP

  @regression
  Scenario Outline: Access aCalendar App
    Given I have launched the Calendar App
    When It is not a weekend


    Examples:
      |title|duration|people|
      |Introduction|30'|A Cau Loi|