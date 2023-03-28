package tests;

import driver.Driver;
import model.pages.AgendaPage;
import model.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utils.EnumHelper;

public class HomePageTest extends BaseTest{

    @Test
    public void test1() {
        HomePage homePage = new HomePage();
        goToURL("/");

        //enter passcodes
        homePage.enterEventPassCode("PIGEONQATEST");
        homePage.enterAttendeePassCode("RT8Y1248LJ");

        //submit a question, need verifications
        AgendaPage agendaPage = new AgendaPage();
        String sessionTitle = "Pigeonlab QA Test";
        String sessionDescription = "Welcome! All available sessions are shown below.";
        Assert.assertTrue(agendaPage.sessionInfoContent().contains(sessionTitle) &&
                agendaPage.sessionInfoContent().contains(sessionDescription), "[ERR] Page Agenda should be navigated.");
        agendaPage.submitQuestion("PIGEONQATEST");
        agendaPage.sortTo(EnumHelper.SortType.Latest.value());
        Assert.assertTrue(agendaPage.latestQuestion().getText().contains("PIGEONQATEST"), "[ERR] Your question is not posted.");

        //submit comment, need verifications
        agendaPage.addComment("PIGEONQATEST");
        Assert.assertTrue(agendaPage.latestComment().isDisplayed(), "[ERR] Posted comment should appear.");

        //vote a comment, need verifications
        int beforeUpVoteNum = Integer.parseInt(agendaPage.upVoteComment().getText());
        agendaPage.voteUpForComment();

        int afterUpVoteNum = Integer.parseInt(agendaPage.upVoteComment().getText());
        Assert.assertTrue((afterUpVoteNum - beforeUpVoteNum) == 1, "[ERR] Vote number should be increased by 1.");

    }
}
