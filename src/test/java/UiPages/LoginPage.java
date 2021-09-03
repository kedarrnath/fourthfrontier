package UiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginPage {
    public static Logger logger = Logger.getLogger(LoginPage.class.getName());
    WebDriver webDriver;
    @FindBy(css = "header#header div.header_user_info > a")
    WebElement signIn;

    @FindBy(css = "input#email")
    WebElement emailAddress;

    @FindBy(css = "input#passwd")
    WebElement password;

    @FindBy(css = "button#SubmitLogin > span")
    WebElement login;

    @FindBy(css = "header#header nav > div:nth-child(1) > a > span")
    WebElement userName;

    @FindBy(css = "div#center_column > div.alert.alert-danger")
    WebElement loginErrorMsg;

    @FindBy(css = "div#center_column li")
    WebElement emptyErrorMsg;

    @FindBy(css ="header#header div:nth-child(2) > a")
    WebElement logout;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean loginErrorIsShown()
    {
       return   loginErrorMsg.isDisplayed();
    }
    public void clickSignIn()
    {
        signIn.click();
    }

    public void enterEmailAddress(String emailAddress1) {
        emailAddress.clear();
        emailAddress.sendKeys(emailAddress1);
    }

    public void enterPassword(String password1) {
        password.clear();
        password.sendKeys(password1);
    }

    public String emptyErrorMsg()
    {
        return emptyErrorMsg.getText();
    }
    public void clickLogin() {
        login.click();
    }

    public boolean getEmailAddress() {
        if(emailAddress.isDisplayed())
        {
            return true;
        }
        return false;
    }

    public boolean getPassword(){
        if(password.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean getLogin() {
        if(login.isDisplayed())
        {
            return true;
        }
        return false;
    }
    public String getUserName()
    {
        return userName.getText();
    }
    public void logout()
    {
        logout.click();
    }

}
