package testSuites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
        $("div.custom-radio > input[value = 'Female']");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($("div.custom-radio > input[value = 'Female']")).click().build().perform();
        $("#userNumber").sendKeys("7878787879");
        $("div#dateOfBirth input").setValue("12 Nov 1996");
//        WebDriver driver = new WebDriver();
//        driver.Url = @"http://jqueryui.com/datepicker/";
//        driver.SwitchTo().Frame(
//                driver.FindElement(By.CssSelector("iframe.demo-frame")));
        //SetDatepicker(driver, "#datepicker", "02/20/2002");
        $("div[class*='subjects-auto-complete__input']").click();
        $("div[class*='subjects-auto-complete__input']").sendKeys("b");
        $("div[class*='react-select']").selectOptionContainingText("Biology");
        $("#hobbies-checkbox-3").click();
        $("input#uploadPicture").setValue("C:\\Users\\kurga\\Desktop\\1540449964194466233.png");







    }
}
