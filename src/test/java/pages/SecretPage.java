package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage {

    public SecretPage(WebDriver chrome) {
        super(chrome);
    }

    public MePage clickInProfile() {
        chrome.findElement(By.className("me")).click();

        return new MePage(chrome);
    }
}
