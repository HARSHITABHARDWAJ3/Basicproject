Feature: Login

Scenario: LocatorsPractice
Given Launch Chrome browser
When opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And enters Username as "Admin" and Password as "admin123"
Then perform the tests
When click on Log out link
And User close browser
