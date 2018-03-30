package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created by nkkhan on 3/8/18.
 */
public class ViewsPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     * uiAutomator Syntax: ("attribute("value")")
     */
//    final String CLICKABLE_PROPERTY = "new UiSelector()..enabled(true)";
    @AndroidFindBy(uiAutomator = ("new UiSelector().clickable(true)"))
    private List<MobileElement> elementsWitClickProperties;

    @AndroidFindBy(uiAutomator = ("new UiSelector().enabled(true)"))
    private List<MobileElement> elementsWithEnabledProperties;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
    private MobileElement expandableList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Date Widgets']")
    private MobileElement dateWidgets;

    @AndroidFindBy(uiAutomator = ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"))
    private MobileElement webView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visibility']")
    private MobileElement visibility;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    private MobileElement dragAndDrop;

    @AndroidFindBy(uiAutomator = ("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"));"))
    private MobileElement switches;



    public void checkClickableProperties() {
        int clickableElements = elementsWitClickProperties.size();
        System.out.println("Number of clickable element = "+clickableElements);
    }

    public void checkEnabledProperties() {
        int enableElements = elementsWithEnabledProperties.size();
        System.out.println("Number of enabled element = "+enableElements);
    }

    public void tapOnExpandableList(){
        tapOn(expandableList);
    }

    public void tapOnDateWidgets(){
        tapOn(dateWidgets);
    }

    public void scrollAndClickOnVisibilities(){
//        MobileElement element = webView;
        clickOn(webView);
    }

    public void tapOnDragAndDrop(){
        tapOn(dragAndDrop);
    }

    public void tapOnSwitches(){
        tapOn(switches);
    }
}
