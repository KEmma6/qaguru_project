package testSuites;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
        static void doBeforeAllTest() {

        Configuration.startMaximized = true;

    }

    @Test
    void assertRegistrationStudent() {

        //открываем страницу с формой регистрации
        open("https://demoqa.com/automation-practice-form");

        //заполняем поля формы регистрации
        $("#firstName").setValue("Биба");
        $("id='lastName'").setValue("Боба");
        $x("//input[id='lastName']").setValue("test@test.ru");
        $("div.custom-radio > input[value = 'Female']").click();
        $("#userPhone").setValue("1234567899");






    }
}
