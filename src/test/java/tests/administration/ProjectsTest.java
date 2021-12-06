package tests.administration;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.*;

public class ProjectsTest extends BaseTest {

    @Test(description = "Check that project can be deleted")
    public void deleteProject() {
        String project = faker.book().genre();
        loginPage.
                open().
                login(user, password).
                createProject(project);
        projectsPage.
                open().
                deleteProject(project);
        assertEquals(projectsPage.getMessage(), "Successfully deleted the project.",
                "You have received a confirmation of project deletion");
        assertFalse(projectsPage.isProjectVisible(project), "Project is successfully deleted");
    }

    @Test(description = "Project can be edited")
    public void editProject() {
        String project = faker.book().publisher();
        String editedProject = faker.food().dish();
        loginPage.
                open().
                login(user, password).
                createProject(project).
                editProject(project, editedProject);
        assertEquals(projectDetailsPage.getMessage(), "Successfully updated the project.",
                "You have received a confirmation of project edition");
        assertTrue(projectsPage.isProjectVisible(editedProject), "Project is successfully updated");
    }
}
