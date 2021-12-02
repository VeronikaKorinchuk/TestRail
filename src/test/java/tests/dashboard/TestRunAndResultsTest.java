package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class TestRunAndResultsTest extends BaseTest {

    @Test(description = "Test run can be created")
    public void createTestRun() {
        String project = faker.book().title();
        String testRun = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage().
                addTestRun(testRun);
        assertEquals(testRunAndResultsPage.getMessage(), "Successfully added the new test run.");
    }

    @Test(description = "Test run can be deleted")
    public void deleteTestRun() {
        String project = faker.book().title();
        String testRun = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage().
                addTestRun(testRun);
        projectDetailsPage.
                openTestRunAndResultsPage().
                deleteTestRun(testRun);
        assertEquals(testRunAndResultsPage.getMessage(), "Successfully deleted the test runs.");
    }

    @Test(description = "Test run can be edited")
    public void editTestRun() {
        String project = faker.book().title();
        String testRun = faker.book().genre();
        String editedTestRun = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage().
                addTestRun(testRun);
        projectDetailsPage.
                openTestRunAndResultsPage().
                editTestRun(testRun, editedTestRun);
        assertEquals(testRunAndResultsPage.getMessage(), "Successfully updated the test run.");
    }
}
