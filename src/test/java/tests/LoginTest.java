package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "User can login with valid data")
    public void loginWithValidData() {
        String actualHeader = loginPage.
                open().
                login(user, password).
                isPageOpened().
                getHeader();
        assertEquals(actualHeader, "DASHBOARD");
    }

    @Test(description = "User can't login with empty data")
    public void loginWithEmptyData() {
        loginPage.
                open().
                login("", "");
        assertEquals(loginPage.getEmailErrorMessage(), "Email/Login is required.");
        assertEquals(loginPage.getPasswordErrorMessage(), "Password is required.");
    }

    @Test(description = "User can't login with an empty email")
    public void loginWithAnEmptyEmail() {
        loginPage.
                open().
                login("", password);
        assertEquals(loginPage.getEmailErrorMessage(), "Email/Login is required.");
    }

    @Test(description = "User can't login with an empty password")
    public void loginWithAnEmptyPassword() {
        loginPage.
                open().
                login(user, "");
        assertEquals(loginPage.getPasswordErrorMessage(), "Password is required.");
    }

    @Test(description = "User can't login with a special symbol")
    public void loginWithEmailWithSpecialSymbol() {
        loginPage.
                open().
                login("vvv.zenke√ich@gmail.com", password);
        assertEquals(loginPage.getFormErrorMessage(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(description = "User can reset password")
    public void resetPassword() {
        loginPage.
                open().
                resetPassword(user);
        assertEquals(loginPage.getFormErrorMessage(), "Email sent successfully. Please check your email " +
                "inbox for the reset password instructions.");
    }
}
