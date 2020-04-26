package selenium;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserInfoPageObjectsTest.csv")
public class UserInfoPageObjectsTest {

    private WebDriver chrome;

    @Before
    public void setUp() {
        chrome = Web.createChrome();
    }

//    @Test
    public void doSignInTaskItAndAddAdditionalInfoAboutUser(@Param(name = "login") String login,
                                                            @Param(name = "password") String password,
                                                            @Param(name = "contactType") String contactType,
                                                            @Param(name = "contact") String contact,
                                                            @Param(name = "expectedMessageToast") String expectedMessageToast) {
        final String resultMessageToast = new LoginPage(chrome)
                .clickSignIn()
                .doLogin(login, password)
                .clickInProfile()
                .clickOnMoreDataAboutYou()
                .clickButtonAddMoreDataAboutYou()
                .addContact(contactType, contact)
                .captureMessageToast();

        assertEquals(expectedMessageToast, resultMessageToast);
    }

    @Test
    public void removeAdditionalDataAboutUser(@Param(name = "login") String login,
                                              @Param(name = "password") String password,
                                              @Param(name = "contact") String contact) {

        final WebElement resultToast = new LoginPage(chrome)
                .clickSignIn()
                .doLogin(login, password)
                .clickInProfile()
                .removeMoreDataAboutYou(contact)
                .captureToast();

        final String resultMessageToast = resultToast.getText();

        WebDriverWait await = new WebDriverWait(chrome, 10);
        await.until(ExpectedConditions.stalenessOf(resultToast));

        assertEquals("Rest in peace, dear phone!", resultMessageToast);
    }

    @After
    public void tearDown() {
        chrome.quit();
    }
}
