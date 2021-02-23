package tests.interaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Droppable extends InteractionBase{

    public Droppable(WebDriver driver) {
        super(driver);
    }

    public Droppable droDefaultFunctionality() {
        actions.moveToElement(interactionMenu).build().perform();
        helper.fluentWaitForElement(interactionMenu.findElement(By.xpath(".//li[2]")));
        actions.click(interactionMenu.findElement(By.xpath(".//li[2]"))).build().perform();
        driver.switchTo().frame(0);
        dragElementAndTakeScreenshot(draggableElement1, droppableElement1);

        driver.switchTo().defaultContent();
        return this;

    }

}
