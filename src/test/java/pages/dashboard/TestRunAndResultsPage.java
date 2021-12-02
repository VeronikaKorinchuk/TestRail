package pages.dashboard;

import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

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

    public TestRunAndResultsPage addTestRun(String testName) {
        $(By.id(ADD_TEST_RUN_ID)).click();
        new Input("name").clear();
        new Input("name").write(testName);
        $(By.id(ACCEPT_ID)).click();
        return this;
    }

    public TestRunAndResultsPage deleteTestRun(String testRun) {
        $x(String.format(DELETE_TEST_RUN_XPATH, testRun)).click();
        $(By.id(DELETE_BUTTON_ID)).click();
        $(By.id(DELETE_CHECKBOX_ID)).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }

    public TestRunAndResultsPage editTestRun(String testRun, String editedTestRun) {
        $x(String.format(EDIT_TEST_RUN_XPATH, testRun)).click();
        new Input("name").clear();
        new Input("name").write(editedTestRun);
        $(By.id(ACCEPT_ID)).click();
        return this;
    }
}
