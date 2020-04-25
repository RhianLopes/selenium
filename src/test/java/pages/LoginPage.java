package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver chrome) {
        super(chrome);
    }

    public LoginFormPage clickSignIn() {
        chrome.findElement(By.linkText("Sign in")).click();

        return new LoginFormPage(chrome);
    }
}
