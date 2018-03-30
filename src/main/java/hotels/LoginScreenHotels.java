package hotels;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class LoginScreenHotels extends BaseAction {

    @AndroidFindBy(id = "com.hcom.android:id/txt_sign_in_email_address")
    private MobileElement emailTextField;

    @AndroidFindBy(id = "com.hcom.android:id/txt_sign_in_password")
    private MobileElement passwordTextField;

    @AndroidFindBy(id = "com.hcom.android:id/aut_sig_p_signin_btn_sign_in")
    private MobileElement signInButton;

    @AndroidFindBy(id = "com.hcom.android:id/alertMessage")
    private MobileElement errorMessage;

    public void enterEmailAddress(String email) {
        setValue(emailTextField, email);
    }

    public void enterPassword(String password) {
        setValue(passwordTextField, password);
    }

    public void tapOnSignInButton() {
        clickOn(signInButton);
    }

    public String errorMessage(){
        return getTextFromElement(errorMessage);
    }

    public void verifyErrorMessage(){

        Assert.assertEquals(errorMessage(),
                "We no longer support signing in with this version of the app. Please update to the latest version.");
    }


}
