package homework8;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubJoinPage {

    private String inputEmail = "#user_email";
    private String errorMassage = ".error";
    private String errorIconInField = "input[class*='is-autocheck-errored']";


    public void openPage(){
        open("https://github.com/join");
    }

    public GitHubJoinPage sendInvalidEmailToInput(String value) {
        $(inputEmail).sendKeys(value);
        return this;
    }

    public GitHubJoinPage checkErrorMassageIsVisible() {
        $(errorMassage).isDisplayed();
        String actualErrorMassage = $(errorMassage).getText();
        Assertions.assertEquals(actualErrorMassage, "Email is invalid or already taken");
        return this;
    }

    public GitHubJoinPage checkErrorIconIsVisible() {
        $(errorIconInField).isDisplayed();
        return this;
    }

}
