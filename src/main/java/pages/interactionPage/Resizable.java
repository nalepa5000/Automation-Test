package pages.interactionPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Resizable extends InteractionBase{

    @FindBy(xpath = "//div[@id='resizable']/div[3]")
    WebElement resizableButton;

    public Resizable(WebDriver driver) {
        super(driver);
    }

    public Resizable resDefaultFunctionality() {
        driver.switchTo().frame(0);
        actions.clickAndHold(resizableButton)
                .moveToElement(resizableButton,300,140)
                .release()
                .build().perform();
        helper.takeScreenshot();
        driver.switchTo().defaultContent();
        return this;
    }
}
