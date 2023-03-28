package model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import driver.Driver;
import utils.ActionHelper;

import java.util.ArrayList;
import java.util.List;

public class PigeonWebElement {
    private WebElement webElement;

    public PigeonWebElement(By locator) {
        this.webElement = Driver.getWebDriver().findElement(locator);
    }

    public PigeonWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public PigeonWebElement findElement(By locator) {
        WebElement element = this.webElement.findElement(locator);
        return new PigeonWebElement(element);
    }

    public List<PigeonWebElement> findElements(By locator) {
        List<PigeonWebElement> pigeonWebElementList = new ArrayList<>();
        List<WebElement> elementList = this.webElement.findElements(locator);
        for (WebElement element : elementList) {
            pigeonWebElementList.add(new PigeonWebElement(element));
        }
        return pigeonWebElementList;
    }

    public void sendKeys(String value) {
        ActionHelper.waitForElementVisible(this.webElement);
        ActionHelper.scrollIntoElement(this.webElement);
        this.webElement.click();
        this.webElement.sendKeys(value);
    }

    public void click() {
        ActionHelper.scrollIntoElement(this.webElement);
        ActionHelper.waitForElementClickable(this.webElement);
        this.webElement.click();
    }

    public WebElement getWebElement() {
        return this.webElement;
    }

    public String getText() {
        return this.webElement.getText().trim();
    }

    public boolean isDisplayed() {
        return this.webElement.isDisplayed();
    }
}