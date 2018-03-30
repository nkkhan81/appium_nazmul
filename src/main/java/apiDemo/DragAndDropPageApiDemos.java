package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created by nkkhan on 3/8/18.
 */
public class DragAndDropPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     * if you have any special character($,#,% etc) in tagname, you cannot use that for xpath. but you can skip that by using *
     * uiAutomator Syntax: ("attribute(\"value\")")
     * to validate element property using UiAutomator -  ("new UiSelector().property(value)";
     */


    @AndroidFindBy(className = "android.view.View")
    private List<MobileElement> dots;



    public void dragAndDrop(){
        MobileElement firstDot = dots.get(0);
        MobileElement secondDot = dots.get(1);

        dragAdnDrop(firstDot,secondDot);
    }
}
