package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;
    Helper helper;
    Actions actions;

    @FindBy(xpath = "//nav[@id='main-nav']/div/ul/li[6]")
    WebElement interactionMenu;

    @FindBy(xpath = "//p[@class='text_popup']/a[contains(text(),'Signin')]")
    WebElement signInButton1;

    @FindBy(xpath = "//div[@id='login']/form/fieldset[1]/input")
    WebElement userNameInput;

    @FindBy(xpath = "//div[@id='login']/form/fieldset[2]/input")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@id='login']/form//input[@class='button']")
    WebElement signInButton2;

    @FindBy(xpath = "//fieldset[1]/p[1]/input")
    WebElement nameInput;

    @FindBy(xpath = "//fieldset[1]/p[2]/input")
    WebElement surnameInput;

    @FindBy(xpath = "//fieldset[1]/")

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.helper = new Helper(driver);
        this.actions = new Actions(driver);
    }

    public RegistrationPage logIn() throws InterruptedException {
        helper.fluentWaitForElement(signInButton1);
        signInButton1.click();
        helper.fluentWaitForElement(userNameInput);
        userNameInput.sendKeys("knalepa");
        passwordInput.sendKeys("Darnok321.");
        signInButton2.click();
        Thread.sleep(3000);
        return this;
    }

    public void openWidget(int x){
        actions.moveToElement(interactionMenu).build().perform();
        helper.fluentWaitForElement(interactionMenu);
        actions.click(interactionMenu).build().perform();
    }

    public RegistrationPage sendName(String name){
        nameInput.sendKeys(name);
        return this;
    }

    public RegistrationPage sendSurname(String surname){
        surnameInput.sendKeys(surname);
        return this;
    }


}
