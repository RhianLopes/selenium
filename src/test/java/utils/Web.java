package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String USERNAME = "Your Username!";
    public static final String AUTOMATE_KEY = "Your Automate Key!";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

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

    public static WebDriver createBrowserStack() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "81.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriver chrome = null;
        try {
            chrome = new RemoteWebDriver(new URL(URL), caps);
            chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            chrome.get("http://www.juliodelima.com.br/taskit/");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return chrome;
    }
}
