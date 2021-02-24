package pages.interactionPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Draggable extends InteractionBase{

    public List<String> labelValues;

    public Draggable(WebDriver driver) {
        super(driver);
        this.labelValues = new ArrayList<String>();
    }

    @FindBy(xpath = "//div/ul/li[1]/span[2]")
    private WebElement startLabel;

    @FindBy(xpath = "//div/ul/li[2]/span[2]")
    private WebElement dragLabel;

    @FindBy(xpath = "//div/ul/li[3]/span[2]")
    private WebElement stopLabel;

    @FindBy (xpath = "//li[@class='ui-state-highlight ui-draggable ui-draggable-handle ui-sortable-helper']")
    private WebElement draggableCopy;

    public Draggable draDefaultFunctionality() {
        openWidget(1);
        driver.switchTo().frame(0);
        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);
        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable draConstrainMovement() {
       switchWidget(2);
        dragElementAndTakeScreenshot(draggableElement1,0,300);
        dragElementAndTakeScreenshot(draggableElement2,800,0);
        dragElementAndTakeScreenshot(draggableElement3,780,30);
        dragElementAndTakeScreenshot(draggableElement5,0,20);
        driver.switchTo().defaultContent();
        return this;
    }

    public List<String> draEvenets() {
        switchWidget(4);
        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);
        labelValues.add(draggableElement1.getText());
        labelValues.add(draggableElement2.getText());
        labelValues.add(draggableElement3.getText());
        return labelValues;
    }

    public Draggable draDraggableSortable() {
        switchWidget(5);
        dragElementAndTakeScreenshot(draggableElement1, 0, 50);
        dragElementAndTakeScreenshot(draggableCopy, 0, 50);
        dragElementAndTakeScreenshot(draggableCopy, 0, 50);
        dragElementAndTakeScreenshot(draggableCopy, 0, 55);
        dragElementAndTakeScreenshot(draggableCopy, 0, 55);
        return this;
    }

}
