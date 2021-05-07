package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor

    public homePage(WebDriver browser){
        driver = browser;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,50);
    }

    // Locators

    @FindBy(css = "div[class=\"el-icon-more\"]")
    private WebElement btnMoreOptions;

    @FindBy(css = "li[class=\"el-submenu__item\"]")
    private WebElement btnOptionLogOut;

    @FindBy(css = "button[class=\"el-button el-button--default el-button--small el-button--primary \"]")
    private WebElement btnAcceptToLogOut;

    // Actions

    public void clickBtnMoreOptions(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMoreOptions)).click();
    }

    public void clickBtnOptionLogOut(){
        wait.until(ExpectedConditions.elementToBeClickable(btnOptionLogOut)).click();
    }

    public void clickBtnAcceptToLogOut(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAcceptToLogOut)).click();
    }




}
