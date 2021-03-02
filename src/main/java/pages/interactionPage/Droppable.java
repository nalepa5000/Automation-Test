package pages.interactionPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

import java.util.ArrayList;
import java.util.List;

public class Droppable extends Base {

    List <String> listDroppableElements;

    @FindBy(id = "draggable-nonvalid")
    WebElement drggableElement;

    @FindBy(id = "draggable")
    WebElement draggableElement1;

    @FindBy(id = "droppable")
    WebElement droppableElement1;

    public Droppable(WebDriver driver) {
        super(driver);
        this.listDroppableElements = new ArrayList<>();
    }

    public Droppable droDefaultFunctionality() {
        switchWidget(1);
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
        driver.switchTo().defaultContent();
        return listDroppableElements;
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


}
