package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;

import org.testng.Assert;
import pageobjects.loginPage;
import pageobjects.homePage;

public class loginSteps {

    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^que me encuentro en la pagina de Niubiz$")
    public void me_encuentro_en_la_pagina_de_niubiz() throws Throwable{
        driver.manage().window().maximize();
        driver.get("https://omni-web-qa.apps.vntapp.com/");
    }

    @When("^ingreso \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingreso_user_y_password(String user, String password) throws Throwable {
        loginPage elementos1 = new loginPage(driver);
        elementos1.writeTxtUser(user);
        elementos1.writeTxtPassword(password);
    }

    @And("^selecciono el boton de ingresar$")
    public void selecciono_el_boton_de_ingresar() throws Throwable{
        loginPage elementos1 = new loginPage(driver);
        elementos1.clickBtnLogin();
    }

    @Then("^verifico que al ingresar se muestre el \"([^\"]*)\"$")
    public void verifico_que_al_ingresar_se_muestre_el_nickname(String nickname) throws Throwable{
        loginPage elementos1 = new loginPage(driver);
        String valueObtened = elementos1.getTextUserName();
        String valueExpected = nickname;
        Assert.assertEquals(valueObtened,valueExpected,"Los resultados no son iguales");
    }

    @And("^selecciono la opcion para cerrar sesion$")
    public void selecciono_la_opcion_para_cerrar_sesion() throws Throwable{
        homePage elementos1 = new homePage(driver);
        elementos1.clickBtnMoreOptions();
        elementos1.clickBtnOptionLogOut();
        elementos1.clickBtnAcceptToLogOut();
    }

    @Then("^verifico que al salir muestre el Login$")
    public void verifico_que_al_salir_muestre_el_login() throws Throwable{
        loginPage elementos1 = new loginPage(driver);
        String valueObtened = elementos1.getTextLblWelcome();
        String valueExpected = "¡Bienvenido!";
        Assert.assertEquals(valueObtened,valueExpected,"Los resultados no son iguales");
    }

    @After
    public void tearDown() throws Throwable{
        driver.quit();
    }

}
