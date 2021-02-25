package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.interactionPage.Draggable;
import pages.interactionPage.Droppable;
import pages.interactionPage.Resizable;
import pages.interactionPage.Selectable;

import java.util.List;


public class InteractionPageTest extends Base {

    List<String>targetElementText;
    String selectResultsText;

    @Test
    public void interactionPageTest() throws InterruptedException {
        Draggable draggableInteraction = new Draggable(driver);
        Droppable droppableInteraction = new Droppable(driver);
        Resizable resizableInteraction = new Resizable(driver);
        Selectable selectableInteraction = new Selectable(driver);

        draggableInteraction.logIn();
        draggableInteraction.openWidget(1);
        draggableInteraction.dra1DefaultFunctionality(5, -100, 400)
                .dra2ConstrainMovement()
                .dra3Evenets();

        droppableInteraction.openWidget(2);
        droppableInteraction.droDefaultFunctionality();
        targetElementText = droppableInteraction.droAccept();
        Assert.assertEquals(targetElementText.get(0), "accept: '#draggable'");
        Assert.assertEquals(targetElementText.get(1), "Dropped!");

        resizableInteraction.openWidget(3);
        resizableInteraction.resDefaultFunctionality();

        selectableInteraction.openWidget(4);
        selectableInteraction.selDefaultFunctionality()
                .selDisplayAsGrid();
        selectResultsText = selectableInteraction.selSerialize();
        Assert.assertEquals(selectResultsText, "#1 #2 #3 #4 #5 #6");
    }


}
