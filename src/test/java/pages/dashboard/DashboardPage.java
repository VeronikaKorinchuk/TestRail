package pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends BasePage {

    public static final String DASHBOARD_ID= "navigation-dashboard";
    public static final String ADD_PROJECT_ID = "sidebar-projects-add";
    public static final String ACCEPT_ID = "accept";
    public static final String PROJECT_XPATH = "//*[contains(@class, 'summary-auto')]//*[contains(@class, " +
            "'summary-title')]//*[contains(text(), '%s')]";

    public DashboardPage open() {
        Selenide.open("index.php?/dashboard");
        return this;
    }

    public DashboardPage isPageOpened() {
        $(By.id(DASHBOARD_ID)).shouldBe(Condition.visible);
        return this;
    }

    public ProjectDetailsPage createProject(String projectName, String announcement) {
        $(By.id(ADD_PROJECT_ID)).click();
        new Input("name").write(projectName);
        new Input("announcement").write(announcement);
        new Input("suite_mode_single").select();
        $(By.id(ACCEPT_ID)).click();
        return new ProjectDetailsPage();
    }

    public ProjectDetailsPage openProject(String projectName) {
        $x(String.format(PROJECT_XPATH, projectName)).click();
        return new ProjectDetailsPage();
    }
}
