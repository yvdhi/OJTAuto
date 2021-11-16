package com.automation.ojt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class DetailPageTest {
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
    public void openWorkerDetail() throws InterruptedException {
        PageObject = new PageObject(driver);

        // open worker listing page
        if(PageObject.WorkerMenu.isDisplayed()) {
            PageObject.WorkerListing.click();
        }
        Thread.sleep(3000);

        // scroll worker list
         WebElement selectWorker = PageObject.WorkerSelect;
         Actions a = new Actions(driver);
                a.moveToElement(selectWorker);
                a.perform();

        // open worker detail
        PageObject.WorkerDetail.click();

        // verify selected worker displayed
        WebElement workerName = PageObject.WorkerName;
        assertEquals("Nebula", workerName.getText());
    }
}
