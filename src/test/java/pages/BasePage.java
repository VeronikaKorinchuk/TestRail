package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    String headerClassName = "header-menu-item-selected";

    public String getHeader() {
        return $(By.className(headerClassName)).getText();
    }
}
