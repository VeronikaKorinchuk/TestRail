package tests.dashboard;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class DashboardTest extends BaseTest{

    @Test(description = "Check that project can be created from dashboard")
    public void createProject() {
        String project = faker.book().title();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        assertEquals(projectsPage.getMessage(), "Successfully added the new project.",
                "You have received a confirmation of project creation");
        assertTrue(projectsPage.isProjectVisible(project), "Project is successfully created");
    }
}
