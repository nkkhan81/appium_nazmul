package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by nkkhan on 3/8/18.
 */
public class LandingPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator, accessesibility
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     * uiAutomator Syntax: ("attribute("value")")
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    private MobileElement preference;

    @AndroidFindBy(uiAutomator = ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));"))
    private MobileElement views;

    public void tapOnPreferencen() {
        clickOn(preference);
    }
    public void tapOnViews() {

        clickOn(views);
    }
}
