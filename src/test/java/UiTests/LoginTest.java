package UiTests;

import SeleniumHelper.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import util.Listener;

import java.io.IOException;
@Listeners(Listener.class)
public class LoginTest  extends SeleniumHelper {

    UiPages.LoginPage loginPage;

    @BeforeClass
    public void setUp() throws IOException {
        init();
        loginPage = new UiPages.LoginPage(webDriver);
        loginPage.clickSignIn();
    }

    @Test
    public void loginPage()
    {
        Assert.assertTrue(loginPage.getLogin());
        Assert.assertTrue(loginPage.getEmailAddress());
        Assert.assertTrue(loginPage.getPassword());
    }
    @Test
    public void testInvalidCredentials()
    {
        loginPage.enterEmailAddress("notexists@gmail.com");
        loginPage.enterPassword("12345");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorIsShown());
    }

    @Test
    public void testLoginWithoutCredentials()
    {
        loginPage.enterEmailAddress("");
        loginPage.enterPassword("12122");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.emptyErrorMsg(),"An email address required.");


        loginPage.enterEmailAddress("tr");
        loginPage.enterPassword("12121212");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.emptyErrorMsg(),"Invalid email address.");
    }
    @Test
    public void testSuccessfulLogin()
    {
        loginPage.enterEmailAddress("moon@gmail.com");
        loginPage.enterPassword("12345");
        loginPage.clickLogin();

        // Assert that user is registered
        Assert.assertEquals(loginPage.getUserName(),"Thomas R");
    }

    @AfterClass
    public void closeAll()
    {
        loginPage.logout();
        webDriver.quit();
    }
}
