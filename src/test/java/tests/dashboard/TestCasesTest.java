package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.*;

public class TestCasesTest extends BaseTest {

    @Test(description = "Test case can be created")
    public void createTestCase() {
        String project = faker.food().vegetable();
        String testCase = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        dashboardPage.
                open().
                openProject(project).
                openTestCasesPage().
                createTestCase(testCase);
        assertEquals(testCasesPage.getMessage(), "Successfully added the new test case. Add another",
                "You have received a confirmation of test case creation");
    }

    @Test(description = "Test case can be deleted")
    public void deleteTestCase() {
        String project = faker.ancient().hero();
        String testCase = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        dashboardPage.
                open().
                openProject(project).
                openTestCasesPage().
                createTestCase(testCase);
        projectDetailsPage.
                openTestCasesPage().
                deleteTestCase(testCase);
        assertFalse(testCasesPage.isTestCaseVisible(testCase), "Test case is successfully deleted");
    }

    @Test(description = "Test case can be edited")
    public void editTestCase() {
        String project = faker.ancient().god();
        String testCase = faker.food().dish();
        String editedTestCase = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        dashboardPage.
                open().
                openProject(project).
                openTestCasesPage().
                createTestCase(testCase);
        projectDetailsPage.
                openTestCasesPage().
                editTestCase(testCase, editedTestCase);
        assertEquals(testCasesPage.getMessage(), "Successfully updated the test cases.");
        assertFalse(testCasesPage.isTestCaseVisible(testCase), "Test case is successfully updated");
    }
}
