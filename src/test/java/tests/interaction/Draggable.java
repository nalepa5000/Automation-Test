package tests.interaction;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Draggable extends InteractionBase{

    public Draggable(WebDriver driver) {
        super(driver);
    }

    public List<Point> draDefaultFunctionality() {
        actions.moveToElement(interactionMenu).build().perform();
        actions.click(interactionMenu.findElement(By.xpath(".//li[1]"))).build().perform();

        driver.switchTo().frame(0);

        draggableElementsList.add(draggableElement1.getLocation());
        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);

        driver.switchTo().defaultContent();
        return draggableElementsList;

    }


    public List<Point> draConstrainMovement() {
       switchWidget(2);

        dragElementAndTakeScreenshot(draggableElement1,0,300);
        dragElementAndTakeScreenshot(draggableElement2,800,0);
        dragElementAndTakeScreenshot(draggableElement3,780,30);
        dragElementAndTakeScreenshot(draggableElement5,0,20);

        driver.switchTo().defaultContent();
        return draggableElementsList;
    }

    public Draggable draEvenets() {
        switchWidget(4);

        dragElementAndTakeScreenshot(draggableElement1,430,300);
        dragElementAndTakeScreenshot(draggableElement1,430,-300);
        dragElementAndTakeScreenshot(draggableElement1,-430,150);

        System.out.println("StartLabel: "+startLabel.getText());
        System.out.println("DragLabel: "+dragLabel.getText());
        System.out.println("StopLabel: "+stopLabel.getText());

        driver.switchTo().defaultContent();
        return this;
    }

    public Draggable draDraggableSortable() {
        switchWidget(5);

        dragElementAndTakeScreenshot(draggableElement1, 0, 50);
        dragElementAndTakeScreenshot(draggableElement1, 0, 100);
        dragElementAndTakeScreenshot(draggableElement1, 0, 150);
        dragElementAndTakeScreenshot(draggableElement1, 0, 200);
        dragElementAndTakeScreenshot(draggableElement1, 0, 250);

        return this;
    }

}
