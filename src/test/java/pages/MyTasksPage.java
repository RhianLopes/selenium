package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyTasksPage extends BasePage {

    public MyTasksPage(WebDriver chrome) {
        super(chrome);
    }

    public AddTaskPage clickButtonToAddNewTask() {
        chrome.findElement(By.xpath("//button[@data-target=\"addtask\"]")).click();

        return new AddTaskPage(chrome);
    }
}
