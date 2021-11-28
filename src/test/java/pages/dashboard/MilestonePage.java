package pages.dashboard;

import org.openqa.selenium.By;
import pages.BasePage;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MilestonePage extends BasePage {

    public static final String ADD_MILESTONE_ID = "navigation-milestones-add";
    public static final String ACCEPT_ID = "accept";
    public static final String DELETE_MILESTONE_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'table')]//descendant::*[contains(@class, 'icon-small-delete')]";

    public MilestonePage addMilestone(String milestoneName) {
        $(By.id(ADD_MILESTONE_ID)).click();
        new Input("name").write(milestoneName);
        $(By.id(ACCEPT_ID)).click();
        return this;
    }

    public MilestonePage deleteMilestone(String milestoneName) {
        $x(String.format(DELETE_MILESTONE_XPATH, milestoneName)).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }
}
