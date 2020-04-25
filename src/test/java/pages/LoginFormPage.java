package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

    public LoginFormPage(WebDriver chrome) {
        super(chrome);
    }

    public LoginFormPage setLogin(String login) {
        chrome.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginFormPage setPassword(String password) {
        chrome.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public SecretPage clickSignIn() {
        chrome.findElement(By.linkText("SIGN IN")).click();

        return new SecretPage(chrome);
    }

    public SecretPage doLogin(String login, String password) {
        setLogin(login);
        setPassword(password);
        clickSignIn();

        return new SecretPage(chrome);
    }
}
