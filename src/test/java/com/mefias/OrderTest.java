package com.mefias;

import com.mefias.model.AdressInputPage;
import com.mefias.model.DetailsInputPage;
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        element.click();
        AdressInputPage adressInputPage = new AdressInputPage(driver);
        adressInputPage.fillUserDetails("Тест", "Тест", "Москва", "89999999999");
        DetailsInputPage detailsInputPage = new DetailsInputPage(driver);
        detailsInputPage.fillUserDetails("Test");
        detailsInputPage.confirmOrder();
        detailsInputPage.seeStatus();
        By samokatStatusDiv = By.cssSelector("div.Track_OrderBrick__1qXIA:nth-child(1) > div:nth-child(2) > div:nth-child(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(samokatStatusDiv));
        element = driver.findElement(samokatStatusDiv);
        assertEquals("Самокат на складе", element.getText());
    }

}
