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

public class WorkerPageTest {
    private WebDriver driver;
    private WorkerPage WorkerPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://kerjain-team1.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // user login
        WorkerPage = new WorkerPage(driver);
        WorkerPage.loginEmail.sendKeys("testemployeer1@email.com");
        WorkerPage.loginPassword.sendKeys("admin123456789");
        WorkerPage.loginSubmit.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void selectConstructionSpecialty() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select construction specialty
        WorkerPage.WorkerSpecialty.sendKeys("Construction");
        WorkerPage.WorkerSpecialtyConstruction.click();
        Thread.sleep(3000);

        // verify construction worker filtered
        WebElement selectedSpecialty = WorkerPage.SpecialtyField;
        assertEquals("Construction", selectedSpecialty.getAttribute("value"));
    }

    @Test
    public void selectPainterSpecialty() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select painter specialty
        WorkerPage.WorkerSpecialty.sendKeys("Painter");
        WorkerPage.WorkerSpecialtyPainter.click();
        Thread.sleep(3000);

        // verify painter worker filtered
        WebElement selectedSpecialty = WorkerPage.SpecialtyField;
        assertEquals("Painter", selectedSpecialty.getAttribute("value"));
    }

    @Test
    public void selectCleaningSpecialty() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select cleaning specialty
        WorkerPage.WorkerSpecialty.sendKeys("Cleaning");
        WorkerPage.WorkerSpecialtyCleaning.click();
        Thread.sleep(3000);

        // verify cleaning worker filtered
        WebElement selectedSpecialty = WorkerPage.SpecialtyField;
        assertEquals("Cleaning", selectedSpecialty.getAttribute("value"));
    }

    @Test
    public void selectWorkerLocation() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select worker location
        WorkerPage.WorkerLocation.sendKeys("yogya");
        WorkerPage.WorkerLocationSpecific.click();
        Thread.sleep(3000);

        // verify location worker filtered
        WebElement selectedLocation = WorkerPage.LocationField;
        assertEquals("DI Yogyakarta", selectedLocation.getAttribute("value"));
    }

    @Test
    public void selectWorkerAge() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }
        Thread.sleep(3000);

        // select worker age
        WorkerPage.WorkerMinAge.sendKeys("25");
        WorkerPage.WorkerMaxAge.clear();
        WorkerPage.WorkerMaxAge.sendKeys("35");

        // verify worker age filtered
        WebElement minAge = WorkerPage.WorkerMinAge;
        assertEquals("25", minAge.getAttribute("value"));

        WebElement maxAge = WorkerPage.WorkerMaxAge;
        assertEquals("35", maxAge.getAttribute("value"));
    }

    @Test
    public void selectMaleWorker() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select worker male
        WorkerPage.WorkerGenderMale.click();
        Thread.sleep(3000);

        // verify male worker filtered
        assertEquals(true, WorkerPage.WorkerGenderMaleRadio.isSelected());
    }

    @Test
    public void selectFemaleWorker() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select worker female
        WorkerPage.WorkerGenderFemale.click();
        Thread.sleep(3000);

        // verify female worker filtered
        assertEquals(true, WorkerPage.WorkerGenderFemaleRadio.isSelected());
    }

    @Test
    public void selectWorkerRate() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select worker rate
        WorkerPage.WorkerMinRate.sendKeys("20");
        WorkerPage.WorkerMaxRate.clear();
        WorkerPage.WorkerMaxRate.sendKeys("500");
        Thread.sleep(3000);

        // verify worker rate filtered
        WebElement minRate = WorkerPage.WorkerMinRate;
        assertEquals("20", minRate.getAttribute("value"));

        WebElement maxRate = WorkerPage.WorkerMaxRate;
        assertEquals("500", maxRate.getAttribute("value"));
    }

    @Test
    public void selectCheapestWorker() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select relevance cheapest
        WorkerPage.WorkerRelevance.click();
        WorkerPage.WorkerRelevanceCheapest.click();
        Thread.sleep(3000);

        // verify cheapest worker filtered
        WebElement Age = WorkerPage.WorkerRelevance;
        assertEquals("Cheapest", Age.getText());
    }

    @Test
    public void selectExpensiveWorker() throws InterruptedException {
        WorkerPage = new WorkerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(WorkerPage.WorkerMenu.isDisplayed()) {
            WorkerPage.WorkerListing.click();
        }

        // select relevance cheapest
        WorkerPage.WorkerRelevance.click();
        WorkerPage.WorkerRelevanceExpensive.click();
        Thread.sleep(3000);

        // verify cheapest worker filtered
        WebElement Age = WorkerPage.WorkerRelevance;
        assertEquals("Expensive", Age.getText());
    }
}
