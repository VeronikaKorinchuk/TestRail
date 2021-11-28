package tests.administration;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest {

    @Test(description = "Check that project can be deleted")
    public void deleteProject() {
        loginPage.
                open().
                login(user, password).
                isPageOpened();
        projectsPage.
                openProjectsPage().
                deleteProject("TestRail");
        assertEquals(projectsPage.getMessage(), "Successfully deleted the project.");
    }
}
