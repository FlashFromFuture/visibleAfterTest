package org.example.visibletest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void visibleAfter() {

        driver.get("https://demoqa.com/dynamic-properties");
        By button = By.cssSelector("#visibleAfter");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        WebElement visibleButton = driver.findElement(By.cssSelector("#visibleAfter"));
        assertTrue(visibleButton.isEnabled(), "Кнопки ещё нет!");

    }

}
