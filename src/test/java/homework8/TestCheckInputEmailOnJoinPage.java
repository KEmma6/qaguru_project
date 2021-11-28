package homework8;

import TestBase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCheckInputEmailOnJoinPage extends TestBase {

    GitHubJoinPage gitHubJoinPage = new GitHubJoinPage();

    @Tag("normal")
    @DisplayName("Негативный тест на проверку поля Email. Ввод невалидной почты")
    @ValueSource(strings = {"холодильник", "зубная щетка", "электрогриль"})
    @ParameterizedTest(name = "Поиск товара {0} на сайте Mvideo и проверка отображения текста \"{0}\" в каждой карточке товара")
    public void testCheckField(String invalidEmail) {
    gitHubJoinPage
            .openPage();

    gitHubJoinPage
            .sendInvalidEmailToInput(invalidEmail)
            .checkErrorMassageIsVisible()
            .checkErrorIconIsVisible();

    }
}
