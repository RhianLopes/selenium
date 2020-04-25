package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.Web;

public class UserInfoPageObjectsTest {

    private WebDriver chrome;

    @Before
    public void setUp() {
        chrome = Web.createChrome();
    }

    @Test
    public void doSignInTaskItAndAddAdditionalInfoAboutUser() {
        new LoginPage(chrome)
                .clickSignIn()
                .doLogin("julio0001", "123456")
                .clickInProfile()
                .clickOnMoreDataAboutYou()
                .clickButtonAddMoreDataAboutYou();
    }

    @After
    public void tearDown() {
        chrome.quit();
    }
}
