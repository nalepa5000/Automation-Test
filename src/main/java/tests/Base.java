package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.out.println("TEST - start");
        String driverPath = "./src/test/resources/executables/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String site = "http://way2automation.com/way2auto_jquery/index.php?fbclid=IwAR3sQt8Z9eR2oa5oD0ZDcOBborEHO31phd4KGY0uwzSkzzAQOhHfrbb20mk";
        driver.get(site);
    }

    @AfterTest
    public void down(){
        System.out.println("TEST - end");
        driver.quit();
    }

    @AfterMethod
    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }
}
