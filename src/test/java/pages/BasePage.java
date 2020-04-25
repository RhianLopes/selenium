package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class BasePage {

    protected WebDriver chrome;

    public String captureMessageToast() {
        return chrome.findElement(By.id("toast-container")).getText();
    }
}
