package pages.dashboard;

import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.dashboard.DashboardPage.ACCEPT_ID;

public class ProjectDetailsPage extends BasePage {

    public static final String EDIT_XPATH = "//*[contains(@class, 'button-edit')]";
    String milestoneId = "navigation-milestones";

    public ProjectDetailsPage editProject(String projectName) {
        $x(EDIT_XPATH).click();
        new Input("name").clear().write(projectName);
        $(By.id(ACCEPT_ID)).click();
      return this;
    }

    public MilestonePage openMilestones() {
        $(By.id(milestoneId)).click();
        return new MilestonePage();
    }
}
