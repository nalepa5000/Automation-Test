package pages.interactionPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Selectable extends InteractionBase {

    String selectResultsText;

    @FindBy(xpath = "//body/ol[@id='selectable']/li")
    List<WebElement>listSelectableElements;

    @FindBy(xpath = "//iframe[@src='selectable/default.html']")
    WebElement frame;

    @FindBy(id = "select-result")
    WebElement selectResults;

    public Selectable(WebDriver driver) {
        super(driver);
    }

    public Selectable selDefaultFunctionality() {
        driver.switchTo().frame(0);
        for (WebElement listSelectableElement : listSelectableElements) {
            listSelectableElement.click();
            helper.takeScreenshot();
        }
       // driver.switchTo().defaultContent();
        return this;
    }

    public Selectable selDisplayAsGrid() {
        switchWidget(2);
        listSelectableElements.forEach(element -> {
            element.click();
            helper.takeScreenshot();
        });
        //driver.switchTo().defaultContent();
        return this;
    }

    public String selSerialize() {
        switchWidget(3);
        actions.dragAndDrop(listSelectableElements.get(0), listSelectableElements.get(5)).build().perform();
        helper.takeScreenshot();
        selectResultsText = selectResults.getText();
        driver.switchTo().defaultContent();
        return selectResultsText;
    }
}
