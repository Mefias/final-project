package com.mefias.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private By importantQuestions;
    private By importantQuestionsText;
    private final By topOrderButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");
    private final By middleOrderButton = By.cssSelector(".Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void setImportantQuestionsSelectors(int sectionNumber) {
        String importantQuestionsSelector = "#accordion__heading-" + sectionNumber;
        this.importantQuestions = By.cssSelector(importantQuestionsSelector);
        String importantQuestionsTextSelector = "//*[@id=\"accordion__panel-" + sectionNumber + "\"]/p";
        this.importantQuestionsText = By.xpath(importantQuestionsTextSelector);
    }

    public String getImportantQuestionsText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(importantQuestions));
        WebElement element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(importantQuestions));
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(importantQuestionsText));
        return driver.findElement(importantQuestionsText).getText();
    }

    public void clickTopOrderButton() {
        WebElement element = driver.findElement(topOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(topOrderButton));
        element.click();
    }

    public void clickMiddleOrderButton() {
        WebElement element = driver.findElement(middleOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(middleOrderButton));
        element.click();
    }

}
