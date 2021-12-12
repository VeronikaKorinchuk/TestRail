package pages.dashboard;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.BasePage;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectDetailsPage extends BasePage {

    public static final String NAVIGATION = "navigation-%s";

    @Step("Opening MilestonePage")
    public MilestonePage openMilestones() {
        $(By.id(String.format(NAVIGATION, "milestones"))).click();
        return new MilestonePage();
    }

    @Step("Opening TestRunAndResultsPage")
    public TestRunAndResultsPage openTestRunAndResultsPage() {
        $(By.id(String.format(NAVIGATION, "runs"))).click();
        return new TestRunAndResultsPage();
    }

    @Step("Opening TestCasesPage")
    public TestCasesPage openTestCasesPage() {
        $(By.id(String.format(NAVIGATION, "suites"))).click();
        return new TestCasesPage();
    }
}
