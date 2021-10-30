package testSuites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
        static void doBeforeAllTest() {

        Configuration.startMaximized = true;
    }

    @Test
    void checkStudentRegistration() {

        //открываем страницу с формой регистрации
        open("https://demoqa.com/automation-practice-form");

        //заполняем поля формы регистрации
        $("#firstName").setValue("biba");
        $("#lastName").setValue("boba");
        $x("//input[@id='userEmail']").setValue("test@test.ru");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($("div.custom-radio > input[value = 'Female']")).click().build().perform();
        $("#userNumber").setValue("7878787879");
        $("div[class*='subjects-auto-complete__value']").click();
        $("input#subjectsInput").setValue("Biology");
        $("div#react-select-2-option-0").click();
        actions.moveToElement($("#hobbies-checkbox-3")).click().build().perform();
        $("input#uploadPicture").setValue("C:\\Users\\kurga\\Desktop\\1540449964194466233.png");
        $("textarea#currentAddress").setValue("44 Cedar Avenue");
        $("div#state svg").scrollTo();
        $("div#state svg").click();
        $(byText("Uttar Pradesh")).click();
        $("div#city svg[class='css-19bqh2r']").click();
        $(byText("Agra")).click();
        $("button#submit").click();

        //Выполняем проверки
        Assertions.assertTrue($x("//div[contains(text(), 'Thanks for submit')]").isDisplayed());
        $("table[class*='table']").shouldHave(text("biba"));
        $("table[class*='table']").shouldHave(text("boba"));
        $("table[class*='table']").shouldHave(text("test@test.ru"));
        $("table[class*='table']").shouldHave(text("Female"));
        $("table[class*='table']").shouldHave(text("7878787879"));
        $("table[class*='table']").shouldHave(text("Biology"));
        $("table[class*='table']").shouldHave(text("1540449964194466233.png"));
        $("table[class*='table']").shouldHave(text("44 Cedar Avenue"));
        $("table[class*='table']").shouldHave(text("Uttar Pradesh"));
        $("table[class*='table']").shouldHave(text("Agra"));
    }
}
