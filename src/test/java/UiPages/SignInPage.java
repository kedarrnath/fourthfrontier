package UiPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import sun.awt.windows.WBufferStrategy;

import java.util.logging.Logger;

public class SignInPage {

    public static Logger logger = Logger.getLogger(SignInPage.class.getName());
    WebDriver webDriver;

    @FindBy(css = "header#header div.header_user_info > a")
    WebElement signIn;

    @FindBy(css = "form#create-account_form > h3")
    WebElement createAccount;

    @FindBy(css= "input#email_create")
    WebElement emailAddress;

    @FindBy(css ="button#SubmitCreate > span")
    WebElement createAccountButton;

    @FindBy(css = "div#create_account_error li")
    WebElement errorMsg;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signIn.click();
    }

    public boolean createAccountOptionVisible () {
       if(createAccount.isDisplayed())
       {
           return  true;
       }
       return false;
    }

    public void setEmailAddress(String emailAddress1) {
        emailAddress.clear();
        emailAddress.sendKeys(emailAddress1);
    }

    public void clickCreate() {
        createAccountButton.click();
    }

    public String errorMsg()
    {
        return errorMsg.getText();
    }

}
