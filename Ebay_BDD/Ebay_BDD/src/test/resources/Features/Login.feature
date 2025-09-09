Feature: check user is able to login with valid credetials
Scenario: successful login
Given login page should be open in default browser
When page loads click on signin button
And enter valid username and click continue
And enter valid password and click continue
Then login successfully and open home page