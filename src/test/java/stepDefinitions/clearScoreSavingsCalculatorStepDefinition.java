package stepDefinitions;

import common.constants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import seleniumPages.Page_ClearScoreSavingsCalculatorPage;

/**
 * The class clearScoreSavingsCalculatorStepDefinition contains all the step definitions for the tests required to run for the ClearScore Savings Calculator.
 * The aforementioned tests can be found in the file clearScoreCalculator.feature.
 *
 * Where required assertions are used in the steps to define if the step should pass or fail with an assertEquals.
 * For the assertions the value are taken from the Scenarios and feed into the assertions where they are compared against the result returned from the browser.
 *
 * No Selenium Webdriver methods are present within the sep definitions. Instead all Selenium methods are utilised in the seleniumPages package.
 * The stepDefinitions then use the relevant class to utilise the selenium method the test needs.
 *
 * The aspects of the tests for these steps using the selenium methods can be found in Page_ClearScoreSavingsCalculatorPage.
 */
public class clearScoreSavingsCalculatorStepDefinition {

    Page_ClearScoreSavingsCalculatorPage clearScoreSavingsCalculatorPage = new Page_ClearScoreSavingsCalculatorPage();

    @Given("^I am on the ClearScore savings calculator page$")
    public void i_am_on_the_ClearScore_savings_calculator_page() {
        clearScoreSavingsCalculatorPage.openClearScoreSavingsCalculatorURL();
    }

    @When("^I set my current score to (\\d+)$")
    public void i_set_my_current_score_to(int currentScore) {
       clearScoreSavingsCalculatorPage.clearScoreCurrentScoreSlider(currentScore);
    }

    @When("^I set my score goal to (\\d+)$")
    public void i_set_my_score_goal_to(int goalScore) {
        clearScoreSavingsCalculatorPage.clearScoreGoalScoreSlider(goalScore);
    }

    @Then("^my current average interest rate will be (\\d+)\\.(\\d+)%$")
    public void my_current_average_interest_rate_will_be(int arg1, int arg2) {
        Assert.assertEquals(arg1 +"."+ arg2 + "%",clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.CURRENT_AVERAGE_INTEREST));
    }

    @Then("^my current annual cost will be £(\\d+)$")
    public void my_current_annual_cost_will_be_£(int arg1) {
        Assert.assertEquals("£" + arg1,clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.CURRENT_ANNUAL_COST));
    }

    @Then("^my current Credit cards available will be (\\d+)$")
    public void my_current_Credit_cards_available_will_be(String arg1) {
        Assert.assertEquals(arg1,clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.CURRENT_AVAILABLE_CARDS));
    }

    @Then("^my goal average interest rate will be (\\d+)%$")
    public void my_goal_average_interest_rate_will_be(int arg1) {
        Assert.assertEquals(arg1 + "%",clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.GOAL_AVERAGE_INTEREST));
    }

    @Then("^my goal annual cost will be £(\\d+)$")
    public void my_goal_annual_cost_will_be_£(int arg1) {
        Assert.assertEquals("£" + arg1,clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.GOAL_ANNUAL_COST));
    }

    @Then("^my goal Credit cards available will be (\\d+)$")
    public void my_goal_Credit_cards_available_will_be(String arg1) {
        Assert.assertEquals(arg1,clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.GOAL_AVAILABLE_CARDS));
    }

    @Then("^my potential savings will be £(\\d+)$")
    public void my_potential_savings_will_be_£(String arg1) {
        Assert.assertEquals(arg1,clearScoreSavingsCalculatorPage.savingsCalculatorResults(constants.POTENTIAL_SAVINGS));
    }
}
