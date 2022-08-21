package com.mefias;

import com.mefias.model.AdressInputPage;
import com.mefias.model.DetailsInputPage;
import com.mefias.model.FinalPage;
import com.mefias.model.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    WebDriver driver;

    @Before
    public void createDriver() {
//        В Хроме тест упадёт
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
    }

    @Test
    public void positiveFlowTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton();
        AdressInputPage adressInputPage = new AdressInputPage(driver);
        adressInputPage.fillUserDetails("Тест", "Тест", "Москва", "89999999999");
        DetailsInputPage detailsInputPage = new DetailsInputPage(driver);
        detailsInputPage.fillUserDetails("Test");
        detailsInputPage.confirmOrder();
        detailsInputPage.seeStatus();
        FinalPage finalPage = new FinalPage(driver);
        assertEquals("чёрный жемчуг", finalPage.getColorText());
    }

}
