package UiTests;

import SeleniumHelper.SeleniumHelper;

import org.testng.Assert;
import org.testng.annotations.*;
import util.Listener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class SignInPageTest extends SeleniumHelper {

    UiPages.SignInPage signInPage;

    @BeforeClass
    public void setUp() throws IOException {
        init();
        signInPage = new UiPages.SignInPage(webDriver);
        signInPage.clickSignIn();
    }

    @Test
    public void testWithExistingEmail() {
        signInPage.setEmailAddress("moon@gmail.com");
        signInPage.clickCreate();
        Assert.assertEquals(signInPage.errorMsg(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }

    @Test
    public void testWithEmptyEmail() {
        signInPage.setEmailAddress("");
        signInPage.clickCreate();
        Assert.assertEquals(signInPage.errorMsg(), "Invalid email address.");

    }

    @Test
    public void testWithProperData() {
        Assert.assertEquals(signInPage.createAccountOptionVisible(), true);
        signInPage.setEmailAddress("email1@gmail.com");
        signInPage.clickSignIn();
    }

    @AfterClass
    public void close() {
        webDriver.quit();
    }
}
