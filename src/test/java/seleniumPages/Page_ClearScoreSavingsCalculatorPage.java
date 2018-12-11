package seleniumPages;

import common.constants;
import common.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The class Page_ClearScoreSavingsCalculatorPage contains all the Selenium methods that are required to run for the ClearScore Savings Calculator.
 * The aforementioned tests can be found in the file clearScoreSavingsCalculator.feature.
 */
public class Page_ClearScoreSavingsCalculatorPage extends basePage {

    public void openClearScoreSavingsCalculatorURL() {
        driver.get(constants.SAVINGS_CALCULATOR_URL);
    }

    /**
     * clearScoreCurrentScoreSlider is used to set the users value on the current score slider.
     *
     * This is done in two steps:
     *      First finding the current slider by class and then performing a moveToElement action combined with a click to effectively set their score to 0 using the cursor.
     *      Next a while loop is used to perform arrow key presses until the score reaches the desired value.
     *
     * @param currentScore The users current score that they set on the current score slider.
     */
    public void clearScoreCurrentScoreSlider(int currentScore){

        WebElement currentScoreSlider = driver.findElement(By.className(constants.CURRENT_SLIDER));

        Actions moveCurrentSlider = new Actions(driver);
        moveCurrentSlider.moveToElement(currentScoreSlider,0,0).click();
        moveCurrentSlider.build().perform();

        int count = 0;
        while(count < currentScore) {
            currentScoreSlider.sendKeys(Keys.ARROW_RIGHT);
            count++;
        }
    }

    /**
     * clearScoreGoalScoreSlider is used to set the users value on the goal score slider.
     *
     * This is done in multiple steps:
     *      First finding the goal slider by class and then extracting its width
     *      Next by using the width value a moveToElement action is performed, combined with a click to effectively set their score to 700 using the cursor.
     *      Next a while loop is used to perform arrow key presses until the score reaches the desired value.
     *
     * @param goalScore The users current score that they set on the current score slider.
     */
    public void clearScoreGoalScoreSlider(int goalScore){
        WebElement GoalScoreSlider = driver.findElement(By.className(constants.GOAL_SLIDER));
        int width = GoalScoreSlider.getSize().getWidth();

        Actions moveGoalSlider = new Actions(driver);
        moveGoalSlider.moveToElement(GoalScoreSlider,width,0).click();
        moveGoalSlider.build().perform();

        int count = 700;
        while(count > goalScore) {
            GoalScoreSlider.sendKeys(Keys.ARROW_LEFT);
            count--;
        }
    }

    public String savingsCalculatorResults(String VALUE) {
        WebElement calculatorResults = driver.findElement(By.className(VALUE));
        return calculatorResults.getText();
    }
}
