package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class BasePage {

    public static final String CONFIRM_DELETE_XPATH = "//*[@id='deleteDialog']//descendant::*[contains(@class, " +
            "'button-ok')]";
    public static final String HEADER_CLASSNAME = "header-menu-item-selected";
    public static final String MESSAGE_XPATH = "//*[@id='content-inner']//descendant::*[contains(@class, 'message')]";

    @Step("Getting header")
    public String getHeader() {
        return $(By.className(HEADER_CLASSNAME)).getText();
    }

    @Step("Getting message")
    public String  getMessage() {
        return $x(MESSAGE_XPATH).getText();
    }
}
