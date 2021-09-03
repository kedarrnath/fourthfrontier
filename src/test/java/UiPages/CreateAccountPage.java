package UiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

public class CreateAccountPage {
    public static Logger logger = Logger.getLogger(CreateAccountPage.class.getName());
    WebDriver webDriver;
    @FindBy(css = "header#header div.header_user_info > a")
    WebElement signIn;

    @FindBy(css = "form#create-account_form > h3")
    WebElement createAccount;

    @FindBy(css = "input#email_create")
    WebElement emailAddress;

    @FindBy(css = "button#SubmitCreate > span")
    WebElement createAccountButton;


    @FindBy(css = "form#account-creation_form div:nth-child(1) > h3")
    WebElement personalInformation;
    @FindBy(css = "input#id_gender1")
    WebElement titleMr;
    @FindBy(css = "input#id_gender2")
    WebElement titleMrs;
    @FindBy(css = "input#customer_firstname")
    WebElement customerFirstName;
    @FindBy(css = "input#customer_lastname")
    WebElement customerLastName;
    @FindBy(css = "input#email")
    WebElement emailAddress1;
    @FindBy(css = "input#passwd")
    WebElement password;
    @FindBy(css = "select#days")
    WebElement selectDay;
    @FindBy(css = "select#months")
    WebElement selectMonth;
    @FindBy(css = "select#years")
    WebElement selectYears;
    @FindBy(css = "form#account-creation_form div:nth-child(2) > h3")
    WebElement yourAddress;
    @FindBy(css = "input#firstname")
    WebElement firstName;
    @FindBy(css = "input#lastname")
    WebElement lastName;
    @FindBy(css = "input#company")
    WebElement company;
    @FindBy(css = "input#address1")
    WebElement address;
    @FindBy(css = "input#city")
    WebElement city;
    @FindBy(css = "select#id_state")
    WebElement state;
    @FindBy(css = "input#postcode")
    WebElement zipcode;
    @FindBy(css = "select#id_country")
    WebElement country;
    @FindBy(css = "input#phone_mobile")
    WebElement mobilePhone;
    @FindBy(css = "input#alias")
    WebElement aliasEmail;
    @FindBy(css = "button#submitAccount > span")
    WebElement submit;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/ol/li[1]")
    WebElement errorPhoneMsg;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/ol/li[8]")
    WebElement errorZipcodeMsg;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/ol/li[7]")
    WebElement errorCityMsg;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/ol/li[4]")
    WebElement errorPasswordMsg;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean personalInformation() {
        if (personalInformation.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void setCustomerFirstName(String firstNamename) {
        customerFirstName.sendKeys(firstNamename);
    }

    public void setCustomerLastName(String lastName) {
        customerLastName.sendKeys(lastName);
    }

    public String getEmailAddress() {
        return emailAddress1.getText();
    }

    public void setPassword(String passcode) {
        password.sendKeys(passcode);
    }

    public void setDOB() {
        Select day = new Select(selectDay);
        day.selectByIndex(1);
        Select month = new Select(selectMonth);
        month.selectByIndex(1);
        Select year = new Select(selectYears);
        year.selectByIndex(1);
    }

    public boolean yourAddress() {
        if (yourAddress.isDisplayed()) {
            return true;
        }
        return false;
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public void clickSignIn() {
        signIn.click();
    }

    public boolean createAccountOptionVisible() {
        if (createAccount.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void setSignIn() {
        signIn.click();
        String uuid = UUID.randomUUID().toString();

        emailAddress.sendKeys(uuid + "@gmail.com");
        createAccountButton.click();
    }


    public void setAddress(String address1) {
        address.sendKeys(address1);
    }

    public void setCity(String city1) {
        city.sendKeys(city1);
    }

    public void setState() {
        Select state1 = new Select(state);
        state1.selectByIndex(1);
    }

    public void setZipcode(String zipcode1) {
        zipcode.sendKeys(zipcode1);
    }

    public void setCountry() {
        Select country1 = new Select(country);
        country1.selectByIndex(1);
    }

    public void setMobilePhone(String phonNo) {
        mobilePhone.sendKeys(phonNo);
    }

    public void setAliasEmail(String aliasEmail1) {
        aliasEmail.sendKeys(aliasEmail1);
    }

    public void register() {
        submit.click();
    }

    public String errorPhoneMsg() {
        return errorPhoneMsg.getText();


    }

    public String errorZipcodeMsg() {
        return errorCityMsg.getText();

    }

    public String errorPasswdMsg() {
        return errorPasswordMsg.getText();

    }

}

