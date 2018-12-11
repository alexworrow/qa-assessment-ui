package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import seleniumPages.Page_ClearScoreHomepage;

/**
 * The class clearScoreCookiesStepDefinition contains all the step definitions for the tests required to run for the cookie Notification and the accepting and checking of the ClearScore cookie.
 * The aforementioned tests can be found in the file clearScoreCookie.feature.
 *
 * Where required assertions are used in the steps to define if the step should pass or fail with either an assertTrue or assertEquals.
 * No Selenium Webdriver methods are present within the sep definitions. Instead all Selenium methods are utilised in the seleniumPages package.
 * The stepDefinitions then use the relevant class to utilise the selenium method the test needs.
 *
 * The aspects of the tests for these steps using the selenium methods can be found in Page_ClearScoreHomepage.
 */
public class clearScoreCookiesStepDefinition {

    Page_ClearScoreHomepage clearScoreHomepage = new Page_ClearScoreHomepage();

    @When("^I navigate to the ClearScore homepage$")
    public void i_navigate_to_the_ClearScore_homepage() {
        clearScoreHomepage.openClearScoreHomeURL();
    }

    @Then("^the cookie notification is displayed to the user$")
    public void the_cookie_notification_is_displayed_to_the_user() {
        Assert.assertTrue(clearScoreHomepage.isCookieNotificationDisplayed());
    }
    @Given("^I am on the ClearScore homepage$")
    public void i_am_on_the_ClearScore_homepage() {
        clearScoreHomepage.openClearScoreHomeURL();
    }

    @Given("^the cookie notification is present$")
    public void the_cookie_notification_is_present() {
        Assert.assertTrue(clearScoreHomepage.isCookieNotificationDisplayed());
    }

    @When("^I dismiss the cookie notification$")
    public void i_dismiss_the_cookie_notification() {
        clearScoreHomepage.closeCookieNotification();
    }

    @Then("^the cookie notification will be removed$")
    public void the_cookie_notification_will_be_removed() {
        Assert.assertFalse(clearScoreHomepage.isCookieNotificationDisplayed());
    }

    @Then("^the ClearScore cookies will be applied to the browser$")
    public void the_ClearScore_cookies_will_be_applied_to_the_browser() {
        Assert.assertEquals("true",clearScoreHomepage.isCookieApplied());
    }

    @Given("^the ClearScore cookie has not been set$")
    public void the_ClearScore_cookie_has_not_been_set() {
        Assert.assertEquals("false",clearScoreHomepage.isCookieApplied());
    }

    @When("^I refresh the page$")
    public void i_refresh_the_page() {
        clearScoreHomepage.refreshClearScoreHomePage();
    }

    @Then("^the cookie notification will not be present on the page$")
    public void the_cookie_notification_will_not_be_present_on_the_page() {
        Assert.assertFalse(clearScoreHomepage.isCookieNotificationDisplayed());
    }

    @When("^I navigate to the ClearScore about us page$")
    public void I_navigate_to_the_ClearScore_about_us_page() {
        clearScoreHomepage.openClearScoreAboutUsPage();
    }
}
