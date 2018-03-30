package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created by nkkhan on 3/8/18.
 */
public class SwitchesPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     * if you have any special character($,#,% etc) in tagname, you cannot use that for xpath. but you can skip that by using *
     * uiAutomator Syntax: ("attribute(\"value\")")
     * to validate element property using UiAutomator -  ("new UiSelector().property(value)";
     */


    @AndroidFindBy(className = "android.widget.Switch")
    private List<MobileElement> switches;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='Switch with match_parent width OFF']")
    private MobileElement match_parentWidth;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='OFF']")
    private MobileElement standAloneSwitch;

    @AndroidFindBy(uiAutomator = ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Standalone switch below:\"));"))
    private MobileElement standAloneForScroolDown;

    @AndroidFindBy(uiAutomator = ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Standard switch OFF\"));"))
    private MobileElement StandardSwitchForScrollUp;





    public void turnOnSwitches(){
        MobileElement standardSwitch0 = switches.get(0);
//        MobileElement defaultIsOn1 = switches.get(1);
        MobileElement monitoredSwitch2 = switches.get(2);
        MobileElement customizedText3 = switches.get(3);
        MobileElement switchAllignedTop4 = switches.get(4);
        MobileElement switchAllignedCenter5 = switches.get(5);
        MobileElement switchAllignedBottom6 = switches.get(6);

        togleOnOrOff(standardSwitch0,160,5);
        togleOnOrOff(monitoredSwitch2,165,5);
        togleOnOrOff(customizedText3,160,5);
        togleOnOrOff(switchAllignedTop4,340,100);
        togleOnOrOff(switchAllignedCenter5,340,50);
        togleOnOrOff(switchAllignedBottom6,340,5);

        getTextFromElement(standAloneForScroolDown);

        togleOnOrOff(match_parentWidth,450,5);
        togleOnOrOff(standAloneSwitch,10,10);

    }

}
