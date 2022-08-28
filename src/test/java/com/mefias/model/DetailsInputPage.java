package com.mefias.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsInputPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By dateField = By.cssSelector(".react-datepicker__input-container > input:nth-child(1)");
    private By dateOption = By.cssSelector(".react-datepicker__day--015");
    private By rentField = By.cssSelector(".Dropdown-control");
    private By rentOption = By.cssSelector("div.Dropdown-option:nth-child(1)");
    private By colorCheckbox = By.xpath("//*[@id=\"black\"]");
    private By comment = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(4) > input:nth-child(1)");
    private By forwardButton = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");
    private By confirmOrderButton = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");
    private By seeStatusButton = By.cssSelector(".Order_NextButton__1_rCA > button:nth-child(1)");

    public DetailsInputPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void setDate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        driver.findElement(dateField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOption));
        driver.findElement(dateOption).click();
    }

    public void setRent() {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }

    public void seeStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeStatusButton));
        driver.findElement(seeStatusButton).click();
    }
}
