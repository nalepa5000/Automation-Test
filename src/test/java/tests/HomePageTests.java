package tests;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.interaction.Draggable;
import tests.interaction.Droppable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageTests extends Base {

    @Test
    public void homePageTest() throws InterruptedException {

        String site = "http://way2automation.com/way2auto_jquery/index.php?fbclid=IwAR3sQt8Z9eR2oa5oD0ZDcOBborEHO31phd4KGY0uwzSkzzAQOhHfrbb20mk";
        driver.get(site);
        HomePage homePage = new HomePage(driver);

        List<Point> elementsLocalization = new ArrayList<>();
        Draggable draggableTest = new Draggable(driver);
        Droppable droppableTest = new Droppable(driver);

        homePage.logIn();

        elementsLocalization = draggableTest.draDefaultFunctionality();
        elementsLocalization = draggableTest.draConstrainMovement();

        draggableTest.draEvenets()
                .draDraggableSortable();







        /*List<String>overlapNames = homePage.overlapNames();
        Assert.assertEquals(overlapNames.get(0), "Interaction");
        Assert.assertEquals(overlapNames.get(1), "Widget");
        Assert.assertEquals(overlapNames.get(2), "Frames And Windows");
        Assert.assertEquals(overlapNames.get(3), "Dynamic Elements");
        Assert.assertEquals(overlapNames.get(4), "Registration");
        Assert.assertEquals(overlapNames.get(5), "Alert");

        List<Integer>overlapWidgetAmound = homePage.countOverlapWidgets();
         */






    }

}
