Feature: createUser
In order to log in As a user I want to create an account
@mytag

Scenario: Create new user with valid credentials
Given I have entered email into the form
And I have also entered username into the form
And I have also entered password "TestTestar1337!" into the form
When I press Sign up
Then the confirmation message should be "Success | Mailchimp" displayed

Scenario: Create new user with too long username
Given I have entered email into the form
And I have also entered too long username "TESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestar" into the form
And I have also entered password "TestTestar1337!" into the form
When I press Sign up
Then the error message should be "Enter a value less than 100 characters long" displayed

Scenario: Create new user with busy username
Given I have entered email into the form
And I have also entered a busy username "username" into the form
And I have also entered password "TestTestar1337!" into the form
When I press Sign up
Then the error message for busy username should be "Another user with this username already exists. Maybe it's your evil twin. Spooky." displayed

Scenario: emailMissing
Given I have entered no email into the form
And I have also entered username into the form
And I have also entered password "TestTestar1337!" into the form
When I press Sign up
Then the error message for no value should be "Please enter a value" displayed