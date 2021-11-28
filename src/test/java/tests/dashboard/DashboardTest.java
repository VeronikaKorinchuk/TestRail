package tests.dashboard;

import org.testng.annotations.Test;
import tests.BaseTest;
import static org.testng.Assert.assertEquals;

public class DashboardTest extends BaseTest{

    @Test(description = "Check that project can be created")
    public void createProject() {
        loginPage.
                open().
                login(user, password).
                isPageOpened().
                createProject("TestRail", "This is diploma project");
        assertEquals(projectsPage.getProjectNames(), "TestRail");
    }
}
