package pages.interactionPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Draggable extends InteractionBase{

    public List<String> labelValues;
    Random random;

    public Draggable(WebDriver driver) {
        super(driver);
        this.labelValues = new ArrayList<String>();
        random = new Random();
    }

    @FindBy(xpath = "//div/ul/li[1]/span[2]")
    private WebElement startLabel;

    @FindBy(xpath = "//div/ul/li[2]/span[2]")
    private WebElement dragLabel;

    @FindBy(xpath = "//div/ul/li[3]/span[2]")
    private WebElement stopLabel;

    @FindBy (xpath = "//li[@class='ui-state-highlight ui-draggable ui-draggable-handle ui-sortable-helper']")
    private WebElement draggableCopy;


    public Draggable dra1DefaultFunctionality(int amound, int minPx, int maxPx) {
        driver.switchTo().frame(0);
        for (int i = 0; i < amound; i++) {
            try {
                dragElementAndTakeScreenshot(draggableElement1,getRandomNumber(minPx,maxPx),getRandomNumber(minPx,maxPx));
            }catch (MoveTargetOutOfBoundsException e){
                System.out.println(e.fillInStackTrace());
            }
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable dra1DefaultFunctionality(int xOffset, int yOffset){
        driver.switchTo().frame(0);
        try {
            dragElementAndTakeScreenshot(draggableElement1,xOffset,yOffset);
        } catch (MoveTargetOutOfBoundsException e){
            System.out.println(e.fillInStackTrace());
        }
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

    public Draggable dra3Evenets() {
        switchWidget(4);
        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);
        System.out.println("Start label: " + startLabel.getText());
        System.out.println("Drag label: " + dragLabel.getText());
        System.out.println("Stop label: " + stopLabel.getText());
        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable dra4DraggableSortable() {
        switchWidget(5);
        dragElementAndTakeScreenshot(draggableElement1, 0, 50);
        dragElementAndTakeScreenshot(draggableCopy, 0, 50);
        driver.switchTo().defaultContent();
        return this;
    }

}
