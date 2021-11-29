package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.administration.ProjectsPage;
import pages.dashboard.DashboardPage;
import pages.LoginPage;
import pages.dashboard.MilestonePage;
import pages.dashboard.ProjectDetailsPage;
import utils.PropertyReader;

public class BaseTest {

    public String user;
    public String password;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ProjectDetailsPage projectDetailsPage;
    public ProjectsPage projectsPage;
    public MilestonePage milestonePage;
    public Faker faker;

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
        projectDetailsPage = new ProjectDetailsPage();
        projectsPage = new ProjectsPage();
        milestonePage = new MilestonePage();
        faker = new Faker();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
