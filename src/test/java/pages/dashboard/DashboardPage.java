package pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.administration.ProjectsPage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends BasePage {

    public static final String ADD_PROJECT_ID = "sidebar-projects-add";
    public static final String ACCEPT_ID = "accept";
    public static final String PROJECT_XPATH = "//*[contains(@class, 'summary-auto')]//*[contains(@class, " +
            "'summary-title')]//*[contains(text(), '%s')]";

    @Step("Opening DashboardPage")
    public DashboardPage open() {
        Selenide.open("index.php?/dashboard");
        return this;
    }

    @Step("Creating project \"{projectName}\"")
    public ProjectsPage createProject(String projectName) {
        $(By.id(ADD_PROJECT_ID)).click();
        new Input("name").write(projectName);
        new Input("suite_mode_single").select();
        $(By.id(ACCEPT_ID)).click();
        $x(MESSAGE_XPATH).shouldBe(Condition.visible);
        return new ProjectsPage();
    }

    @Step("Opening project \"{projectName}\"")
    public ProjectDetailsPage openProject(String projectName) {
        $x(String.format(PROJECT_XPATH, projectName)).click();
        return new ProjectDetailsPage();
    }
}
