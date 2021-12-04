package pages.dashboard;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;

public class TestCasesPage extends BasePage {

    public static final String ADD_TEST_CASE_ID = "sidebar-cases-add";
    public static final String ACCEPT_ID = "accept";
    public static final String SELECT_TEST_CASE_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'caseRow')]//descendant::*[contains(@class, 'selectionCheckbox')]";
    public static final String EDIT_ID = "editCases";
    public static final String DELETE_ID = "deleteCases";
    public static final String EDIT_SELECTED_ID = "editCasesSelected";
    public static final String CONFIRM_EDITION_ID = "confirmDiffSubmit";
    public static final String CONFIRM_DELETE_XPATH = "//*[@id='casesDeletionDialog']//descendant::*[contains(@class, " +
            "'dialog-action-default')]";

    public TestCasesPage addTestCase(String testCase) {
        $(By.id(ADD_TEST_CASE_ID)).click();
        new Input("title").write(testCase);
        $(By.id(ACCEPT_ID)).click();
        return this;
    }

    public TestCasesPage deleteTestCase(String testCase) {
        $x(String.format(SELECT_TEST_CASE_XPATH, testCase)).click();
        $(By.id(DELETE_ID)).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }

    public TestCasesPage editTestCase(String testCase, String editedTestCase) {
        $x(String.format(SELECT_TEST_CASE_XPATH, testCase)).click();
        $(By.id(EDIT_ID)).click();
        $(By.id(EDIT_SELECTED_ID)).click();
        new Input("title").clear();
        new Input("title").write(editedTestCase);
        $(By.id(ACCEPT_ID)).click();
        $(By.id(CONFIRM_EDITION_ID)).shouldBe(Condition.appear);
        $(By.id(CONFIRM_EDITION_ID)).click();
        $x(messageXpath).shouldBe(Condition.visible);
        return this;
    }
}
