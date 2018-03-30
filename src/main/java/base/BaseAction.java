package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.AppiumDriverSD;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseAction {

    /**
     * This is a constructor which initializes initPageElements()
     */
    public BaseAction() {
        initPageElements();
    }

    /**
     * This method handles wait functionality for mobile actions, which means if the element is not found
     * during test then the app will re-try and wait up to 15 seconds before failing the test step
     */
    protected void initPageElements() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverSD.getAppiumDriver(), 15, TimeUnit.SECONDS), this);
    }

    /**
     * This method is used to click on element
     *
     * @param mobileElement element to tap on
     */
    protected void clickOn(MobileElement mobileElement) {
        try {
            if (mobileElement.isEnabled()) {
                mobileElement.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to tap on element
     *
     * @param mobileElement element to tap on
     */
    protected void tapOn(MobileElement mobileElement) {
        TouchAction action = new TouchAction(AppiumDriverSD.getAppiumDriver());
        try {
            if (mobileElement.isEnabled()) {
                action.tap(mobileElement).perform();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }


    /**
     * This method is used to togle on or off
     *
     * @param mobileElement element to tap on
     */
    protected void togleOnOrOff(MobileElement mobileElement, int xValue, int yValue) {
        TouchAction action = new TouchAction(AppiumDriverSD.getAppiumDriver());
        try {
            if (mobileElement.isEnabled()) {
                Point point = mobileElement.getLocation();
                action.tap(point.x+xValue, point.y+yValue).perform();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }


    /**
     * This method is used to press on element
     *
     * @param mobileElement element to tap on
     */
    protected void press(MobileElement mobileElement) {
        TouchAction action = new TouchAction(AppiumDriverSD.getAppiumDriver());
        try {
            if (mobileElement.isEnabled()) {
                action.press(mobileElement).waitAction(Duration.ofSeconds(3)).release().perform();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to press and move to an element
     *
     * @param mobileElementOne element to press on
     * @param mobileElementTwo element to move to
     */
    protected void pressAndMoveTo(MobileElement mobileElementOne, MobileElement mobileElementTwo) {
        TouchAction action = new TouchAction(AppiumDriverSD.getAppiumDriver());
        try {
            if (mobileElementOne.isEnabled() && mobileElementTwo.isEnabled()) {
                action.press(mobileElementOne).waitAction(Duration.ofSeconds(2)).moveTo(mobileElementTwo).release().perform();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            if (!mobileElementOne.isEnabled()) {
                throw new NoSuchElementException("Unable to locate the Element using: " + mobileElementOne.toString());
            }else
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElementTwo.toString());
        }
    }

    /**
     * This method is used to drag and drop an element
     *
     * @param mobileElementOne element to press on
     * @param mobileElementTwo element to move to
     */
    protected void dragAdnDrop(MobileElement mobileElementOne, MobileElement mobileElementTwo) {
        TouchAction action = new TouchAction(AppiumDriverSD.getAppiumDriver());
        try {
            if (mobileElementOne.isEnabled() && mobileElementTwo.isEnabled()) {
                action.longPress(mobileElementOne).moveTo(mobileElementTwo).release().perform();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            if (!mobileElementOne.isEnabled()) {
                throw new NoSuchElementException("Unable to locate the Element using: " + mobileElementOne.toString());
            }else
                throw new NoSuchElementException("Unable to locate the Element using: " + mobileElementTwo.toString());
        }
    }


    /**
     * This method is used to set value in text field
     *
     * @param mobileElement
     * @param setValue
     */
    protected void setValue(MobileElement mobileElement, String setValue) {

        try{
            mobileElement.sendKeys(setValue);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }


    /**
     * This method is used to set value in text field
     *
     * @param mobileElement
     */
    public String getTextFromElement(MobileElement mobileElement){
        try{
            return mobileElement.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     *This method is to Scroll using TouchActions
     *
     * @param fromElement
     * @param toElement
     */
    public void scrollUsingActionsClass(MobileElement fromElement, MobileElement toElement){
        // 4. Scroll using TouchActions
        TouchAction tAction=new TouchAction(AppiumDriverSD.getAppiumDriver());
        tAction.press(fromElement)
                .moveTo(toElement)
                .release()
                .perform();
    }

    /**
     * This method is used to check if an element is displayed on the screen
     *
     * @param mobileElement element to tap on
     */
    protected boolean isDisplayed(MobileElement mobileElement) {
        try {
            if (mobileElement.isDisplayed()) {
                return true;
            }else {
                return false;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }


//fkuentWait method for Android(needs modification as selenium project)

//    public static WebElement visibilityWaitOfElement(
//            AndroidDriver<AndroidElement> driver,
//            int timeoutInSeconds, WebElement element) {
//        return new FluentWait<>(driver).
//                withTimeout(timeoutInSeconds, TimeUnit.SECONDS).
//                pollingEvery(500, TimeUnit.MILLISECONDS).
//                ignoring(NotFoundException.class).ignoring(NoSuchElementException.class).
//                until(ExpectedConditions.visibilityOf(element));
//    }
//
//...
//    after    Views).click();
//    visibilityWaitOfElement(driver, 15, driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']"));
//driver.pressKeyCode(AndroidKeyCode.BACK);

}
