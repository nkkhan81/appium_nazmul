package stepDefinition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSD {

    /**
     * Singleton design pattern to have only 1 appium driver object
     */
    private static AppiumDriver appiumDriver;

    /**
     * This method initializes the appium driver object on default mobile device specified in the config file
     *
     * @throws MalformedURLException
     */
    private static void intializeAppiumDriver() throws MalformedURLException {
        appiumDriver = buildAppiumDriver();

        // This is used in cases where fluent wait is not applied (fluentWait() at BaseWebPage class)
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static AppiumDriver buildAppiumDriver() {
        AppiumDriver appiumDriver = null;
        String appiumServerURL = "http://0.0.0.0:4723/wd/hub";

        String platformName = "android";
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        File f = new File("src/main/resources");
//        File file = new File(f,"ApiDemos-debug.apk");
        File apiDemos = new File("src/test/resources/ApiDemos-debug.apk");
        File hotels = new File("src/test/resources/hotels.apk");
        File raaga = new File("src/test/resources/hotels.apk");

        //capabilities for genymotion simulator
        /*capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S7");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/nkkhan/Projects/technoSoft/apps_dump/base.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);*/


        //capabilities for avd nexas5 simulator
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//        capabilities.setCapability(MobileCapabilityType.APP, apiDemos.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP, hotels.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.APP, raaga.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);

        //cpabilities for real android device
       /* capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
        capabilities.setCapability("appPackage","net.one97.paytm");
        capabilities.setCapability("appActivity","net.one97.paytm.landingpage.activity.AJRMainActivity");*/

        try {
            appiumDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return appiumDriver;
    }

    /**
     * This method is used to quit the Appium driver if it is not null
     */
    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            System.out.println("Quitting Appium..");
            appiumDriver.quit();
            System.out.println("Quitting Appium - Done");
            appiumDriver = null;
        }
    }

    /**
     * This will start an Appium server and return an Appium driver (or initialize it if it's not initialized)
     * Only 1 driver and server will be started/initialized per run
     *
     * @return Appium driver
     */
    public static AppiumDriver getAppiumDriver() {
        if (appiumDriver == null) {
            try {
                // Initialize the appium server the first time the driver is created

                // the start appium server may be called mulitple times, since only 1 instance is created
                intializeAppiumDriver();
            } catch (MalformedURLException e) {
                Assert.fail("Unable to initialize Appium driver due to invalid Server URL or there server is already in use");

            }
        }

        return appiumDriver;
    }
}
