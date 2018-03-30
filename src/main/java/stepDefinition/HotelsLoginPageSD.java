package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hotels.LoginScreenHotels;

/**
 * Created by nkkhan on 3/29/18.
 */
public class HotelsLoginPageSD {

    LoginScreenHotels loginScreen = new LoginScreenHotels();


    @When("^I fill out invalid username and password$")
    public void iFillOutInvalidUsernameAndPassword() throws Throwable {
        loginScreen.enterEmailAddress("test@gmail.com");
        loginScreen.enterPassword("test123");
    }

    @And("^I tap on Sign in button on LoginPage$")
    public void tapOnSignIn(){
        loginScreen.tapOnSignInButton();
    }

    @Then("^I verify invalid error message$")
    public void iVerifyInvalidErrorMessage() throws Throwable {
        loginScreen.verifyErrorMessage();
    }
}
