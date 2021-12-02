package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class TestCasesTest extends BaseTest {

    @Test(description = "Test case can be created")
    public void createTestCase() {
        String project = faker.book().genre();
        String testCase = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openTestCasesPage().
                addTestCase(testCase);
        assertEquals(testCasesPage.getMessage(), "Successfully added the new test case. Add another");
    }

    @Test(description = "Test case can be deleted")
    public void deleteTestCase() {
        String project = faker.book().genre();
        String testCase = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openTestCasesPage().
                addTestCase(testCase);
        projectDetailsPage.
                openTestCasesPage().
                deleteTestCase(testCase);
        assertEquals(testCasesPage.getMessage(), "");
    }

    @Test(description = "Test case can be edited")
    public void editTestCase() {
        String project = faker.book().genre();
        String testCase = faker.book().genre();
        String editedTestCase = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openTestCasesPage().
                addTestCase(testCase);
        projectDetailsPage.
                openTestCasesPage().
                editTestCase(testCase, editedTestCase);
        assertEquals(testCasesPage.getMessage(), "Successfully updated the test cases.");
    }
}
