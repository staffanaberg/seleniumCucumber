Feature: emailMissing
In order to log in As a user I want to create an account
@mytag
Scenario: Create new user with valid credentials
Given I have entered email "" into the form
And I have also entered username "emmalopeznelson" into the form
And I have also entered password "Gustav1337!" into the form
When I press Sign up
Then the error message should be "Please enter a value" displayed