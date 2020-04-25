package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

    public MePage(WebDriver chrome) {
        super(chrome);
    }

    public MePage clickOnMoreDataAboutYou() {
        chrome.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clickButtonAddMoreDataAboutYou() {
        chrome.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new AddContactPage(chrome);
    }
}
