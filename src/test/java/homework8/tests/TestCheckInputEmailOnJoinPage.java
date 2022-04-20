package homework8.tests;

import TestBase.TestBase;
import homework8.pages.GitHubJoinPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class TestCheckInputEmailOnJoinPage extends TestBase {

    GitHubJoinPage gitHubJoinPage = new GitHubJoinPage();

    @Tag("negative")
    @DisplayName("Негативный тест на проверку поля Email c использованием аннотации ValueSource")
    @ValueSource(strings = {"test", "test@test", "testtest.com"})
    @ParameterizedTest(name = "Ввод невалидного адреса эл.почты {0} и проверка отображения сообщения об ошибке")
    public void testCheckFieldUsingValueSource(String invalidEmail) {
    gitHubJoinPage
            .openPage();

    gitHubJoinPage
            .sendInvalidEmailToInput(invalidEmail)
            .checkErrorMassageIsVisible()
            .checkErrorIconIsVisible();
    }

    @Tag("negative")
    @DisplayName("Негативный тест на проверку поля Email c использованием аннотации CsvSource")
    @CsvSource({"test","test@test", "testtest.com"})
    @ParameterizedTest(name = "Ввод невалидного адреса эл.почты {0} и проверка отображения сообщения об ошибке")
    public void testCheckFieldUsingCsvSource(String invalidEmail) {
        gitHubJoinPage
                .openPage();

        gitHubJoinPage
                .sendInvalidEmailToInput(invalidEmail)
                .checkErrorMassageIsVisible()
                .checkErrorIconIsVisible();
    }

    @Tag("negative")
    @DisplayName("Негативный тест на проверку поля Email c использованием аннотации CsvFileSource")
    @CsvFileSource(resources = {"/invalidEmail.csv"})
    @ParameterizedTest(name = "Ввод невалидного адреса эл.почты {0} и проверка отображения сообщения об ошибке")
    public void testCheckFieldUsingCsvFileSource(String invalidEmail) {
        gitHubJoinPage
                .openPage();

        gitHubJoinPage
                .sendInvalidEmailToInput(invalidEmail)
                .checkErrorMassageIsVisible()
                .checkErrorIconIsVisible();
    }

    private static Stream<Arguments> testCheckFieldUsingMethodSource() {
        return Stream.of(
                Arguments.of("test"),
                Arguments.of("test@test"),
                Arguments.of("testtest.com"));
    }

    @Tag("negative")
    @DisplayName("Негативный тест на проверку поля Email c использованием аннотации MethodSource")
    @MethodSource
    @ParameterizedTest(name = "Ввод невалидного адреса эл.почты {0} и проверка отображения сообщения об ошибке")
    public void testCheckFieldUsingMethodSource(String invalidEmail) {
        gitHubJoinPage
                .openPage();

        gitHubJoinPage
                .sendInvalidEmailToInput(invalidEmail)
                .checkErrorMassageIsVisible()
                .checkErrorIconIsVisible();
    }
}
