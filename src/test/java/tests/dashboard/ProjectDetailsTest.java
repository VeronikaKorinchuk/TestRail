package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class ProjectDetailsTest extends BaseTest {

    @Test(description = "Project can be edited")
    public void editProject() {
        String project = faker.book().title();
        String editedProject = faker.book().title();
        loginPage.
                open().
                login(user, password).
                isPageOpened().createProject(project, "");
        dashboardPage.
                open().
                openProject(project).
                editProject(editedProject);
        assertEquals(projectDetailsPage.getMessage(), "Successfully updated the project.");
    }
}
