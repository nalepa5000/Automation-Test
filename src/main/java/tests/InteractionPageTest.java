package tests;

import org.testng.Assert;
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

        draggableInteraction.openWidget(2,1);
        draggableInteraction.dra1DefaultFunctionality(430,300)
                .dra1DefaultFunctionality(430,-300)
                .dra1DefaultFunctionality(-430,150)
                .dra2ConstrainMovement(0,300, 800,0,
                                        780,30,0,20)
                .dra3Evenets(430,300)
                .dra3Evenets(200,-300)
                .dra3Evenets(-300,100);

        draggableInteraction.openWidget(2,2);
        droppableInteraction.droDefaultFunctionality();
        targetElementText = droppableInteraction.droAccept();
        Assert.assertEquals(targetElementText.get(0), "accept: '#draggable'");
        Assert.assertEquals(targetElementText.get(1), "Dropped!");

        draggableInteraction.openWidget(2,3);
        resizableInteraction.resDefaultFunctionality(200,200);

        draggableInteraction.openWidget(2,4);
        selectableInteraction.selDefaultFunctionality()
                .selDisplayAsGrid();
        selectResultsText = selectableInteraction.selSerialize(0,5);
        Assert.assertEquals(selectResultsText, "#1 #2 #3 #4 #5 #6");
    }
}
