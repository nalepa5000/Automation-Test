package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    WebDriver driver;
    Helper helper;
    Actions actions;

    @FindBy(xpath = "//nav[@id='main-nav']/div/ul/li[6]")
    WebElement interactionMenu;

    public RegistrationPage(WebDriver driver){
        this.driver = new ChromeDriver();
        this.helper = new Helper(driver);
        this.actions = new Actions(driver);
    }

    public void openWidget(int x){
        actions.moveToElement(interactionMenu).build().perform();
        helper.fluentWaitForElement(interactionMenu);
        actions.click(interactionMenu).build().perform();
    }
}
