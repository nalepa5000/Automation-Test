package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends Base {

    @Test
    public void homePageTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.logIn();

    }

}
