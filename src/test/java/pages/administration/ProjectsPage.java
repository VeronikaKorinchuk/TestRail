package pages.administration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;
import static pages.dashboard.DashboardPage.ACCEPT_ID;

public class ProjectsPage extends BasePage {

    public static final String MANAGE_PROJECT_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'hoverSensitive')]//descendant::*[@class='icon-small-%s']";
    public static final String DELETE_CHECKBOX_XPATH = "//*[@class='dialog-confirm']//child::strong";

    public ProjectsPage open() {
        Selenide.open("index.php?/admin/projects/overview");
        return this;
    }

    public ProjectsPage editProject(String projectName, String editedProjectName) {
        $x(String.format(MANAGE_PROJECT_XPATH, projectName, "edit")).click();
        new Input("name").clear().write(editedProjectName);
        $(By.id(ACCEPT_ID)).click();
        $x(messageXpath).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage deleteProject(String projectName) {
        $x(String.format(MANAGE_PROJECT_XPATH, projectName, "delete")).click();
        $x(DELETE_CHECKBOX_XPATH).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }
}
