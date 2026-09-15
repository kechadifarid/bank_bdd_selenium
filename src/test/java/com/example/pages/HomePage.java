package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver d)  {
        driver = d;
    }
    private By titre = By.className("title");
    private By btnLogOut = By.linkText("Log Out");


    public String getTitre()
    {
        return driver.findElement(titre).getText();
    }
    public void clickLogOUt(){
        driver.findElement(btnLogOut).click();
    }
}
