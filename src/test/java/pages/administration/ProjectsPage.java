package pages.administration;

import com.codeborne.selenide.Selenide;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {

    public static final String DELETE_PROJECT_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'hoverSensitive')]//descendant::*[@class='icon-small-delete']";
    public static final String DELETE_CHECKBOX_XPATH = "//*[@class='dialog-confirm']//child::strong";
    public static final String PROJECT_NAMES_XPATH = "//*[contains(@class, 'hoverSensitive')]";

    public ProjectsPage openProjectsPage() {
        Selenide.open("index.php?/admin/projects/overview");
        return this;
    }

    public ProjectsPage deleteProject(String projectName) {
        $x(String.format(DELETE_PROJECT_XPATH, projectName)).click();
        $x(DELETE_CHECKBOX_XPATH).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }

    public String getProjectNames() {
        return $$x(PROJECT_NAMES_XPATH).last().getText();
    }
}
