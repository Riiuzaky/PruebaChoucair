# author: Jonathan Cruz
# language: en

  @Suite
  Feature: Recruitment a new person

    Scenario: Hire a person
      Given "Jonathan" navigate to web page
      When loggin whith valid credentials
      And go to the section recruitment
      And fill the form whith the data a new employed
      Then can see the data of a new employed in the list  whit state Hired

      




