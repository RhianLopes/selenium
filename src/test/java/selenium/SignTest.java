package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SignTest {

    private WebDriver chrome;

    @Before
    public void setUp() {

        //Find the chrome driver
        System.setProperty("webdriver.chrome.driver", "/Users/diego/drivers/chromedriver");

        //Open the Chrome
        chrome = new ChromeDriver();

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

        //Click on element link with class "me"
        chrome.findElement(By.className("me")).click();

        //Click on element link with text "MORE DATA ABOUT YOU"
        chrome.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

//    @Test
    public void doSignInTaskItAndAddAdditionalInfoAboutUser() {

        //Click on button with xpath //button[@data-target="addmoredata"]
        chrome.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Get popup form by id = "addmoredata"
        WebElement popupElement = chrome.findElement(By.id("addmoredata"));

        //In combo by name = "type", select the option "Phone"
        WebElement contacts = popupElement.findElement(By.name("type"));
        new Select(contacts).selectByVisibleText("Phone");

        //In element with name = "contact", add "+55911112222"
        popupElement.findElement(By.name("contact")).sendKeys("+55911112222");

        //Click in link with name = "SAVE"
        popupElement.findElement(By.linkText("SAVE")).click();

        //In message toast with id "toast-container" valid message "Your contact has been added!"
        String toastSuccessMessage = chrome.findElement(By.id("toast-container")).getText();

        assertEquals(toastSuccessMessage, "Your contact has been added!");
    }

    @Test
    public void removeAdditionalDataAboutUser() {

        //Click on element with xpath = "//span[text()="+5551986823799"]/following-sibling::a"
        chrome.findElement(By.xpath("//span[text()=\"+5551986823799\"]/following-sibling::a")).click();

        //Confirm the alert js with button = "OK"
        chrome.switchTo().alert().accept();

        //Assert message toast with = "Rest in peace, dear phone!"
        WebElement toastMessage = chrome.findElement(By.id("toast-container"));
        String toastSuccessMessage = toastMessage.getText();
        assertEquals(toastSuccessMessage, "Rest in peace, dear phone!");

        //Await 10 seconds to message toast get out
        WebDriverWait await = new WebDriverWait(chrome, 10);
        await.until(ExpectedConditions.stalenessOf(toastMessage));

        //Click in Logout with text = "Logout"
        chrome.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        //Quit the chrome
//        chrome.quit();
    }
}
