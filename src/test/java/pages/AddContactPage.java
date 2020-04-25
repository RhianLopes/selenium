package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {

    public AddContactPage(WebDriver chrome) {
        super(chrome);
    }

    public AddContactPage selectContactType(String contactType) {
        WebElement contacts = chrome.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(contacts).selectByVisibleText(contactType);

        return this;
    }

    public AddContactPage setContact(String contact) {
        chrome.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contact);

        return this;
    }

    public MePage clickSave() {
        chrome.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(chrome);
    }

    public MePage addContact(String contactType, String contact) {
        selectContactType(contactType);
        setContact(contact);
        clickSave();

        return new MePage(chrome);
    }
}
