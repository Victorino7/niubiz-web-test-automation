package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor

    public loginPage(WebDriver browser){
        driver = browser;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,50);
    }

    // Locators

    @FindBy(css = "input#txtEmail")
    private WebElement txtUser;

    @FindBy(css = "input[type=\"password\"]")
    private WebElement txtPassword;

    @FindBy(css = "form.el-form.demo-loginForm button[type=\"button\"]")
    private WebElement btnLogin;

    @FindBy(css = "div[class=\"names\"]")
    private WebElement lblUserName;

    @FindBy(css = "h5[class=\"title-login\"]")
    private WebElement lblWelcome;

    // Actions

    public void writeTxtUser(String user){
        wait.until(ExpectedConditions.elementToBeClickable(txtUser)).sendKeys(user);
    }

    public void writeTxtPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
    }

    public void clickBtnLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

    public String getTextUserName(){
        return wait.until(ExpectedConditions.visibilityOf(lblUserName)).getText();
    }

    public String getTextLblWelcome(){
        return wait.until(ExpectedConditions.visibilityOf(lblWelcome)).getText();
    }



}
