package com.automation.ojt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WorkerPageTest {
    private WebDriver driver;
    private PageObject PageObject;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kerjain-team1.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // user login
        PageObject = new PageObject(driver);
        PageObject.loginEmail.sendKeys("testemployeer1@email.com");
        PageObject.loginPassword.sendKeys("admin123456789");
        PageObject.loginSubmit.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void selectConstructionSpecialty() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select construction specialty
        PageObject.WorkerSpecialty.sendKeys("Construction");
        PageObject.WorkerSpecialtyConstruction.click();
        Thread.sleep(3000);

        // verify construction worker filtered
        WebElement selectedSpecialty = PageObject.SpecialtyField;
        assertEquals("Construction", selectedSpecialty.getAttribute("value"));
    }

    @Test
    public void selectPainterSpecialty() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select painter specialty
        PageObject.WorkerSpecialty.sendKeys("Painter");
        PageObject.WorkerSpecialtyPainter.click();
        Thread.sleep(3000);

        // verify painter worker filtered
        WebElement selectedSpecialty = PageObject.SpecialtyField;
        assertEquals("Painter", selectedSpecialty.getAttribute("value"));
    }

    @Test
    public void selectCleaningSpecialty() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select cleaning specialty
        PageObject.WorkerSpecialty.sendKeys("Cleaning");
        PageObject.WorkerSpecialtyCleaning.click();
        Thread.sleep(3000);

        // verify cleaning worker filtered
        WebElement selectedSpecialty = PageObject.SpecialtyField;
        assertEquals("Cleaning", selectedSpecialty.getAttribute("value"));
    }

    @Test
    public void selectWorkerLocation() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select worker location
        PageObject.WorkerLocation.sendKeys("yogya");
        PageObject.WorkerLocationSpecific.click();
        Thread.sleep(3000);

        // verify location worker filtered
        WebElement selectedLocation = PageObject.LocationField;
        assertEquals("DI Yogyakarta", selectedLocation.getAttribute("value"));
    }

    @Test
    public void selectWorkerAge() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }
        Thread.sleep(3000);

        // select worker age
        PageObject.WorkerMinAge.sendKeys("25");
        PageObject.WorkerMaxAge.clear();
        PageObject.WorkerMaxAge.sendKeys("35");

        // verify worker age filtered
        WebElement minAge = PageObject.WorkerMinAge;
        assertEquals("25", minAge.getAttribute("value"));

        WebElement maxAge = PageObject.WorkerMaxAge;
        assertEquals("35", maxAge.getAttribute("value"));
    }

    @Test
    public void selectMaleWorker() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select worker male
        PageObject.WorkerGenderMale.click();
        Thread.sleep(3000);

        // verify male worker filtered
        assertTrue(PageObject.WorkerGenderMaleRadio.isSelected());
    }

    @Test
    public void selectFemaleWorker() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select worker female
        PageObject.WorkerGenderFemale.click();
        Thread.sleep(3000);

        // verify female worker filtered
        assertTrue(PageObject.WorkerGenderFemaleRadio.isSelected());
    }

    @Test
    public void selectWorkerRate() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select worker rate
        PageObject.WorkerMinRate.sendKeys("20");
        PageObject.WorkerMaxRate.clear();
        PageObject.WorkerMaxRate.sendKeys("500");
        Thread.sleep(3000);

        // verify worker rate filtered
        WebElement minRate = PageObject.WorkerMinRate;
        assertEquals("20", minRate.getAttribute("value"));

        WebElement maxRate = PageObject.WorkerMaxRate;
        assertEquals("500", maxRate.getAttribute("value"));
    }

    @Test
    public void selectCheapestWorker() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select relevance cheapest
        PageObject.WorkerRelevance.click();
        PageObject.WorkerRelevanceCheapest.click();
        Thread.sleep(3000);

        // verify cheapest worker filtered
        WebElement Age = PageObject.WorkerRelevance;
        assertEquals("Cheapest", Age.getText());
    }

    @Test
    public void selectExpensiveWorker() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }

        // select relevance cheapest
        PageObject.WorkerRelevance.click();
        PageObject.WorkerRelevanceExpensive.click();
        Thread.sleep(3000);

        // verify cheapest worker filtered
        WebElement Age = PageObject.WorkerRelevance;
        assertEquals("Expensive", Age.getText());
    }
}
