package homework4.tests;

import com.codeborne.selenide.Configuration;
import homework4.pages.SelenideOnGithub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestSoftAssertionsPage {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

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
