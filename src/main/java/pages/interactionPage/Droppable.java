package pages.interactionPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Droppable extends InteractionBase{

    List <String> listDroppableElements;

    @FindBy(id = "draggable-nonvalid")
    WebElement drggableElement;

    public Droppable(WebDriver driver) {
        super(driver);
        this.listDroppableElements = new ArrayList<>();
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

    public List<String> droAccept() {
        switchWidget(2);
        dragElementAndTakeScreenshot(drggableElement, droppableElement1);
        listDroppableElements.add(droppableElement1.getText());
        dragElementAndTakeScreenshot(draggableElement1,droppableElement1);
        listDroppableElements.add(droppableElement1.getText());
        return listDroppableElements;
    }

}
