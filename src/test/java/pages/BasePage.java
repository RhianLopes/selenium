package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class BasePage {

    protected WebDriver chrome;

    public String captureMessageToast() {
        return chrome.findElement(By.id("toast-container")).getText();
    }

    public WebElement captureToast() {
        return chrome.findElement(By.id("toast-container"));
    }
}
