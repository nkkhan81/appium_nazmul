import base.BaseAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by nkkhan on 3/14/18.
 */
public class RealDeviceConnectionTest {
    @Test
    public void deviceTest(){
        BaseAction baseAction = new BaseAction();
    }

    @Test
    public void realDeviceTestWithDriver(){
        AppiumDriver appiumDriver = null;
        String appiumServerURL = "http://0.0.0.0:4723/wd/hub";

        String platformName = "android";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //cpabilities for real android device
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
        capabilities.setCapability("appPackage","net.one97.paytm");
        capabilities.setCapability("appActivity","net.one97.paytm.landingpage.activity.AJRMainActivity");

        try {
            appiumDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
