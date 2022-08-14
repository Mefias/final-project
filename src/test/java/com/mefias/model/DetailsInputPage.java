package com.mefias.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsInputPage {

    private WebDriver driver;
    private By dateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private By dateOption = By.cssSelector(".react-datepicker__day--015");
    private By rentField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]");
    private By rentOption = By.cssSelector("div.Dropdown-option:nth-child(1)");
    private By colorCheckbox = By.xpath("//*[@id=\"black\"]");
    private By comment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    private By forwardButton = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");
    private By confirmOrderButton = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");
    private By seeStatusButton = By.cssSelector(".Order_NextButton__1_rCA > button:nth-child(1)");

    public DetailsInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        driver.findElement(dateField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOption));
        driver.findElement(dateOption).click();
    }

    public void setRent() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(rentField));
        driver.findElement(rentField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(rentOption));
        driver.findElement(rentOption).click();
    }

    public void setColorCheckbox() {
        driver.findElement(colorCheckbox).click();
    }

    public void setComment(String userComment) {
        driver.findElement(comment).sendKeys(userComment);
    }

    public void clickForwardButton() {
        driver.findElement(forwardButton).click();
    }


    public void fillUserDetails(String userComment) {
        setDate();
        setRent();
        setColorCheckbox();
        setComment(userComment);
        clickForwardButton();
    }

    public void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }

    public void seeStatus() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeStatusButton));
        driver.findElement(seeStatusButton).click();
    }
}
