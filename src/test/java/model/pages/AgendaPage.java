package model.pages;

import driver.Driver;
import model.components.PigeonWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ActionHelper;

import java.util.ArrayList;
import java.util.List;


public class AgendaPage {
    private int invisibleTimeOutForModalBoxTick = 8;
    private By enterQnASel = By.cssSelector(".session-qna .btn-text");

    private By sessionInfoSel = By.className("sessionlist-session-info");
    private By questionInputSel = By.cssSelector(".question-input-container textarea");
    private By sortSel = By.cssSelector("#sort-menu");
    private By questionCountSel = By.className("question-count");
    private By askSel = By.className("question-input-btn");
    private By commentSel = By.id("comment-input");
    private By addCommentSel = By.cssSelector(".question-item-wrap:first-child .question-comment-link");
    private By submitCommentSel = By.className("btn-submit-comment");
    private By upVoteCommentSel = By.className("comment-upvote");
    private By latestCommentSel = By.cssSelector(".comment-item:last-child");
    private By latestQuestionSel = By.cssSelector(".question-item-wrap:first-child");

    private By modalBoxTickSel = By.cssSelector(".modal-tick");

    public String sessionInfoContent() {
        return new PigeonWebElement(sessionInfoSel).getText();
    }

    public PigeonWebElement btnEnterQnA() {
        return new PigeonWebElement(enterQnASel);
    }

    public String sessionName() {
        return new PigeonWebElement(By.className("session-name")).getText();
    }

    public PigeonWebElement upVoteComment() {
        return latestComment().findElement(upVoteCommentSel);
    }

    public PigeonWebElement txtAreaQuestionInput() {
        return new PigeonWebElement(questionInputSel);
    }

    public PigeonWebElement btnSort() {
        return new PigeonWebElement(sortSel);
    }

    public PigeonWebElement latestQuestion() {
        return new PigeonWebElement(latestQuestionSel);
    }

    public int questionCount() {
        String qCount = new PigeonWebElement(questionCountSel).getText();
        return Integer.parseInt(qCount.replaceAll("[^0-9]", ""));
    }

    public PigeonWebElement btnAsk() {
        return new PigeonWebElement(askSel);
    }

    public PigeonWebElement txtComment() {
        return new PigeonWebElement(commentSel);
    }

    public PigeonWebElement btnSubmitComment() {
        return new PigeonWebElement(submitCommentSel);
    }

    public PigeonWebElement linkAddComment() {
        return new PigeonWebElement(addCommentSel);
    }

    public PigeonWebElement latestComment() {
        return new PigeonWebElement(latestCommentSel);
    }

    public void sortTo(String sortType) {
        btnSort().click();
        List<PigeonWebElement> sortOptions = btnSort().findElements(By.tagName("li"));
        for (PigeonWebElement sortOption : sortOptions) {
            if(sortOption.getText().contentEquals(sortType)) {
                sortOption.click();
            }
        }


    }

    public void submitQuestion(String question) {
        btnEnterQnA().click();
        ActionHelper.waitForQuestionsLoading();
        Assert.assertTrue(sessionName().matches("Q&A"), "[ERR] Page Q&A should be navigated.");
        txtAreaQuestionInput().sendKeys(question);
        btnAsk().click();
        waitForModalMsg();
    }

    public void addComment(String commentValue) {
        linkAddComment().click();
        ActionHelper.waitForElementAttributeContains(
                By.cssSelector(".question-comment-load div"),
                "style",
                "display: none;");
        txtComment().click();
        txtComment().sendKeys(commentValue);
        btnSubmitComment().click();
        waitForModalMsg();
    }

    public void voteUpForComment() {
        PigeonWebElement voteUpComment = latestComment().findElement(upVoteCommentSel);
        voteUpComment.click();
        ActionHelper.waitForElementAttributeContains(voteUpComment.getWebElement(),"class", "active");
    }

    public void waitForModalMsg() {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), invisibleTimeOutForModalBoxTick);
        wait.until(ExpectedConditions.invisibilityOfAllElements(Driver.getWebDriver().findElement(modalBoxTickSel),
                Driver.getWebDriver().findElement(By.className("modal-tick")),
                Driver.getWebDriver().findElement(By.id("modal-feedback-heading"))));
    }

}
