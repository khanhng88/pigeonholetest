package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;

public class ActionHelper {
    private static final int WAIT_VISIBILE_TIMEOUT = 3;
    private static final int WAIT_INVISIBILE_TIMEOUT = 5;
    private static final int WAIT_DATA_LOADING_TIMEOUT = 3;

    private static By questionLoadingSel = By.className("border-able");

    public static void scrollIntoElement(WebElement element) {
        ((JavascriptExecutor)Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), WAIT_VISIBILE_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), WAIT_VISIBILE_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForQuestionsLoading() {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), WAIT_DATA_LOADING_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(questionLoadingSel));
    }

    public static void waitForElementAttributeContains(By locator, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), WAIT_DATA_LOADING_TIMEOUT);
        wait.until(ExpectedConditions.
                attributeContains(locator,
                        attribute,
                        value));
    }

    public static void waitForElementAttributeContains(WebElement element, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), WAIT_DATA_LOADING_TIMEOUT);
        wait.until(ExpectedConditions.
                attributeContains(element,
                        attribute,
                        value));
    }
}
