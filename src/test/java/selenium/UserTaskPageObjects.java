package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.Web;

public class UserTaskPageObjects {

    private WebDriver chrome;

    @Before
    public void setUp() {
        chrome = Web.createChrome();
    }

    @Test
    public void addUserTask_withSuccess() {

        new LoginPage(chrome)
                .clickSignIn()
                .doLogin("julio0001", "123456")
                .clickInMyTasks()
                .clickButtonToAddNewTask()
                .setTaskTitle("Minha tarefinha marota bolotinha");
    }

    @After
    public void tearDown() {
//        chrome.quit();
    }
}
