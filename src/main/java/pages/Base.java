package pages;

import helper.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base {

    protected WebDriver driver;
    protected Actions actions;
    protected Helper helper;
    protected JavascriptExecutor executor;

    @FindBy(xpath = "//nav[@id='main-nav']/div/ul")
    WebElement interactionMenu;

    @FindBy(className = "responsive-tabs")
    WebElement buttonsBar;

    @FindBy(xpath = "//p[@class='text_popup']/a[contains(text(),'Signin')]")
    WebElement signInButton1;

    @FindBy(xpath = "//div[@id='login']/form/fieldset[1]/input")
    WebElement userNameInput;

    @FindBy(xpath = "//div[@id='login']/form/fieldset[2]/input")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@id='login']/form//input[@class='button']")
    WebElement signInButton2;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.helper = new Helper(driver);
        this.actions = new Actions(driver);
        this.executor = (JavascriptExecutor) driver;
    }

    public void switchWidget(int widget) {
        actions.moveToElement(buttonsBar.findElement(By.xpath(".//li["+widget+"]"))).build().perform();
        buttonsBar.findElement(By.xpath(".//li["+widget+"]")).click();
        try {
            driver.switchTo().frame(widget - 1);
        }catch(NoSuchFrameException e) {
            System.out.println("No frames to switch");
        }
    }

    public void logIn() throws InterruptedException {
        helper.fluentWaitForElement(signInButton1);
        signInButton1.click();
        helper.fluentWaitForElement(userNameInput);
        userNameInput.sendKeys("knalepa");
        passwordInput.sendKeys("Darnok321.");
        signInButton2.click();
        Thread.sleep(3000);
    }

    public void openWidget(int widget){
        helper.fluentWaitForElement(interactionMenu.findElement(By.xpath("./li[" + widget + "]" )));
        actions.moveToElement(interactionMenu.findElement(By.xpath("./li[" + widget + "]" )))
                .click().build().perform();
    }

    public void openWidget(int widget, int postwidget){
        helper.fluentWaitForElement(interactionMenu.findElement(By.xpath("./li[" + widget + "]" )));
        actions.moveToElement(interactionMenu.findElement(By.xpath("./li[" + widget + "]" ))).build().perform();
        helper.fluentWaitForElement(interactionMenu.findElement(By.xpath("./li[" + widget + "]/ul/li[" + postwidget + "]" )));
        interactionMenu.findElement(By.xpath("./li[" + widget + "]/ul/li["+postwidget+"]" )).click();

    }

}
