package com.mefias.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdressInputPage {

    private WebDriver driver;
    private By name = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private By surname = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private By address = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private By station = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    private By stationRok = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]");
    private By phoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private By forward = By.cssSelector(".Button_Middle__1CSJM");


    public AdressInputPage(WebDriver driver) {
        this.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, 3);
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
