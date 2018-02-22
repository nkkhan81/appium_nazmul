import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends BaseAction{

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
        tapOn(signInButton);
    }

    public String errorMessage(){
        return getTextFromElement(errorMessage);
    }


}
