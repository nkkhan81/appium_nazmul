import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInvalidLogin {

    @Test
    public void verifyInvalidLogin() {
        LandingPage landingPage = new LandingPage();
        LoginScreen loginScreen = new LoginScreen();

        //Landing screen actions
        landingPage.tapOnYesButton();
        landingPage.tapOnMainMenuButton();
        landingPage.tapOnSignInButton();
        //Login Screen actions
        loginScreen.enterEmailAddress("mohammad@technosoftacademy.io");
        loginScreen.enterPassword("Test12345");
        loginScreen.tapOnSignInButton();

        //Create step to assert error message
        Assert.assertEquals(loginScreen.errorMessage(),
                "We no longer support signing in with this version of the app. Please update to the latest version.");
    }
}
