package pages.interactionPage;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InteractionBase {

    WebDriver driver;
    Actions actions;
    Helper helper;

    @FindBy(xpath = "//nav[@id='main-nav']/div/ul/li[2]")
    WebElement interactionMenu;

    @FindBy(id = "draggable")
    WebElement draggableElement1;

    @FindBy(id = "draggable2")
    WebElement draggableElement2;

    @FindBy(id = "draggable3")
    WebElement draggableElement3;

    @FindBy(id = "draggable5")
    WebElement draggableElement5;

    @FindBy(id = "droppable")
    WebElement droppableElement1;

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

    InteractionBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.helper = new Helper(driver);
    }

    void dragElementAndTakeScreenshot(WebElement element, int xOffset, int yOffset) {
        helper.fluentWaitForElement(element);
        actions.dragAndDropBy(element,xOffset,yOffset).build().perform();
        helper.takeScreenshot();
    }

    void dragElementAndTakeScreenshot(WebElement element,WebElement target) {
        helper.fluentWaitForElement(element);
        actions.dragAndDrop(element, target).build().perform();
        helper.takeScreenshot();
    }

    public void switchWidget(int widget) {
        actions.moveToElement(buttonsBar.findElement(By.xpath(".//li["+widget+"]"))).build().perform();
        buttonsBar.findElement(By.xpath(".//li["+widget+"]")).click();
        try {
            driver.switchTo().frame(widget - 1);
        }catch(NoSuchFrameException e) {
            System.out.println(e.fillInStackTrace());
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

    public void openWidget(int x){
        actions.moveToElement(interactionMenu).build().perform();
        helper.fluentWaitForElement(interactionMenu.findElement(By.xpath(".//li["+x+"]")));
        actions.click(interactionMenu.findElement(By.xpath(".//li["+x+"]"))).build().perform();
    }
}
