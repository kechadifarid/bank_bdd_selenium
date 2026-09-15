package com.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.example.pages.FormRegister;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;

public class StepDefinitions {
    //preparation jdd 
    //Faker faker = new Faker();
    double randomnumber = Math.floor(Math.random()*1000);
    String firstname = "faridkechadi";
    String lastname = "faridk";
    String username = "farb"+randomnumber;
    String pwd = "faridkec"+randomnumber;

    WebDriver driver;
    LoginPage lp ;
    FormRegister fr;
    HomePage hp;
    @Before 
    public void setup(){
        URL gridUrl = null;
         try {
            gridUrl = new URL("http://selenium-hub:4444/wd/hub");
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
         ChromeOptions co = new ChromeOptions();
         driver = new RemoteWebDriver(gridUrl, co);
        lp = new LoginPage(driver);
        fr = new FormRegister(driver);
        hp = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After 
    public void teardown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
     

    @Given("je suis sur le site {string}")
    public void je_suis_sur_le_site(String s) {
        driver.get(s);
    }

    @Given("je clique sur le button register")
    public void je_clique_sur_le_button_register() {
        lp.clickSurRegister();
    }

    @Given("je suis sur le lien d inscription")
    public void je_suis_sur_le_lien_d_inscription() {
        assertTrue(driver.getCurrentUrl().contains("register.htm"));
    }

    @When("je rempli le formulaire")
    public void je_rempli_le_formulaire() {
        fr.remplirFormulaire(firstname,lastname,"1 rue de paris","75000","paris","idf","0602020202","745154684",username,pwd);
    }

    @Then("je verifie que le username s affiche bien")
    public void je_verifie_que_le_username_s_affiche_bien() throws InterruptedException {
        assertTrue(hp.getTitre().contains(username));
        
    }
    
    @Then("je me deconnecte")
    public void je_me_deconnecte() {
        hp.clickLogOUt();
    }

    @When("je clique sur le button de connexion")
    public void je_clique_sur_le_button_de_connexion() {
    lp.btnClick();
    }    
    @Then("je verifie si je suis bien sur le bon url")
    public void je_verifie_si_je_suis_bien_sur_le_bon_url() {
    assertTrue(hp.getTitre().contains("Accounts Overview"));
    }

    @Given("je rempli les information de connexion")
    public void je_rempli_les_information_de_connexion_username_et_pwd() {
        lp.connection(username,pwd);
    }

}



