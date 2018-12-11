package seleniumPages;

import common.constants;
import common.basePage;
import org.openqa.selenium.By;

/**
 * The class Page_ClearScoreHomepage contains all the Selenium methods that are required to run for the cookie Notification and the accepting and checking of the ClearScore cookie.
 * The aforementioned tests can be found in the file clearScoreCookie.feature.
 */
public class Page_ClearScoreHomepage extends basePage {

    public void openClearScoreHomeURL() {
        driver.get(constants.CLEARSCORE_HOMEPAGE);
    }

    public Boolean isCookieNotificationDisplayed() {
        return driver.findElement(By.className(constants.COOKIE_NOTIFICATION)).isDisplayed();
    }

    public void closeCookieNotification() {
        driver.findElement((By.className(constants.ACCEPT_COOKIE_BUTTON))).click();
    }

    /**
     * isCookieApplied is utilised by both the steps to confirm if the cookie is set or not.
     *
     * In the case that the cookie is not set the method returns a Null pointer exception.
     * However, as the test is actually confirming that the cookie isn't set before the notification is clicked I didn't want the test to result in a fail.
     *
     * To resolve this I've placed an Exception around the method so that the two conditions are handled:
     *      If the ClearScore cookie is present it retrieves the value applied to the cookie, which is "true".
     *      If the ClearScore cookie is not present then the exception is caught and handled and a string of "false" is returned.
     */
    public String isCookieApplied() {
        try {
            return driver.manage().getCookieNamed(constants.CLEARSCORE_COOKIE_NAME).getValue();
        } catch (Exception e) {
            return "false";
        }
    }

    public void refreshClearScoreHomePage() {
        driver.navigate().refresh();
    }

    public void openClearScoreAboutUsPage() {
        driver.get(constants.CLEARSCORE_ABOUT_US);
    }
}
