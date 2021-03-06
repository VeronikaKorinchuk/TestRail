package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.administration.ProjectsPage;
import pages.dashboard.*;
import pages.LoginPage;
import utils.PropertyReader;
import static com.codeborne.selenide.Selenide.*;
import static pages.BasePage.CONFIRM_DELETE_XPATH;
import static pages.administration.ProjectsPage.DELETE_CHECKBOX_XPATH;

@Listeners(TestListener.class)
public class BaseTest {

    public static final String DELETE_BUTTON_CLASSNAME = "icon-small-delete";
    public String user;
    public String password;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ProjectDetailsPage projectDetailsPage;
    public ProjectsPage projectsPage;
    public MilestonePage milestonePage;
    public TestRunAndResultsPage testRunAndResultsPage;
    public TestCasesPage testCasesPage;
    public Faker faker;

    @Parameters("browser")
    @BeforeMethod
    @Step("Setting browser configurations")
    public void setup(@Optional("chrome") String browser) {
        Configuration.baseUrl = System.getenv().getOrDefault("TESTRAIL_URL",
                PropertyReader.getProperty("testrail.url"));
        user = System.getenv().getOrDefault("TESTRAIL_USER",
                PropertyReader.getProperty("testrail.user"));
        password = System.getenv().getOrDefault("TESTRAIL_PASSWORD",
                PropertyReader.getProperty("testrail.password"));
        if (browser.equals("chrome")) {
            Configuration.browser = "chrome";
        } else if (browser.equals("opera")) {
            Configuration.browser = "opera";
        }
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        projectDetailsPage = new ProjectDetailsPage();
        projectsPage = new ProjectsPage();
        milestonePage = new MilestonePage();
        testRunAndResultsPage = new TestRunAndResultsPage();
        testCasesPage = new TestCasesPage();
        faker = new Faker();
    }

    @AfterMethod(alwaysRun = true)
    @Step("Close webDriver")
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterSuite
    @Step("Deleting all projects")
    public void deleteAll() {
        loginPage.
                open().
                login(user, password);
        projectsPage.
                open();
        int numberOfProjects = $$(By.className(DELETE_BUTTON_CLASSNAME)).size();
        for (int i = 0; i < numberOfProjects; i++) {
            $(By.className(DELETE_BUTTON_CLASSNAME)).click();
            $x(DELETE_CHECKBOX_XPATH).click();
            $x(CONFIRM_DELETE_XPATH).click();
        }
    }
}
