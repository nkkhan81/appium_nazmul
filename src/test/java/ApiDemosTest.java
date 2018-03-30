import apiDemo.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepDefinition.AppiumDriverSD;

/**
 * Created by nkkhan on 3/8/18.
 */
public class ApiDemosTest {
    /**
     * Purpose: demonstration of tapping and inserting test by different element
     *      using - id, class name, xpath, UiAutomator etc
     * Given I am on Landing Screen
     * When I tap on preference on landing screen
     * And tap on preference dependencies on Preference page
     * And I select wifi checkbox on preference dependencies page
     * And I tap on wifi settings on preference dependencies page
     * And I insert wifi name into text field on preference dependencies page
     * Then I press ok button on preference dependencies page
     */
    @Test
    public void verifiWifiDependency(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        PreferencePageApiDemos preference = new PreferencePageApiDemos();
        DependenciesPageApiDemos dependencies = new DependenciesPageApiDemos();

        landingPage.tapOnPreferencen();
        preference.tapOnDependencies();
        dependencies.tapOnWifiCheckbox();
        dependencies.tapOnWifiSettings();
        dependencies.insertText("hello");
        dependencies.tapOkButton();
    }


    /**
     * Purpose: verify object properties using UiAutomator
     * Given I am on Landing Screen
     * When I tap on Views on landing screen
     * Then I verify clickable features for all options is >= 11
     * And verify enable features for all options is >=18
     */
    @Test
    public void verifiWifiSettings(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();

        landingPage.tapOnViews();
        views.checkClickableProperties();
        views.checkEnabledProperties();

    }

    /**
     * Purpose: perform long press gestures handling popup
     * Given I am on Landing Screen
     * When I tap on Views on landing screen
     * And I click on Expandable List on views page
     * And I click on Customer Adapter on ExpandableList page
     * And I long press on People Names option on Customer Adapter Page
     * Then I verify text from popup message
     */
    @Test
    public void verifyLongPressElement(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();
        ExpandableListPageApiDemos expandableList = new ExpandableListPageApiDemos();
        CustomAdapterPageApiDemos customAdapter = new CustomAdapterPageApiDemos();

        landingPage.tapOnViews();
        views.tapOnExpandableList();
        expandableList.tapOnCustomAdapter();
        customAdapter.longPressOnpeoplesNames();
        String text = customAdapter.getTextFromSampleMenu();
        System.out.println(text);
        Assert.assertEquals(text,"Sample menu");
    }

    /**
     * Purpose: perform swipe gesture in android apps
     * Given I am on Landing Screen
     * When I tap on Views on landing screen
     * And I click on Date Widgets on views page
     * And I click on Inline on dateWidgets page
     * I click on 9
     * Then I press and hold on 9 and move it to 45 (swipe)
     */
    @Test
    public void verifySwipe(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();
        DateWidgetsPageApiDemos dateWidgets = new DateWidgetsPageApiDemos();

        landingPage.tapOnViews();
        views.tapOnDateWidgets();
        dateWidgets.tapOnInline();
        dateWidgets.clickOnNine();
        dateWidgets.moveToFortyFive();
    }

    /**
     * Purpose: perform scroll down in android apps
     * Given I am on Landing Screen
     * When I tap on Views on landing screen
     * And I scroll down all the way until you see WebView option
     * Then click on WebView
     */
    @Test
    public void scrollDownAndClick(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();

        landingPage.tapOnViews();
        views.scrollAndClickOnVisibilities();
    }

    /**
     * Purpose: perform drag and drop in android apps
     * Given I am on Landing Screen
     * When I tap on Views on landing screen
     * And I tap on Drag and Drop on Views page
     * Then I drug a dot and drop to another dot
     */
    @Test
    public void dragAndDrop(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();
        DragAndDropPageApiDemos dragAndDrop = new DragAndDropPageApiDemos();

        landingPage.tapOnViews();
        views.tapOnDragAndDrop();
        dragAndDrop.dragAndDrop();
    }

    /**
     * Purpose: perform different driver action
     * Given I am on Landing Screen
     * When I print the current activity of landing screen
     * And print the context of the apps
     * And I print the orientation mode
     * And I print whether the app is locked or not (true/false)
     * And I tap on Views on landing screen
     * Then I come back to Landing Screen
     */
    @Test
    public void driverAction(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();

        String activity = ((AndroidDriver<MobileElement>) AppiumDriverSD.getAppiumDriver()).currentActivity();
        System.out.println(activity);

        System.out.println(AppiumDriverSD.getAppiumDriver().getContext());

        System.out.println(AppiumDriverSD.getAppiumDriver().getOrientation());

        System.out.println(((AndroidDriver<MobileElement>) AppiumDriverSD.getAppiumDriver()).isLocked());

        landingPage.tapOnViews();
        ((AndroidDriver<MobileElement>) AppiumDriverSD.getAppiumDriver()).pressKeyCode(AndroidKeyCode.BACK);
        ((AndroidDriver<MobileElement>) AppiumDriverSD.getAppiumDriver()).pressKeyCode(AndroidKeyCode.BACK);

        ((AndroidDriver<MobileElement>) AppiumDriverSD.getAppiumDriver()).pressKeyCode(187);

    }


    /**
     * Purpose: perform switch on/off action
     * Given I am on Landing Screen
     * When I tap on Views on Landing Page
     * And I tap on Switches on Views page
     * And I turned on all switches except 'Default is on'
     * Then I Turned off all switches
     */
    @Test
    public void switchDemo(){
        LandingPageApiDemos landingPage = new LandingPageApiDemos();
        ViewsPageApiDemos views = new ViewsPageApiDemos();
        SwitchesPageApiDemos switches = new SwitchesPageApiDemos();

        landingPage.tapOnViews();
        views.tapOnSwitches();
        switches.turnOnSwitches();
//        ((AndroidDriver<MobileElement>) AppiumWrapper.getAppiumDriver()).pressKeyCode(AndroidKeyCode.BACK);
//        views.tapOnSwitches();
//        switches.turnOnSwitches();

    }
}
