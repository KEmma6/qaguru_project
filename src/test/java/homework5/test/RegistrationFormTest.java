package homework5.test;

import TestBase.TestBase;
import com.github.javafaker.Faker;
import homework5.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

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
