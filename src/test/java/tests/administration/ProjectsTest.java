package tests.administration;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest {

    @Test(description = "Check that project can be deleted")
    public void deleteProject() {
        String project = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "");
        projectsPage.
                open().
                deleteProject(project);
        assertEquals(projectsPage.getMessage(), "Successfully deleted the project.");
    }

    @Test(description = "Project can be edited")
    public void editProject() {
        String project = faker.book().genre();
        String editedProject = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project, "").
                editProject(project, editedProject);
        assertEquals(projectDetailsPage.getMessage(), "Successfully updated the project.");
    }
}
