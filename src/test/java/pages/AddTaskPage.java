package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddTaskPage extends BasePage {

    public AddTaskPage(WebDriver chrome) {
        super(chrome);
    }

    public AddTaskPage setTaskTitle(String taskTitle) {
        chrome.findElement(By.name("title")).sendKeys(taskTitle);

        return this;
    }
}