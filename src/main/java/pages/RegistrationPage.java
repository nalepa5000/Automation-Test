package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.util.List;

public class RegistrationPage {

    WebDriver driver;
    Select daySelect, monthSelect, yearSelect, countrySelect;

    @FindBys({
            @FindBy(tagName = "fieldset"),
            @FindBy(tagName = "input")
    })
    List<WebElement> inputs;

    @FindBy(xpath = "//fieldset[10]/textarea")
    WebElement textArea;

    @FindBy(xpath = "//fieldset[9]/input")
    WebElement imageUploadButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage setName(String name) {
        inputs.get(0).sendKeys(name);
        return this;
    }

    public RegistrationPage setSurname(String surname) {
        inputs.get(1).sendKeys(surname);
        return this;
    }

    public RegistrationPage setMaterialStatus(int status) {
                if (1 < status && status < 5) {
            inputs.get(status).click();
        } else System.out.println("Chose status \n 2 - Married \n 3 - Single \n 4 - Divorced");
        return this;
    }

    public RegistrationPage selectCountry(int country){
        countrySelect = new Select(driver.findElement(By.tagName("select")));
        countrySelect.selectByIndex(country);
        return this;
    }

    public RegistrationPage selectDay(int day){
        daySelect = new Select(driver.findElement(By.xpath("//fieldset[5]/div[2]/select")));
        daySelect.selectByIndex(day);
        return this;
    }

    public RegistrationPage selectMonth(int month){
        monthSelect = new Select(driver.findElement(By.xpath("//fieldset[5]/div[1]/select")));
        monthSelect.selectByIndex(month);
        return this;
    }

    public RegistrationPage selectYear(int year){
        yearSelect = new Select(driver.findElement(By.xpath("//fieldset[5]/div[3]/select")));
        yearSelect.selectByIndex(year);
        return this;
    }

    public RegistrationPage setHobbys(int hobby) {
        if (4 < hobby && hobby < 8) {
            inputs.get(hobby).click();
        } else System.out.println("Chose status \n 5 - Dance \n 6 - Reading \n 7 - Cricket");
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        inputs.get(8).sendKeys(phoneNumber);
        return this;
    }

    public RegistrationPage setUserName(String userName) {
        inputs.get(9).sendKeys(userName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        inputs.get(10).sendKeys(email);
        return this;
    }

    public RegistrationPage setAboutYourself(String aboutYourself) {
        textArea.sendKeys(aboutYourself);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        inputs.get(12).sendKeys(password);
        return this;
    }

    public RegistrationPage confirmPassword(String password) {
        inputs.get(13).sendKeys(password);
        return this;
    }

    public RegistrationPage uploadProfilePicture(){
        String path = new File("src/test/resources/doggo.jpg").getAbsolutePath();
        imageUploadButton.sendKeys(path);
        return this;
    }

    public RegistrationPage submit(){
        helper.takeScreenshot();
        inputs.get(14).click();
        return this;
    }
}
