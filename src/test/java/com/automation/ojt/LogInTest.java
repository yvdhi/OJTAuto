package com.automation.ojt;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class LogInTest {
    private WebDriver driver;
    private LogInPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://kerjain-team1.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void EmployerLogin() {
        loginPage = new LogInPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // input login credential
        loginPage.loginEmail.sendKeys("testemployeer1@email.com");
        loginPage.loginPassword.sendKeys("admin123456789");
        loginPage.loginSubmit.click();

        // verify user success login
        WebElement myJobPage = loginPage.myJobPage;
        assertEquals(myJobPage.getText(), "PEKERJAAN AKTIF ANDA");
    }

    @Test
    public void WorkerLogin() {
        loginPage = new LogInPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // input login credential
        loginPage.loginEmail.sendKeys("iamcaptainnow@email.com");
        loginPage.loginPassword.sendKeys("admin123456789");
        loginPage.loginSubmit.click();

        // verify user success login
        WebElement myJobPage = loginPage.myJobPage;
        assertEquals(myJobPage.getText(), "PEKERJAAN AKTIF ANDA");
    }
}
