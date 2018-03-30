package hotels;

import base.BaseAction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.Dimension;
import stepDefinition.AppiumDriverSD;

import java.io.IOException;

public class LandingPageHotels extends BaseAction {

    @AndroidFindBy(id = "com.hcom.android:id/btnPositive")
    @iOSFindBy(accessibility = "yesButton")
    private MobileElement yesButton;

    @AndroidFindBy(accessibility = "Open drawer menu")
    private MobileElement mainMenu;

    @AndroidFindBy(id = "com.hcom.android:id/drawer_header_sign_in")
    private MobileElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@id='com.hcom.android:id/rewards_free_moon_image")
    private MobileElement free;

    @AndroidFindBy(uiAutomator = ("new UiScrollable(new UiSelector().resourceId(\"com.hcom.android:id/rewards_main_layout\")).getChildByText("
            + "new UiSelector().className(\"android.widget.TextView\"), \"SIGN IN\");"))

    private MobileElement signInButtonBellow;

    public void tapOnYesButton() {
        clickOn(yesButton);
    }

    public void tapOnMainMenuButton() {
        TouchAction a2 = new TouchAction(AppiumDriverSD.getAppiumDriver());
        a2.tap(84,155).perform();
//        tapOn(signInButton);
//        tapOn(mainMenu);
    }

    public void tapOnSignInButton() {
        clickOn(signInButton);
    }

    public void tapOnSignInButtonBellow() {

        TouchAction a2 = new TouchAction(AppiumDriverSD.getAppiumDriver());
        a2.tap(84,155).perform();
        tapOn(signInButton);

//        MobileElement element = (MobileElement) AppiumDriverSD.getAppiumDriver().findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"com.hcom.android:id/rewards_main_layout\")).getChildByText("
//                        + "new UiSelector().className(\"android.widget.TextView\"), \"SIGN IN\")"));
//        clickOn(element);
    }






    public void scrollDownToSignIn(){
        int pressX = AppiumDriverSD.getAppiumDriver().manage().window().getSize().width / 2;
        int bottomY = AppiumDriverSD.getAppiumDriver().manage().window().getSize().height * 4/5;
        int topY = AppiumDriverSD.getAppiumDriver().manage().window().getSize().height / 8;

        boolean isElementDisplayed = isDisplayed(signInButtonBellow);
        while (!isElementDisplayed){
            TouchAction tAction=new TouchAction(AppiumDriverSD.getAppiumDriver());;
            tAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
        }
    }
    /*
     * don't forget that it's "natural scroll" where
     * fromY is the point where you press the and toY where you release it
     */
    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction tAction=new TouchAction(AppiumDriverSD.getAppiumDriver());;
        tAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
    }



}
