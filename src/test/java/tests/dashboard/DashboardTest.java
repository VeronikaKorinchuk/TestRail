package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardTest extends BaseTest{

    @Test(description = "Check that project can be created from dashboard")
    public void createProject() {
        String project = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        assertEquals(projectsPage.getMessage(), "Successfully added the new project.",
                "You have received a confirmation of project creation");
        assertTrue(projectsPage.isProjectVisible(project), "Project is successfully created");
    }
}
