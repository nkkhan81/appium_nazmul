package apiDemo;

import base.BaseAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Created by nkkhan on 3/8/18.
 */
public class DependenciesPageApiDemos extends BaseAction {
    /**
     * In Appium we mostly depend on the locator By: id, xpath, class name, androidUIautomator
     * others are still work but not consistent as above.
     * syntax of xpath is same as selenium
     * in appium tagName is usually the value of className
     */

    @AndroidFindBy(id = "android:id/checkbox")
    private MobileElement wifiCheckbox;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    private MobileElement wifiSettings;

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement insertIntoTextField;

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> buttons;

    public void tapOnWifiCheckbox() {
        clickOn(wifiCheckbox);
    }

    public void tapOnWifiSettings() {
        clickOn(wifiSettings);
    }

    public void insertText(String value) {
        setValue(insertIntoTextField, value);
    }

    public void tapOkButton() {
        MobileElement okButton = buttons.get(1);
        clickOn(okButton);
    }
}
