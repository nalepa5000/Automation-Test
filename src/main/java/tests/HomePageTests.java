package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends Base {

    @Test
    public void homePageTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.logIn();


    }

}
