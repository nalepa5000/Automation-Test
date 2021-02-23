package tests.interaction;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InteractionBase {

    WebDriver driver;
    Actions actions;
    Helper helper;
    List<Point> draggableElementsList;

    @FindBy(xpath = "//nav[@id='main-nav']/div/ul/li[2]")
    WebElement interactionMenu;

    @FindBy(id = "draggable")
     WebElement draggableElement1;

    @FindBy(id = "draggable2")
     WebElement draggableElement2;

    @FindBy(id = "draggable3")
     WebElement draggableElement3;

    @FindBy(id = "draggable5")
     WebElement draggableElement5;

    @FindBy(id = "droppable")
     WebElement droppableElement1;

    @FindBy(xpath = "//div/ul/li[1]/span[2]")
     WebElement startLabel;

    @FindBy(xpath = "//div/ul/li[2]/span[2]")
     WebElement dragLabel;

    @FindBy(xpath = "//div/ul/li[3]/span[2]")
     WebElement stopLabel;

    @FindBy(className = "responsive-tabs")
     WebElement buttonsBar;

    InteractionBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.helper = new Helper(driver);
        this.draggableElementsList = new ArrayList<>();
    }

     void dragElementAndTakeScreenshot(WebElement element, int xOffset, int yOffset) {
        actions.dragAndDropBy(element,xOffset,yOffset).build().perform();
        draggableElementsList.add(element.getLocation());
        helper.takeScreenshot();
    }

     void dragElementAndTakeScreenshot(WebElement element,WebElement target) {
        actions.dragAndDrop(element, target).build().perform();
        draggableElementsList.add(element.getLocation());
        helper.takeScreenshot();
    }

     void switchWidget(int widget){
        actions.moveToElement(buttonsBar.findElement(By.xpath(".//li["+widget+"]"))).build().perform();
        buttonsBar.findElement(By.xpath(".//li["+widget+"]")).click();
        driver.switchTo().frame(widget-1);
        helper.fluentWaitForElement(draggableElement1);
    }

}
