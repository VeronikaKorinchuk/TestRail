package pages.dashboard;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestRunAndResultsPage extends BasePage {

    public static final String ADD_TEST_RUN_ID = "navigation-runs-add";
    public static final String ACCEPT_ID = "accept";
    public static final String DELETE_TEST_RUN_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'table')]//descendant::*[@name='entity_run']";
    public static final String DELETE_BUTTON_ID = "delete-run";
    public static final String DELETE_CHECKBOX_ID = "confirm-check";
    public static final String CONFIRM_DELETE_XPATH = "//*[@id='bulkDeleteDialog']//*[contains(@class, " +
            "'dialog-action-default')]";
    public static final String EDIT_TEST_RUN_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'table')]//descendant::*[contains(text(), 'Edit')]";
    public static final String TEST_RUN_LIST_XPATH = "//*[contains(@class, 'summary-title')]";

    @Step("Creating test run \"{testName}\"")
    public TestRunAndResultsPage createTestRun(String testName) {
        $(By.id(ADD_TEST_RUN_ID)).click();
        new Input("name").clear();
        new Input("name").write(testName);
        $(By.id(ACCEPT_ID)).click();
        $x(MESSAGE_XPATH).shouldBe(Condition.visible);
        return this;
    }

    @Step("Deleting test run \"{testRun}\"")
    public TestRunAndResultsPage deleteTestRun(String testRun) {
        $x(String.format(DELETE_TEST_RUN_XPATH, testRun)).click();
        $(By.id(DELETE_BUTTON_ID)).click();
        $(By.id(DELETE_CHECKBOX_ID)).click();
        $x(CONFIRM_DELETE_XPATH).click();
        $x(MESSAGE_XPATH).shouldBe(Condition.visible);
        return this;
    }

    @Step("Editing test run \"{testRun}\" to \"{editedTestRun}\"")
    public TestRunAndResultsPage editTestRun(String testRun, String editedTestRun) {
        $x(String.format(EDIT_TEST_RUN_XPATH, testRun)).click();
        new Input("name").clear();
        new Input("name").write(editedTestRun);
        $(By.id(ACCEPT_ID)).click();
        $x(MESSAGE_XPATH).shouldBe(Condition.visible);
        return this;
    }

    @Step("Determining is test run \"{testRunName}\" visible")
    public boolean isTestRunVisible (String testRunName) {
        WebElement visibleTestRun = $$x(TEST_RUN_LIST_XPATH).findBy(Condition.text(testRunName));
        return visibleTestRun.isDisplayed();
    }
}
