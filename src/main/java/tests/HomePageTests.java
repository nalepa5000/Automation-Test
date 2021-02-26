package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.List;

public class HomePageTests extends Base {

    @Test
    public void homePageTest() throws InterruptedException {

        List<String> overlapNames;
        List<Integer> widgetsAmoud;
        String phoneNumber, email, skype;
        HomePage homePage = new HomePage(driver);
        homePage.logIn();

        phoneNumber = homePage.getPhoneNumber();
        Assert.assertEquals(phoneNumber, "+91-9711-191-558");
        email = homePage.getEmail();
        Assert.assertEquals(email, "trainer@way2automation.com");
        skype = homePage.getSkype();
        Assert.assertEquals(skype, "seleniumcoaching");

        overlapNames = homePage.overlapNames();
        Assert.assertEquals(overlapNames.get(0), "Interaction");
        Assert.assertEquals(overlapNames.get(1), "Widget");
        Assert.assertEquals(overlapNames.get(2), "Frames And Windows");
        Assert.assertEquals(overlapNames.get(3), "Dynamic Elements");
        Assert.assertEquals(overlapNames.get(4), "Registration");
        Assert.assertEquals(overlapNames.get(5), "Alert");

        widgetsAmoud = homePage.countOverlapWidgets();
        Assert.assertTrue(widgetsAmoud.get(0)==5);
        Assert.assertTrue(widgetsAmoud.get(1)==7);
        Assert.assertTrue(widgetsAmoud.get(2)==1);
        Assert.assertTrue(widgetsAmoud.get(3)==2);
        Assert.assertTrue(widgetsAmoud.get(4)==1);
        Assert.assertTrue(widgetsAmoud.get(5)==1);
    }

}
