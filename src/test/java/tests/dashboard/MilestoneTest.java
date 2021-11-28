package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class MilestoneTest extends BaseTest {

    @Test(description = "Milestone can be created")
    public void createMilestone() {
        loginPage.
                open().
                login(user, password).
                openProject("Project").
                openMilestones().
                addMilestone("Milestone1");
        assertEquals(milestonePage.getMessage(), "Successfully added the new milestone.");
    }

    @Test(description = "Milestone can be deleted")
    public void deleteMilestone() {
        loginPage.
                open().
                login(user, password).
                openProject("Project").
                openMilestones().
                deleteMilestone("Milestone1");
        assertEquals(milestonePage.getMessage(), "Successfully deleted the milestone (s).");
    }
}
