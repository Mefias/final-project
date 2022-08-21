package com.mefias.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private By color = By.cssSelector("div.Track_Row__1sN1F:nth-child(10) > div:nth-child(2)");

    public FinalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getColorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(color));
        WebElement element = driver.findElement(color);
        return element.getText();
    }
}
