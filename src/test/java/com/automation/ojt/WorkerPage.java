package com.automation.ojt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkerPage {
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

    @FindBy(xpath = "//input[@placeholder='Choose a specialty...']")
    public WebElement SpecialtyField;

    @FindBy(xpath = "//input[@placeholder='Choose a specialty...']")
    public WebElement WorkerSpecialty;

    @FindBy(xpath = "//button[contains(.,'Construction')]")
    public WebElement WorkerSpecialtyConstruction;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Painter')]")
    public WebElement WorkerSpecialtyPainter;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Cleaning')]")
    public WebElement WorkerSpecialtyCleaning;

    @FindBy(xpath = "//input[@placeholder='Choose a location...']")
    public WebElement WorkerLocation;

    @FindBy(xpath = "//input[@placeholder='Choose a location...']")
    public WebElement LocationField;

    @FindBy(xpath = "//button[@type='button'][contains(.,'DI Yogyakarta')]")
    public WebElement WorkerLocationSpecific;

    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement WorkerMinAge;

    @FindBy(xpath = "(//input[@type='number'])[2]")
    public WebElement WorkerMaxAge;

    @FindBy(xpath = "//span[@class='ml-2'][contains(.,'Anyone')]")
    public WebElement WorkerGenderAll;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement WorkerGenderAllRadio;

    @FindBy(xpath = "//span[@class='ml-2'][contains(.,'Male')]")
    public WebElement WorkerGenderMale;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement WorkerGenderMaleRadio;

    @FindBy(xpath = "//span[@class='ml-2'][contains(.,'Female')]")
    public WebElement WorkerGenderFemale;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement WorkerGenderFemaleRadio;

    @FindBy(xpath = "(//input[@type='number'])[3]")
    public WebElement WorkerMinRate;

    @FindBy(xpath = "(//input[@type='number'])[4]")
    public WebElement WorkerMaxRate;

    @FindBy(xpath = "//div[contains(@class,'inline-flex gap-2')]")
    public WebElement WorkerRelevance;

    @FindBy(xpath = "(//div[contains(.,'Cheapest')])[12]")
    public WebElement WorkerRelevanceCheapest;

    @FindBy(xpath = "(//div[contains(.,'Expensive')])[12]")
    public WebElement WorkerRelevanceExpensive;

    public WorkerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
