package homework8.pages;

import org.junit.jupiter.api.Assertions;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSearchPage {
    private String fieldSearch = "input[data-test-selector='nav-search-input']";
    private String projectName = "div[class*='f4']";

    public void openPage() {
        open("https://github.com/");
    }

    public GitHubSearchPage enteringSearchKeyword(String searchKeyword) {
        $(fieldSearch).sendKeys(searchKeyword);
        return this;
    }

    public GitHubSearchPage pressEnterOnField() {
        $(fieldSearch).pressEnter();
        return this;
    }

    public GitHubSearchPage checkSearchResultsHasSearchKeyword(String searchKeyword) {
        String projectsName = $(projectName).getText().toLowerCase(Locale.ROOT);
        Assertions.assertTrue(projectsName.contains(searchKeyword));
        return this;
    }
}
