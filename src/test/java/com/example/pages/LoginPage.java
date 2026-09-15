package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver d)  {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register")
     WebElement btnRegister;

    @FindBy(css = "[name=\"username\"]")
     WebElement username;

    @FindBy(css = "[name=\"password\"]")
     WebElement pwd;

    @FindBy(css = "[value=\"Log In\"]")
     WebElement btnLoginIN;

    public void clickSurRegister(){
        btnRegister.click();
    }

    public void connection(String s , String p)
    {
        username.sendKeys(s);
        pwd.sendKeys(p);
    }

    public void btnClick()
    {
        btnLoginIN.click();
    }

}
