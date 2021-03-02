package pages.interactionPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

import java.util.List;

public class Selectable extends Base {

    String selectResultsText;

    @FindBy(xpath = "//body/ol[@id='selectable']/li")
    List<WebElement>listSelectableElements;

    @FindBy(id = "select-result")
    WebElement selectResults;

    public Selectable(WebDriver driver) {
        super(driver);
    }

    public Selectable selDefaultFunctionality() {
        switchWidget(1);
        for (WebElement listSelectableElement : listSelectableElements) {
            listSelectableElement.click();
            helper.takeScreenshot();
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Selectable selDisplayAsGrid() {
        switchWidget(2);
        listSelectableElements.forEach(element -> {
            element.click();
            helper.takeScreenshot();
        });
        driver.switchTo().defaultContent();
        return this;
    }

    public String selSerialize(int fromElement, int toElement) {
        switchWidget(3);
        actions.dragAndDrop(listSelectableElements.get(fromElement),
                listSelectableElements.get(toElement)).build().perform();
        helper.takeScreenshot();
        selectResultsText = selectResults.getText();
        driver.switchTo().defaultContent();
        return selectResultsText;
    }
}
