package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class ProjectDetailsTest extends BaseTest {

    @Test(description = "Project can be edited")
    public void editProject() {
        loginPage.
                open().
                login(user, password).
                isPageOpened().
                openProject("ThisTest").
                editProject("Test");
        assertEquals(projectDetailsPage.getMessage(), "Successfully updated the project.");
    }
}
