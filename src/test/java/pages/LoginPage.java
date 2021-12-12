package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.dashboard.DashboardPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class LoginPage extends BasePage{

    public static final String EMAIL_ID = "name";
    public static final String PASSWORD_ID = "password";
    public static final String LOGIN_BUTTON_ID = "button_primary";
    public static final String FORGOTPASSWORD_CSS = "[class='loginpage-forgotpassword']";
    public static final String EMAIL_ERROR_XPATH = "//*[@id='content']/form/*[@class='loginpage-message-image " +
            "loginpage-message ']";
    public static final String PASSWORD_ERROR_XPATH = "//*[@id='content']/form//div/*[@class='loginpage-message-image " +
            "loginpage-message ']";
    public static final String FORM_ERROR_CSS = "[class='error-text']";

    @Step("Opening LoginPage")
    public LoginPage open() {
        Selenide.open("index.php?/auth/login");
        $(By.id(LOGIN_BUTTON_ID)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Login")
    public DashboardPage login(String user, String password) {
        $(By.id(EMAIL_ID)).sendKeys(user);
        $(By.id(PASSWORD_ID)).sendKeys(password);
        $(By.id(LOGIN_BUTTON_ID)).click();
        return new DashboardPage();
    }

    @Step("Getting email error message")
    public String getEmailErrorMessage() {
        return $x(EMAIL_ERROR_XPATH).getText();
    }

    @Step("Getting password error message")
    public String getPasswordErrorMessage() {
        return $x(PASSWORD_ERROR_XPATH).getText();
    }

    @Step("Getting form message")
    public String getFormErrorMessage() {
        return $(FORM_ERROR_CSS).getText();
    }

    @Step("Resetting password")
    public void resetPassword(String user) {
        $(FORGOTPASSWORD_CSS).click();
        $(By.id(EMAIL_ID)).sendKeys(user);
        $(By.id(EMAIL_ID)).submit();
        $(FORM_ERROR_CSS).shouldBe(Condition.visible);
    }
}
