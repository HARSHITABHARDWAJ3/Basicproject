Feature: Login

Scenario: Successful Login with Valid Credentials
Given User Launch Chrome browser
When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And User enters Username as "Admin" and Password as "admin123"
And Click on Login
Then login Page Title should be "Dashboard"
When User click on Log out link
Then logout Page Title should be "Login"
And close browser
