package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.interactionPage.Draggable;
import pages.interactionPage.Droppable;

import java.util.List;


public class InteractionPageTest extends Base {

    List<String>amoundOfMoves;
    List<String>targetElementText;

    @Test
    public void interactionPageTest() throws InterruptedException {
        Draggable draggableInteraction = new Draggable(driver);
        Droppable droppableInteraction = new Droppable(driver);
        draggableInteraction.logIn();
        draggableInteraction.dra1DefaultFunctionality()
                .dra2ConstrainMovement();
        amoundOfMoves = draggableInteraction.dra3Evenets();
        Assert.assertEquals(amoundOfMoves.get(0),2);
        Assert.assertEquals(amoundOfMoves.get(1),2);
        Assert.assertEquals(amoundOfMoves.get(2),2);
        droppableInteraction.droDefaultFunctionality();
        targetElementText = droppableInteraction.droAccept();
        Assert.assertEquals(targetElementText.get(0), "accept: '#draggable'");
        Assert.assertEquals(targetElementText.get(1), "Dropped!");
    }

}
