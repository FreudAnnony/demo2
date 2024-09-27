import Keyword.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ObjectRepository.*;

public class TC_SubmitStudentRegistrationFormSuccessfully {

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

            //Step 5- I fill in mobile phone in Mobile field
            action.fillInForm(formPage.getMobileInput(), generateData.phoneNumber("09"));

            //Step 6 - Fill in my Subjects
            formPage.getSubjectsInput().click();
            action.fillInForm(formPage.getSubjectsInput(), "Math");

            //Step 7 - I input my address
            action.fillInForm(formPage.getCurrentAddress(), "123 Abc");

            //Step 8 - I click in Submit button
            js.executeScript("arguments[0].scrollIntoView(true);", formPage.getSubmitButton());
            formPage.getSubmitButton().click();

            //Step 9 - Verify that Thank Submitting form is pops up after submit is completed
            try{
                Thread.sleep(2000);
                Assert.assertTrue("Input element is displayed! ", formPage.getThankSubmittingForm().isDisplayed());
            }catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

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