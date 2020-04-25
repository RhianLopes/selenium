package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome() {

        //Find the chrome driver
        System.setProperty("webdriver.chrome.driver", "/Users/diego/drivers/chromedriver");

        //Open the Chrome
        ChromeDriver chrome = new ChromeDriver();

        //Set timeout
        chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Go to url = "http://www.juliodelima.com.br/taskit/"
        chrome.get("http://www.juliodelima.com.br/taskit/");

        return chrome;
    }
}
