package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SignTest {

    @Test
    public void doSignInTaskItAndVerify() {

        System.setProperty("webdriver.chrome.driver", "/Users/diego/drivers/chromedriver");

        //Open the Chrome
        WebDriver chrome = new ChromeDriver();

        //Set timeout
        chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Go to url = "http://www.juliodelima.com.br/taskit/"
        chrome.get("http://www.juliodelima.com.br/taskit/");

        //Find element link by text. "Sign in" and click
        chrome.findElement(By.linkText("Sign in")).click();

        //Find element by id "signinbox"
        WebElement webElement = chrome.findElement(By.id("signinbox"));

        //On element "signinbox", find another element by names and set login and password
        webElement.findElement(By.name("login")).sendKeys("julio0001");
        webElement.findElement(By.name("password")).sendKeys("123456");

        //After find element link by text "SIGN IN" and click
        chrome.findElement(By.linkText("SIGN IN")).click();

        //Find element by className = "me" and get text and assertEquals()
        final String hello = chrome.findElement(By.className("me")).getText();
        assertEquals("Hi, Julio", hello);

        //Quit the chrome
        chrome.quit();
    }
}
