package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.*;

public class TestRunAndResultsTest extends BaseTest {

    @Test(description = "Test run can be created")
    public void createTestRun() {
        String project = faker.ancient().primordial();
        String testRun = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage().
                createTestRun(testRun);
        assertEquals(testRunAndResultsPage.getMessage(), "Successfully added the new test run.",
                "You have received a confirmation of test run creation");
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage();
        assertTrue(testRunAndResultsPage.isTestRunVisible(testRun),"Test run is successfully created");
    }

    @Test(description = "Test run can be deleted")
    public void deleteTestRun() {
        String project = faker.ancient().titan();
        String testRun = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage().
                createTestRun(testRun);
        projectDetailsPage.
                openTestRunAndResultsPage().
                deleteTestRun(testRun);
        assertEquals(testRunAndResultsPage.getMessage(), "Successfully deleted the test runs.",
                "You have received a confirmation of test run deletion");
        assertFalse(testRunAndResultsPage.isTestRunVisible(testRun),"Test run is successfully deleted");
    }

    @Test(description = "Test run can be edited")
    public void editTestRun() {
        String project = faker.name().firstName();
        String testRun = faker.food().dish();
        String editedTestRun = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        dashboardPage.
                open().
                openProject(project).
                openTestRunAndResultsPage().
                createTestRun(testRun);
        projectDetailsPage.
                openTestRunAndResultsPage().
                editTestRun(testRun, editedTestRun);
        assertEquals(testRunAndResultsPage.getMessage(), "Successfully updated the test run.",
                "You have received a confirmation of test run edition");
        assertFalse(testRunAndResultsPage.isTestRunVisible(testRun),"Test run is successfully updated");
    }
}
