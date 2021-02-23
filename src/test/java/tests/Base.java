package tests;

import Helper.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class Base {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.out.println("TEST - start");
        String driverPath = "C:\\Users\\Konrad\\IdeaProjects\\TestExercise\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void down(){
        System.out.println("TEST - end");
       // driver.quit();
    }
}
