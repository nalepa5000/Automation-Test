package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Helper {

    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot (){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/test/resources" + LocalTime.now().getNano() + ".png");
        try {
            Files.copy(screenshotFile.toPath(),destinationFile.toPath());
        }catch (IOException io){
            System.out.println(io.fillInStackTrace());
        }
    }

    public void fluentWaitForElement(WebElement webElement) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void fluentWaitForElement(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(5L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fluentWaitForElement(List<WebElement> list) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(5L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public boolean retryingFindElement(By by) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.findElement(by);
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println(e.fillInStackTrace());
            }
            attempts++;
        }
        return result;
    }

    public boolean retryingFindElementGetSize(WebElement element, By by) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.findElements(by).size();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

}

