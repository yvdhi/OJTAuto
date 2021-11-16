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
    private DetailPage DetailPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://kerjain-team1.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // user login
        DetailPage = new DetailPage(driver);
        DetailPage.loginEmail.sendKeys("testemployeer1@email.com");
        DetailPage.loginPassword.sendKeys("admin123456789");
        DetailPage.loginSubmit.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openWorkerDetail() throws InterruptedException {
        DetailPage = new DetailPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // open worker listing page
        if(DetailPage.WorkerMenu.isDisplayed()) {
            DetailPage.WorkerListing.click();
        }
        Thread.sleep(3000);

        // scroll worker list
         WebElement selectWorker = DetailPage.WorkerSelect;
         Actions a = new Actions(driver);
                a.moveToElement(selectWorker);
                a.perform();

        // open worker detail
        DetailPage.WorkerDetail.click();

        // verify selected worker displayed
        WebElement workerName = DetailPage.WorkerName;
        assertEquals("Nebula", workerName.getText());
    }
}
