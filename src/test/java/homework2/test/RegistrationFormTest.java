package homework2.test;

import TestBase.TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import homework2.pages.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest extends TestBase {

    @Test
    void checkStudentRegistration() {
        Faker faker = new Faker();
        RegistrationPage registrationPage = new RegistrationPage();

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress("com");
        String phone = faker.number().digits(10);
        String address = faker.address().streetAddress();
        String subject = "Biology";
        String gender = "Female";
        String year = "1992";
        String month = "November";

        registrationPage
                .openPage();

        registrationPage
                .setInputName(name)
                .setInputLastName(lastName)
                .clickCheckBoxFemale()
                .setInputEmail(email)
                .setInputPhone(phone)
                .setInputDateOfBirth(month, year)
                .chooseSubject(subject)
                .clickCheckBoxHobbies()
                .upLoadImageOnPage()
                .setAddressInTextarea(address)
                .chooseState()
                .chooseCity()
                .clickButtonSubmit();

        registrationPage
                .assertSubmitTitleIsVisible()
                .assertTableAfterRegistrationHave(name)
                .assertTableAfterRegistrationHave(lastName)
                .assertTableAfterRegistrationHave(email)
                .assertTableAfterRegistrationHave(gender)
                .assertTableAfterRegistrationHave(phone)
                .assertTableAfterRegistrationHave(month)
                .assertTableAfterRegistrationHave(year)
                .assertTableAfterRegistrationHave(subject)
                .assertTableAfterRegistrationHave(address)
                .assertTableAfterRegistrationHave(gender);

    }
}
