package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SignTest {

    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "/Users/diego/drivers/chromedriver");

        WebDriver chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        chrome.get("http://www.juliodelima.com.br/taskit/");
        chrome.findElement(By.linkText("Sign in")).click();

        chrome.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("julio0001");
        chrome.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");

        chrome.findElement(By.linkText("SIGN IN")).click();

        final String hello = chrome.findElement(By.className("me")).getText();

        assertEquals("Hi, Julio", hello);

        chrome.quit();
    }
}
