package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.administration.ProjectsPage;
import pages.dashboard.DashboardPage;
import pages.LoginPage;
import pages.dashboard.MilestonePage;
import pages.dashboard.ProjectPage;
import utils.PropertyReader;

public class BaseTest {

    public String user;
    public String password;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ProjectPage projectPage;
    public ProjectsPage projectsPage;
    public MilestonePage milestonePage;

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
        projectPage = new ProjectPage();
        projectsPage = new ProjectsPage();
        milestonePage = new MilestonePage();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }
}
