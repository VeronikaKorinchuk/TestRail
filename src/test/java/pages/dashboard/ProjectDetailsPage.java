package pages.dashboard;

import org.openqa.selenium.By;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage extends BasePage {

    public static final String NAVIGATION = "navigation-%s";

    public MilestonePage openMilestones() {
        $(By.id(String.format(NAVIGATION, "milestones"))).click();
        return new MilestonePage();
    }

    public TestRunAndResultsPage openTestRunAndResultsPage() {
        $(By.id(String.format(NAVIGATION, "runs"))).click();
        return new TestRunAndResultsPage();
    }

    public TestCasesPage openTestCasesPage() {
        $(By.id(String.format(NAVIGATION, "suites"))).click();
        return new TestCasesPage();
    }
}
