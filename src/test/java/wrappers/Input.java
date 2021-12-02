package wrappers;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Input {

    String locatorId;

    public Input(String locatorId) {
     this.locatorId = locatorId;
    }

    public Input write(String text) {
        $(By.id(locatorId)).sendKeys(text);
        return this;
    }

    public Input select() {
        $(By.id(locatorId)).click();
        return this;
    }

    public Input clear() {
        $(By.id(locatorId)).clear();
        return this;
    }
}
