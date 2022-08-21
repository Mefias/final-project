package com.mefias.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdressInputPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By name = By.cssSelector(".Order_Form__17u6u > div:nth-child(1) > input:nth-child(1)");
    private By surname = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(2) > input:nth-child(1)");
    private By address = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(3) > input:nth-child(1)");
    private By station = By.cssSelector(".select-search__input");
    private By stationRok = By.cssSelector("li.select-search__row:nth-child(1) > button:nth-child(1)");
    private By phoneNumber = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(5) > input:nth-child(1)");
    private By forward = By.cssSelector(".Button_Middle__1CSJM");


    public AdressInputPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void setName(String username) {
        driver.findElement(name).sendKeys(username);
    }

    public void setSurname(String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }

    public void setAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    public void setStation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(station));
        wait.until(ExpectedConditions.elementToBeClickable(station));
        driver.findElement(station).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(stationRok));
        wait.until(ExpectedConditions.elementToBeClickable(stationRok));
        driver.findElement(stationRok).click();
    }

    public void setPhoneNumber(String userPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
    }

    public void clickForwardButton() {
        driver.findElement(forward).click();
    }


    public void fillUserDetails(String username, String userSurname, String userAddress, String userPhoneNumber) {
        setName(username);
        setSurname(userSurname);
        setAddress(userAddress);
        setStation();
        setPhoneNumber(userPhoneNumber);
        clickForwardButton();
    }
}
