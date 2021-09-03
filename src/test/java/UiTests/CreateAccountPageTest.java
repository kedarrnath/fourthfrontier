package UiTests;

import SeleniumHelper.SeleniumHelper;
import UiPages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.*;
import util.Listener;

import java.io.IOException;
import java.util.Arrays;

@Listeners(Listener.class)
public class CreateAccountPageTest extends SeleniumHelper {
    UiPages.CreateAccountPage createAccountPage;

    @BeforeTest
    public void setUp() throws IOException {
        init();
        createAccountPage = new UiPages.CreateAccountPage(webDriver);
        createAccountPage.setSignIn();
    }

    @Test(priority = 1)
    public void testFieldValidations() {
        createAccountPage.setCity("");
        createAccountPage.setZipcode("");
        createAccountPage.setMobilePhone("");
        createAccountPage.register();

        Assert.assertEquals(createAccountPage.errorPhoneMsg(), "You must register at least one phone number.");
        Assert.assertEquals(createAccountPage.errorZipcodeMsg(), "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        Assert.assertEquals(createAccountPage.errorPasswdMsg(), "passwd is required.");

    }

    @Test (priority = 2)
    public void testCreateAccountWithProperInformation() {

        Assert.assertTrue(createAccountPage.personalInformation());
        createAccountPage.setCustomerFirstName("Thomas");
        createAccountPage.setCustomerLastName("R");

        createAccountPage.setPassword("12345");
        createAccountPage.setAddress("lane 1, 123");
        createAccountPage.setCity("west lake");
        createAccountPage.setState();

        createAccountPage.setZipcode("00000");
        createAccountPage.setCountry();
        createAccountPage.setMobilePhone("712-522-1614");
        createAccountPage.setAliasEmail("alias1@gmail.com");
        createAccountPage.register();
    }

    @AfterClass
    public void close() {
        webDriver.quit();
    }
}
