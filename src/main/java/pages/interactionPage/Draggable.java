package pages.interactionPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;

public class Draggable extends InteractionBase{

    public Draggable(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/ul/li[1]/span[2]")
    private WebElement startLabel;

    @FindBy(xpath = "//div/ul/li[2]/span[2]")
    private WebElement dragLabel;

    @FindBy(xpath = "//div/ul/li[3]/span[2]")
    private WebElement stopLabel;

    @FindBy (xpath = "//li[@class='ui-state-highlight ui-draggable ui-draggable-handle ui-sortable-helper']")
    private WebElement draggableCopy;


    public Draggable dra1DefaultFunctionality(int xOffset, int yOffset){
        driver.switchTo().frame(0);
        try {
            dragElementAndTakeScreenshot(draggableElement1,xOffset,yOffset);
        } catch (MoveTargetOutOfBoundsException e){
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable dra2ConstrainMovement(int firstXOffset, int firstYOffset, int secondXOffset, int secondYOffset,
                                           int thirdXOffset, int thirdYOffset, int fourthXOffset, int fourthYOffset) {
       switchWidget(2);
        try {
            dragElementAndTakeScreenshot(draggableElement1, firstXOffset, firstYOffset);
            dragElementAndTakeScreenshot(draggableElement2, secondXOffset, secondYOffset);
            dragElementAndTakeScreenshot(draggableElement3, thirdXOffset, thirdYOffset);
            dragElementAndTakeScreenshot(draggableElement5, fourthXOffset, fourthYOffset);
        } catch (MoveTargetOutOfBoundsException e){
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable dra3Evenets(int xOffset, int yOffset) {
        switchWidget(4);
        try {
            dragElementAndTakeScreenshot(draggableElement1,xOffset,yOffset);
        } catch (MoveTargetOutOfBoundsException e){
           e.printStackTrace();
        }
        System.out.println("Start label: " + startLabel.getText());
        System.out.println("Drag label: " + dragLabel.getText());
        System.out.println("Stop label: " + stopLabel.getText() + "\n");
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
