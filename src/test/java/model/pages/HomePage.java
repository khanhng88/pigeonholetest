package model.pages;

import org.openqa.selenium.By;
import model.components.PigeonWebElement;

public class HomePage {
    private By eventPassCodeSel = By.id("passcodeInput");
    private By eventPassCodeSubmitSel = By.cssSelector(".passcode-form-passcode .passcode-entry-arrow .passcode-entry-submit");
    private By attendeePassCodeSel = By.id("attendee-code-input");
    private By attendeePassCodeSubmitSel = By.cssSelector(".passcode-form-usercode .passcode-entry-arrow .passcode-entry-submit");

    public PigeonWebElement txtEventPassCode() {
        return new PigeonWebElement( eventPassCodeSel);
    }

    public PigeonWebElement btnEventPassCodeSubmit() {
        return new PigeonWebElement(eventPassCodeSubmitSel);
    }

    public PigeonWebElement txtAttendeePassCode() {
        return new PigeonWebElement(attendeePassCodeSel);
    }

    public PigeonWebElement btnAttendeePassCodeSubmit() {
        return new PigeonWebElement(attendeePassCodeSubmitSel);
    }

    public void enterEventPassCode(String eventPassCodeValue) {
        txtEventPassCode().sendKeys(eventPassCodeValue);
        btnEventPassCodeSubmit().click();
    }

    public void enterAttendeePassCode(String attendeePassCodeValue) {
        txtAttendeePassCode().sendKeys(attendeePassCodeValue);
        btnAttendeePassCodeSubmit().click();
    }
}
