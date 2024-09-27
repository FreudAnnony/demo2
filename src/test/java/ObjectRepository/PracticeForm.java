package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeForm {

    WebDriver driver;

    // Constructor to initialize WebDriver
    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    // WebElement for first name field
    public WebElement getFirstNameInput() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastNameInput() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getGenderInput(String gender){
        String xpath = "//input[@value = '" + gender + "']//following-sibling::label";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getMobileInput(){
        return driver.findElement(By.id("userNumber"));
    }

    public WebElement getDateOfBirthInput(){
        return driver.findElement(By.id("dateOfBirthInput"));
    }

    public WebElement getSelectDate(String selectDate){
        String xpath = "//div[@aria-label='" + selectDate + "']";
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement getSubjectsInput(){
        return driver.findElement(By.id("subjectsInput"));
    }

    public WebElement getHobbiesInput(){
        return driver.findElement(By.id("react-select-2-option-0"));
    }

    public WebElement getCurrentAddress(){
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getSelectStateInput(String state){
        return driver.findElement(By.id("selectState"));
    }

    public WebElement getSelectCityInput(String city){
        return driver.findElement(By.id("selectCity"));
    }

    public WebElement getSubmitButton(){
        return driver.findElement(By.xpath("//button[@id = 'submit']"));
    }

    public WebElement getThankSubmittingForm(){
        return driver.findElement(By.xpath("" +
                "//div[contains(text(),'Thanks for submitting the form')]"));
    }

    public WebElement getCloseButton(){
        return driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
    }
}
