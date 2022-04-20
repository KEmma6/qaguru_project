package homework8.tests;

import TestBase.TestBase;
import homework8.GitHubProjectsNames;
import homework8.pages.GitHubSearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Locale;

public class TestSearchGitHubProject extends TestBase {
    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

    @ParameterizedTest(name = "Поиск проектов в GitHub по названию {0}")
    @EnumSource(value = GitHubProjectsNames.class)
    @Tag("Blocker")
    @DisplayName("Поиск проектов в GitHub по названию с использованием EnumSource")
    public void testCheckSearchResults(GitHubProjectsNames keyword) {
    gitHubSearchPage
            .openPage();

    gitHubSearchPage
            .enteringSearchKeyword(keyword.name().toLowerCase(Locale.ROOT))
            .pressEnterOnField()
            .checkSearchResultsHasSearchKeyword(keyword.name().toLowerCase(Locale.ROOT));
    }
}
