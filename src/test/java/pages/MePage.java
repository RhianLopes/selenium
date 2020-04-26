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

    public MePage acceptedRemoveContact() {
        chrome.switchTo().alert().accept();

        return this;
    }

    public MePage declinedRemoveContact() {
        chrome.switchTo().alert().dismiss();

        return this;
    }

    public MePage clickButtonRemoveMoreDataAboutYou(String contact) {
        chrome.findElement(By.xpath("//span[text()=\"" + contact + "\"]/following-sibling::a")).click();

        return this;
    }

    public MePage removeMoreDataAboutYou(String contact) {
        clickOnMoreDataAboutYou();
        clickButtonRemoveMoreDataAboutYou(contact);
        acceptedRemoveContact();

        return this;
    }
}
