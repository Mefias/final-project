package com.mefias;

import org.junit.After;
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


public class FirefoxMainPageTest
{

    WebDriver driver;
    String expected;
    String actual;

    @Before
    public void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
    }

    @Test
    public void firefoxTestQuestions0() {
        testQuestions("#accordion__heading-0", "//*[@id=\"accordion__panel-0\"]/p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }

    @Test
    public void firefoxTestQuestions1() {
        testQuestions("#accordion__heading-1", "//*[@id=\"accordion__panel-1\"]/p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    @Test
    public void firefoxTestQuestions2() {
        testQuestions("#accordion__heading-2", "//*[@id=\"accordion__panel-2\"]/p", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void firefoxTestQuestions3() {
        testQuestions("#accordion__heading-3", "//*[@id=\"accordion__panel-3\"]/p", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void firefoxTestQuestions4() {
        testQuestions("#accordion__heading-4", "//*[@id=\"accordion__panel-4\"]/p", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    @Test
    public void firefoxTestQuestions5() {
        testQuestions("#accordion__heading-5", "//*[@id=\"accordion__panel-5\"]/p", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void firefoxTestQuestions6() {
        testQuestions("#accordion__heading-6", "//*[@id=\"accordion__panel-6\"]/p", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void firefoxTestQuestions7() {
        testQuestions("#accordion__heading-7", "//*[@id=\"accordion__panel-7\"]/p", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

    public void testQuestions(String cssLocator, String xPathLocator, String expectedText) {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssLocator)));
        WebElement element = driver.findElement(By.cssSelector(cssLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
        WebElement elementP = driver.findElement(By.xpath(xPathLocator));
        actual = elementP.getText();
        expected = expectedText;
        assertEquals(expected, actual);
    }
}
