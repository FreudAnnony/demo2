package Keyword;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.time.Duration;
import org.junit.Assert;

public class Action {
    WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public static void waitForPageLoad(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Set timeout to 30 seconds
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait for the page to load completely
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        });
    }

    public void fillInForm(WebElement element, String data){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Optionally wait for a brief moment after scrolling
        try {
            Thread.sleep(500);
            Assert.assertTrue("Input element is displayed! ", element.isDisplayed());
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        element.sendKeys(data);

        try{

            String enteredText = element.getAttribute("value");

            if (enteredText.equals(data)) {
                System.out.println("Data successfully entered into the field: " + data);
            } else {
                System.out.println("Failed to input data");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println("This step has passed");
    }
}
