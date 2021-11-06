package homework4.tests;

import TestBase.TestBase;
import homework4.pages.SelenideOnGithub;
import org.junit.jupiter.api.Test;

public class TestSoftAssertionsPage extends TestBase {

    @Test
    public void testSoftAssertionsHaveJUnit5Example(){

        SelenideOnGithub selenideOnGithub = new SelenideOnGithub();

        selenideOnGithub
                .openPage();

        selenideOnGithub
                .goToWikiTab()
                .assertTexTitleWikiTabIsVisible()
                .assertWikiBlockHaveSoftAssertions()
                .assertWikiBlockHaveSoftAssertions()
                .goToSoftAssertionsPage()
                .assertTexTitleSoftAssertionsIsVisible()
                .assertBlockSoftAssertionsHaveJUnitExample();
    }
}
