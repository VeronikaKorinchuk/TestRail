package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class DashboardTest extends BaseTest{

    @Test(description = "Check that project can be created from dashboard")
    public void createProject() {
        String project = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        assertEquals(projectsPage.getMessage(), "Successfully added the new project.");
    }
}
