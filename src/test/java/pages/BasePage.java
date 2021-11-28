package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    public static final String CONFIRM_DELETE_XPATH = "//*[@id='deleteDialog']//descendant::*[contains(@class, " +
            "'button-ok')]";
    String headerClassName = "header-menu-item-selected";
    String messageXpath = "//*[@id='content-inner']//descendant::*[contains(@class, 'message')]";

    public String getHeader() {
        return $(By.className(headerClassName)).getText();
    }

    public String  getMessage() {
        return $x(messageXpath).getText();
    }
}
