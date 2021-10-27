package testSuites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
        $("#firstName").setValue("biba");
        $("#lastName").setValue("boba");
        $x("//input[@id='userEmail']").setValue("test@test.ru");
        Selenide.executeJavaScript("document.querySelector('div.custom-radio > input[value = 'Female']',':before').click()");

       // $("div.custom-radio > input[value = 'Female']").click();
        $("#userPhone").setValue("1234567899");
        $("div#dateOfBirth input").setValue("27 Nov 1994");
        $("div[class*='subjects-auto-complete__input']").selectOption("biology");
        $("#hobbies-checkbox-3").click();
        $("input#uploadPicture").setValue("C:\\Users\\kurga\\Desktop\\1540449964194466233.png");







    }
}
