package tests.administration;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest {

    @Test(description = "Check that project can be deleted")
    public void deleteProject() {
        String project = faker.book().title();
        loginPage.
                open().
                login(user, password).
                isPageOpened().createProject(project, "");
        projectsPage.
                openProjectsPage().
                deleteProject(project);
        assertEquals(projectsPage.getMessage(), "Successfully deleted the project.");
    }
}
