package pages.administration;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;
import static pages.dashboard.DashboardPage.ACCEPT_ID;

public class ProjectsPage extends BasePage {

    public static final String EDIT_PROJECT_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'hoverSensitive')]//descendant::*[@class='icon-small-edit']";
    public static final String DELETE_PROJECT_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'hoverSensitive')]//descendant::*[@class='icon-small-delete']";
    public static final String DELETE_CHECKBOX_XPATH = "//*[@class='dialog-confirm']//child::strong";

    public ProjectsPage open() {
        Selenide.open("index.php?/admin/projects/overview");
        return this;
    }

    public ProjectsPage editProject(String projectName, String editedProjectName) {
        $x(String.format(EDIT_PROJECT_XPATH, projectName)).click();
        new Input("name").clear().write(editedProjectName);
        $(By.id(ACCEPT_ID)).click();
        return this;
    }

    public ProjectsPage deleteProject(String projectName) {
        $x(String.format(DELETE_PROJECT_XPATH, projectName)).click();
        $x(DELETE_CHECKBOX_XPATH).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }
}
