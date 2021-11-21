package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.dashboard.DashboardPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage{

    public static final String EMAIL_ID = "name";
    public static final String PASSWORD_ID = "password";
    public static final String LOGIN_BUTTON_ID = "button_primary";
    public static final String FORGOTPASSWORD_CSS = "[class='loginpage-forgotpassword']";
    String emailError_xpath = "//*[@id='content']/form/*[@class='loginpage-message-image loginpage-message ']";
    String passwordError_xpath = "//*[@id='content']/form//div/*[@class='loginpage-message-image loginpage-message ']";
    String formError_css = "[class='error-text']";

    public LoginPage open() {
        Selenide.open("index.php?/auth/login");
        $(By.id(LOGIN_BUTTON_ID)).shouldBe(Condition.visible);
        return this;
    }

    public DashboardPage login(String user, String password) {
        $(By.id(EMAIL_ID)).sendKeys(user);
        $(By.id(PASSWORD_ID)).sendKeys(password);
        $(By.id(LOGIN_BUTTON_ID)).click();
        return new DashboardPage();
    }

    public String getEmailErrorMessage() {
        return $x(emailError_xpath).getText();
    }

    public String getPasswordErrorMessage() {
        return $x(passwordError_xpath).getText();
    }

    public String getFormErrorMessage() {
        return $(formError_css).getText();
    }

    public void resetPassword(String user) {
        $(FORGOTPASSWORD_CSS).click();
        $(By.id(EMAIL_ID)).sendKeys(user);
        $(By.id(EMAIL_ID)).submit();
        $(formError_css).shouldBe(Condition.visible);
    }
}
