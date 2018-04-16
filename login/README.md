# Technology/Libraries

Java, Junit and Selenium 

# Custom Runner

UiRunner - is responsible for creating test environment which is initialising driver, 
it needs to be annotated as @RunWith(UiRunner.class) for every test class 

# Custom Annotations 

WithBrowser - its Class level annotation to specify on which browser test needs to be run.
FlushCookies - Test level annotation to delete cookies before/after the test run. 
AddWebScrapperCookie - Test level annotation to add cookies which is same as scrapper login. 

# Test Environment 

It creates an instance of driver and provides driver across test throughout execution time

# DriverProvider 

It instantiate driver based on the browser provided, currently it supports Chrome and Firefox along with cookies enabled/disabled. 
Disabling cookies works seamlessly fine with Firefox, not up to the mark with Chrome. its driver related issues. 

# Operating system, Browser and Driver 

Currently its built for Mac OS 64 bit, Chrome version from 64 to 66 and Firefox V59. Selenium V3.11.0 is used. 

# Elements

Elements wrapper has been built for all used elements (WebElements, Text, TextBox, Button and Link) 

# Page Object Model

Elements are defined using page object model for enabling proxy elements 

# Assertions

Assertions util has been built for Login Page, Welcome Page and Cookies which are used across test

# Test Coverage 
1. Test coverage has been provided for all sunny day scenario as well as rainy day scenario 
2. Cases covered for Login (creation of cookies validation), refreshing (reading cookies), 
updated user session (update cookies) and deleting user session (deleting cookies)
3. Test cases covered for enabling and disabling cookies 

# Screenshot 
If test fails, framework takes screenshot and stores at targets/screenshots
