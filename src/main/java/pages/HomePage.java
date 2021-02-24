package pages;

import helper.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;
    Helper helper;
    JavascriptExecutor executor;
    List <String> overlapNames;
    List <Integer> overlapWidgets;

    @FindBy(xpath = "//h1[text()='Interaction')")
    WebElement header1;

    @FindBy(xpath = "//p[@class='text_popup']/a[contains(text(),'Signin')]")
    WebElement signInButton1;

    @FindBy(xpath = "//div[@id='login']/form/fieldset[1]/input")
    WebElement userNameInput;

    @FindBy(xpath = "//div[@id='login']/form/fieldset[2]/input")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@id='login']/form//input[@class='button']")
    WebElement signInButton2;

    @FindBy(xpath = "//u1[@clas='boxed_style block']")
    WebElement interactionSection;

    @FindBy(xpath = "//div[@class='linkbox margin-bottom-20']")
    List<WebElement> widgetBoxes;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.helper = new Helper(driver);
        this.executor = (JavascriptExecutor) driver;
    }

    public HomePage logIn() throws InterruptedException {
        helper.fluentWaitForElement(signInButton1);
        signInButton1.click();
        helper.fluentWaitForElement(userNameInput);
        userNameInput.sendKeys("knalepa");
        passwordInput.sendKeys("Darnok321.");
        signInButton2.click();
        Thread.sleep(3000);
        return this;
    }

    public List<String> overlapNames(){
        overlapNames = new ArrayList<>();
        String name = "";
        for (WebElement widgetBox : widgetBoxes){
            executor.executeScript("window.scrollBy(0,500)");
            helper.fluentWaitForElement(widgetBox);
            name = widgetBox.findElement(By.cssSelector("h1")).getText();
            while(name == ""){
                name = widgetBox.findElement(By.cssSelector("h1")).getText();
            }
            overlapNames.add(name);
        }
        return overlapNames;
    }

    public List<Integer> countOverlapWidgets(){
        executor.executeScript("window.scrollTo(0,0)");
        overlapWidgets = new ArrayList<>();
        for (WebElement widgetBox : widgetBoxes){
            executor.executeScript("window.scrollBy(0,500)");
            helper.fluentWaitForElement(widgetBox);
            helper.retryingFindElementGetSize(widgetBox, By.xpath(".//li"));
        }
        return overlapWidgets;
    }

}
