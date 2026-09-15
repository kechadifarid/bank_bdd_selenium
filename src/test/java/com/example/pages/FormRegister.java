package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormRegister {
    WebDriver driver;
    public FormRegister(WebDriver d)  {
        driver = d;
    }
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By zip = By.id("customer.address.zipCode");

    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By pwd = By.id("customer.password");
    private By pwdConfirmation = By.id("repeatedPassword");
private By btnRegister = By.cssSelector("[value=\"Register\"]");
    public void remplirFormulaire(String fname , String lname ,String add , String zipCOde , String city , String state , String phone , String ssn , String username , String pwd )
    {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(zip).sendKeys(zipCOde);

        driver.findElement(address).sendKeys(add);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.state).sendKeys(state);
        driver.findElement(this.phone).sendKeys(phone);
        driver.findElement(this.ssn).sendKeys(ssn);
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.pwd).sendKeys(pwd);
        driver.findElement(this.pwdConfirmation).sendKeys(pwd);
        driver.findElement(btnRegister).click();
        


        
    }
}
