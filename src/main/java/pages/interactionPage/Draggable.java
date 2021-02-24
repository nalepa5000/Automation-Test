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

    @FindBy (xpath = "//ul[@id='sortable']/li2")
    private WebElement ELEMENT;

    @FindBy (xpath = "//ul[@id='sortable']/li3")
    private WebElement ELEMENT2;

    @FindBy (xpath = "//ul[@id='sortable']/li4")
    private WebElement ELEMENT3;

    @FindBy (xpath = "//ul[@id='sortable']/li5")
    private WebElement ELEMENT4;

    public Draggable dra1DefaultFunctionality() {
        openWidget(1);
        driver.switchTo().frame(0);
        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);
        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable dra2ConstrainMovement() {
       switchWidget(2);
        dragElementAndTakeScreenshot(draggableElement1,0,300);
        dragElementAndTakeScreenshot(draggableElement2,800,0);
        dragElementAndTakeScreenshot(draggableElement3,780,30);
        dragElementAndTakeScreenshot(draggableElement5,0,20);
        driver.switchTo().defaultContent();
        return this;
    }

    public List<String> dra3Evenets() {
        switchWidget(4);
        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);
        labelValues.add(draggableElement1.getText());
        labelValues.add(draggableElement2.getText());
        labelValues.add(draggableElement3.getText());
        return labelValues;
    }

    public Draggable dra4DraggableSortable() {
        switchWidget(5);
        dragElementAndTakeScreenshot(draggableElement1, 0, 50);
        dragElementAndTakeScreenshot(ELEMENT, ELEMENT2);
        dragElementAndTakeScreenshot(ELEMENT2, ELEMENT3);
        dragElementAndTakeScreenshot(ELEMENT3, ELEMENT4);
        dragElementAndTakeScreenshot(draggableCopy, 0, 50);
        return this;
    }

}
