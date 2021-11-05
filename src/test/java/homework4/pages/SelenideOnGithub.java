package homework4.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideOnGithub {
    //elements
    SelenideElement wikiTab = $("a#wiki-tab"),
            textTitleWelcomeToWiki = $("div#wiki-body h1"),
            wikiPageBlock = $("div#wiki-body"),
            linkSoftAssertions = $(byText("Soft assertions")),
            textTitleSoftAssertions = $("h1");

    //actions
    public SelenideOnGithub openPage() {
        open("https://github.com/selenide/selenide");
        return this;
    }

    public SelenideOnGithub goToWikiTab() {
        wikiTab.click();
        return this;
    }

    public SelenideOnGithub assertTexTitleWikiTabIsVisible() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(textTitleWelcomeToWiki).build().perform();
        Assertions.assertTrue(textTitleWelcomeToWiki.isDisplayed());
        textTitleWelcomeToWiki.shouldHave(text("Welcome to the selenide wiki"));
        return this;
    }

    public SelenideOnGithub assertWikiBlockHaveSoftAssertions() {
        wikiPageBlock.shouldHave(text("Soft Assertions"));
        return this;
    }

    public SelenideOnGithub goToSoftAssertionsPage() {
        linkSoftAssertions.click();
        return this;
    }

    public SelenideOnGithub assertTexTitleSoftAssertionsIsVisible() {
        Assertions.assertTrue(textTitleSoftAssertions.isDisplayed());
        return this;
    }

    public SelenideOnGithub assertBlockSoftAssertionsHaveJUnitExample() {
        wikiPageBlock.shouldHave(text("Using JUnit5 extend test class"));
        return this;
    }
}
