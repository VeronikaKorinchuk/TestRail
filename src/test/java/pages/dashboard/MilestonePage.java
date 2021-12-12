package pages.dashboard;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class MilestonePage extends BasePage {

    public static final String ADD_MILESTONE_ID = "navigation-milestones-add";
    public static final String ACCEPT_ID = "accept";
    public static final String DELETE_MILESTONE_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'table')]//descendant::*[contains(@class, 'icon-small-delete')]";
    public static final String EDIT_MILESTONE_XPATH = "//*[contains(text(), '%s')]//ancestor::*[contains(@class, " +
            "'table')]//descendant::*[contains(text(), 'Edit')]";
    public static final String MILESTONE_LIST_XPATH = "//*[contains(@class, 'summary-title')]";


    @Step("Adding milestone project \"{milestoneName}\"")
    public MilestonePage addMilestone(String milestoneName) {
        $(By.id(ADD_MILESTONE_ID)).click();
        new Input("name").write(milestoneName);
        $(By.id(ACCEPT_ID)).click();
        return this;
    }

    @Step("Deleting milestone project \"{milestoneName}\"")
    public MilestonePage deleteMilestone(String milestoneName) {
        $x(String.format(DELETE_MILESTONE_XPATH, milestoneName)).click();
        $x(CONFIRM_DELETE_XPATH).click();
        return this;
    }

    @Step("Editing milestone project \"{milestoneName}\" to \"{editedMilestoneName}\"")
    public MilestonePage editMilestone(String milestoneName, String editedMilestoneName) {
        $x(String.format(EDIT_MILESTONE_XPATH, milestoneName)).click();
        new Input("name").clear();
        new Input("name").write(editedMilestoneName);
        $(By.id(ACCEPT_ID)).click();
        $(By.id(ACCEPT_ID)).shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Determining is milestone \"{milestoneName}\" visible")
    public boolean isMilestoneVisible (String milestoneName) {
        WebElement visibleMilestone = $$x(MILESTONE_LIST_XPATH).findBy(Condition.text(milestoneName));
        return visibleMilestone.isDisplayed();
    }
}
