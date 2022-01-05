Feature: I am going to validate the Login function


@regression
Scenario Outline: I am Going validate the login function with valid username and valid password
When I am going to enter "<username>" nd "<password>"
And I will click the login button

Examples:

|username|password|
|Hameed|Hussain|

