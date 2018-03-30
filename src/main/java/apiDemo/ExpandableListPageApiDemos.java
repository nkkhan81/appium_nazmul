package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by nkkhan on 3/8/18.
 */
public class ExpandableListPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     * uiAutomator Syntax: ("attribute(\"value\")")
     * to validate element property using UiAutomator -  ("new UiSelector().property(value)";
     */


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1. Custom Adapter']")
    private MobileElement customAdapter;


    public void tapOnCustomAdapter(){
        tapOn(customAdapter);
    }
}
