package pages.administration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;
import static pages.dashboard.DashboardPage.ACCEPT_ID;

public class ProjectsPage extends BasePage {

    public static final String MANAGE_PROJECT_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'hoverSensitive')]//descendant::*[@class='icon-small-%s']";
    public static final String DELETE_CHECKBOX_XPATH = "//*[@class='dialog-confirm']//child::strong";
    public static final String PROJECT_LIST_XPATH = "//*[contains(@class, 'hoverSensitive')]/td[1]/a";
    public static final String DELETE_MESSAGE_XPATH = "//*[@id='content-inner']//descendant::*[contains(@class, " +
            "'message-success')]";

    @Step("Opening ProjectsPage")
    public ProjectsPage open() {
        Selenide.open("index.php?/admin/projects/overview");
        return this;
    }

    @Step("Editing project \"{projectName}\" to project \"{editedProjectName}\"")
    public ProjectsPage editProject(String projectName, String editedProjectName) {
        $x(String.format(MANAGE_PROJECT_XPATH, projectName, "edit")).click();
        new Input("name").clear().write(editedProjectName);
        $(By.id(ACCEPT_ID)).click();
        //$x(DELETE_MESSAGE_XPATH).shouldBe(Condition.visible);
        return this;
    }

    @Step("Deleting project \"{projectName}\"")
    public ProjectsPage deleteProject(String projectName) {
        $x(String.format(MANAGE_PROJECT_XPATH, projectName, "delete")).click();
        $x(DELETE_CHECKBOX_XPATH).click();
        $x(CONFIRM_DELETE_XPATH).click();
        $x(MESSAGE_XPATH).shouldBe(Condition.visible);
        return this;
    }

    @Step("Determining is project \"{projectName}\" visible")
    public boolean isProjectVisible (String projectName) {
        WebElement visibleProject = $$x(PROJECT_LIST_XPATH).findBy(Condition.text(projectName));
        return visibleProject.isDisplayed();
    }
}
