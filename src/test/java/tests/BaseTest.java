package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.dashboard.DashboardPage;
import pages.LoginPage;
import utils.PropertyReader;

public class BaseTest {

    String user;
    String password;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setup () {
        Configuration.baseUrl = System.getenv().getOrDefault("TESTRAIL_URL",
                PropertyReader.getProperty("testrail.url"));
        user = System.getenv().getOrDefault("TESTRAIL_USER",
                PropertyReader.getProperty("testrail.user"));
        password = System.getenv().getOrDefault("TESTRAIL_PASSWORD",
                PropertyReader.getProperty("testrail.password"));
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }
}
