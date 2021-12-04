package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class MilestoneTest extends BaseTest {

    @Test(description = "Milestone can be created")
    public void createMilestone() {
        String project = faker.food().dish();
        String milestone = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openMilestones().
                addMilestone(milestone);
        assertEquals(milestonePage.getMessage(), "Successfully added the new milestone.");
    }

    @Test(description = "Milestone can be deleted")
    public void deleteMilestone() {
        String project = faker.food().dish();
        String milestone = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openMilestones().
                addMilestone(milestone);
        projectDetailsPage.openMilestones().
                deleteMilestone(milestone);
        assertEquals(milestonePage.getMessage(), "Successfully deleted the milestone (s).");
    }

    @Test(description = "Milestone can be edited")
    public void editMilestone() {
        String project = faker.food().dish();
        String milestone = faker.food().dish();
        String editedMilestone = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                openMilestones().
                addMilestone(milestone);
        projectDetailsPage.
                openMilestones().
                editMilestone(milestone, editedMilestone);
        assertEquals(milestonePage.getMessage(), "Successfully updated the milestone.");
    }
}
