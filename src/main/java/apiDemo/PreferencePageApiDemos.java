package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by nkkhan on 3/8/18.
 */
public class PreferencePageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     */

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
    private MobileElement dependencies;

    public void tapOnDependencies() {
        clickOn(dependencies);
    }
}
