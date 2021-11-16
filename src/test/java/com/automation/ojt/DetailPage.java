package com.automation.ojt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage {
    @FindBy(xpath = "//input[@data-testid='email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@data-testid='password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-testid='submit']")
    public WebElement loginSubmit;

    @FindBy(xpath = "//h4[@class='text-lg font-bold uppercase'][contains(.,'Menu Pekerjaan')]")
    public WebElement WorkerMenu;

    @FindBy(xpath = "(//div[contains(.,'Worker Listing')])[6]")
    public WebElement WorkerListing;

    @FindBy(xpath = "(//div[contains(.,'nebula')])[14]")
    public WebElement WorkerSelect;

    @FindBy(xpath = "//span[contains(.,'nebula')]")
    public WebElement WorkerName;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Recruit'])[10]/following::*[name()='svg'][3]")
    public WebElement WorkerDetail;

    public DetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
