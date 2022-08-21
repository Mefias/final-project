package com.mefias;

import com.mefias.model.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;


public class ChromeMainPageTest
{

    WebDriver driver;
    String expected;
    String actual;

    @Before
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void chromeTestQuestions0() {
        testQuestions(0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }

    @Test
    public void chromeTestQuestions1() {
        testQuestions(1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    @Test
    public void chromeTestQuestions2() {
        testQuestions(2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void chromeTestQuestions3() {
        testQuestions(3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void chromeTestQuestions4() {
        testQuestions(4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    @Test
    public void chromeTestQuestions5() {
        testQuestions(5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void chromeTestQuestions6() {
        testQuestions(6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void chromeTestQuestions7() {
        testQuestions(7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    public void testQuestions(Integer sectionNumber, String expectedText) {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.setImportantQuestionsSelectors(sectionNumber);
        actual = mainPage.getImportantQuestionsText();
        expected = expectedText;
        assertEquals(expected, actual);
    }
}
