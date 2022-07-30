Feature: Primus Bank Login Functionality

Background: Launch Browser and Open Application
Given user open browser with "Chrome" exe
Given user enter url as

@SmokeTest
Scenario: Verify Login functionality with valid credentials and check branches
When User enter username as "Admin"
When User enter Password as "Admin"
When User click on login button
When User click on Branches
When User Select Country as "INDIA"
When User Select State as "Andhra Pradesh"
When User Select city as "Hyderabad"
When User Clickon Search button
Then User find all branch in city