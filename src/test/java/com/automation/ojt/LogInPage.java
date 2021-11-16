package com.automation.ojt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    @FindBy(xpath = "//input[@data-testid='email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@data-testid='password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-testid='submit']")
    public WebElement loginSubmit;

    @FindBy(xpath = "//h4[@class='text-xl font-bold uppercase'][contains(.,'Pekerjaan Aktif Anda')]")
    public WebElement myJobPage;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
