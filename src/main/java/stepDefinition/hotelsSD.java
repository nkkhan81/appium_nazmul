package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hotels.LandingPageHotels;
import hotels.LoginScreenHotels;

/**
 * Created by nkkhan on 3/28/18.
 */
public class hotelsSD {

    LandingPageHotels landingPage = new LandingPageHotels();

    @Given("^I am on hotels home page$")
    public void iAmOnHotelsHomePage() {
        landingPage.tapOnYesButton();
    }

    @When("^I click on menu button$")
    public void clickOnMainMenu()  {
        landingPage.tapOnMainMenuButton();
    }

    @When("^I scroll down on page$")
    public void ScrollDownOnPage() throws Throwable {
        landingPage.scrollDownToSignIn();
    }

    @When("^I tap on sign in button$")
    public void iTapOnSignInButton() throws Throwable {
        landingPage.tapOnSignInButtonBellow();
    }

}
