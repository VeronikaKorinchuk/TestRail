package pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {

    public static final String DASHBOARD_ID= "navigation-dashboard";
    public static final String ADDPROJECT_ID = "sidebar-projects-add";

    public DashboardPage open() {
        Selenide.open("index.php?/dashboard");
        return this;
    }

    public DashboardPage isPageOpened() {
        $(By.id(DASHBOARD_ID)).shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage createProject() {
        $(By.id(ADDPROJECT_ID)).click();
        return new ProjectPage();
    }
}
