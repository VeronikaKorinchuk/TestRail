package pages.dashboard;

import com.codeborne.selenide.Condition;
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

    public DashboardPage isPageOpened() {
        $(By.id(DASHBOARD_ID)).shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage createProject(String projectName, String announcement) {
        $(By.id(ADD_PROJECT_ID)).click();
        new Input("name").write(projectName);
        new Input("announcement").write(announcement);
        new Input("suite_mode_single").select();
        $(By.id(ACCEPT_ID)).click();
        return new ProjectPage();
    }

    public ProjectPage openProject(String projectName) {
        $x(String.format(PROJECT_XPATH, projectName)).click();
        return new ProjectPage();
    }
}
