import Keyword.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ObjectRepository.*;


public class TC_SubmitStudentRegistrationFormWithoutMobileNumber {

    static WebDriver driver = new ChromeDriver();

    static GenerateData generateData = new GenerateData();

    static PracticeForm formPage = new PracticeForm(driver);

    static Action action = new Action(driver);

    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver.get("https://demoqa.com/automation-practice-form");

        try{
            action.waitForPageLoad(driver);

            //Step 1 - I fill in my first name in First Name field
            action.fillInForm(formPage.getFirstNameInput(), generateData.firstName());

            //Step 2 - I fill in my first name in Last Name field
            action.fillInForm(formPage.getLastNameInput(), generateData.lastName());

            //Step 3 - I fill in my email in Email field
            action.fillInForm(formPage.getEmailInput(), "hello@gmail.com");

            //Step 4 - I choose my gender
            formPage.getGenderInput("Male").click();

            //Step 5 - Fill in my Subjects
            formPage.getSubjectsInput().click();
            action.fillInForm(formPage.getSubjectsInput(), "Math");
            formPage.getSubjectsInput().sendKeys("\n");

            //Step 6 - I input my address
            action.fillInForm(formPage.getCurrentAddress(), "123 Abc");

            //Step 7 - I click in Submit button
            js.executeScript("arguments[0].scrollIntoView(true);", formPage.getSubmitButton());
            formPage.getSubmitButton().click();

            //Step 8 - Check for validation or error related to Mobile field
            String mobileErrorMessage = formPage.getMobileInput().getAttribute("validationMessage");

            if (mobileErrorMessage != null && !mobileErrorMessage.isEmpty()) {
                System.out.println("Error message displayed for Mobile field: " + mobileErrorMessage);
            } else {
                System.out.println("No validation error found for Mobile field. Check if the form was submitted.");
            }

            // Sleep to observe the behavior
            Thread.sleep(2000);
            System.out.println("This happy test case is passed");


        } catch (Exception e) {

            System.out.println("Test failed: " + e.getMessage());
        } finally {
            if(driver != null) {
                driver.quit();
            }
        };
    }
}
