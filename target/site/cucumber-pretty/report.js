$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotels.feature");
formatter.feature({
  "line": 2,
  "name": "Verify hotels app features",
  "description": "",
  "id": "verify-hotels-app-features",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@hotels"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "hotelsSD.iAmOnHotelsHomePage()"
});
formatter.result({
  "duration": 25592161882,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Verify invalid login on android hotel app",
  "description": "",
  "id": "verify-hotels-app-features;verify-invalid-login-on-android-hotel-app",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@hotel-login"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#    When I scroll down on page"
    }
  ],
  "line": 10,
  "name": "I tap on sign in button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I fill out invalid username and password",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I tap on Sign in button on LoginPage",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I verify invalid error message",
  "keyword": "Then "
});
formatter.match({
  "location": "hotelsSD.iTapOnSignInButton()"
});
formatter.result({
  "duration": 18250554132,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate the Element using: Located by Locator map: \n- native content: \"By.chained({By.AccessibilityId: Open drawer menu})\" \n- html content: \"by id or name \"mainMenu\"\"\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.5.2\u0027, revision: \u002710229a9\u0027, time: \u00272017-08-21T17:29:55.15Z\u0027\nSystem info: host: \u0027Nazmuls-MacBook-Pro.local\u0027, ip: \u00272604:2000:f214:4600:7045:f5d0:19a8:3a23\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.3\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: unknown\n\tat base.BaseAction.tapOn(BaseAction.java:60)\n\tat hotels.LandingPageHotels.tapOnMainMenuButton(LandingPageHotels.java:39)\n\tat stepDefinition.hotelsSD.iTapOnSignInButton(hotelsSD.java:33)\n\tat ✽.And I tap on sign in button(hotels.feature:10)\n",
  "status": "failed"
});
formatter.match({
  "location": "HotelsLoginPageSD.iFillOutInvalidUsernameAndPassword()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HotelsLoginPageSD.tapOnSignIn()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HotelsLoginPageSD.iVerifyInvalidErrorMessage()"
});
formatter.result({
  "status": "skipped"
});
});