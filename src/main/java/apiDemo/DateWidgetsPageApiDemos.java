package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by nkkhan on 3/8/18.
 */
public class DateWidgetsPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     * if you have any special character($,#,% etc) in tagname, you cannot use that for xpath. but you can skip that by using *
     * uiAutomator Syntax: ("attribute(\"value\")")
     * to validate element property using UiAutomator -  ("new UiSelector().property(value)";
     */


    @AndroidFindBy(uiAutomator = "text(\"2. Inline\")")
    private MobileElement inline;

    @AndroidFindBy(xpath = "//*[@content-desc='9']")
    private MobileElement nine;

    @AndroidFindBy(xpath = "//*[@content-desc='15']")
    private MobileElement fifteen;

    @AndroidFindBy(xpath = "//*[@content-desc='45']")
    private MobileElement fortyFive;


    public void tapOnInline(){
        tapOn(inline);
    }

    public void clickOnNine(){
        clickOn(nine);
    }

    public void moveToFortyFive(){
        pressAndMoveTo(fifteen,fortyFive);
    }
}
