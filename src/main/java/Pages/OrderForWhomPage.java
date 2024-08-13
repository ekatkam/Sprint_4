package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderForWhomPage extends BasePage {

    //Локаторы
    //Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Телефон
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    //Конструктор
    public OrderForWhomPage(WebDriver driver) {

        super(driver);
    }

    //Методы
    //Заполняем поле Имя
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //Заполняем поле Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    //Заполняем поле Адрес
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //Заполняем поле станция метро
    public void setMetroStation(String station) {
        driver.findElement(metroStationField).click();
         wait
           .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("select-search__select"))));

        WebElement stationElement = driver.findElement(By.xpath(".//div[contains(text(),'"+station+"')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stationElement);
        stationElement.click();
      }
    //Заполняем поле Номер телефона
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //Заполняем форму Для кого самокат
    public void fillInForWhomPage(String name, String surname, String address, String station, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(station);
        setPhoneNumber(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void waitForLoadForWhomHeader(){
        wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Для кого самокат']")));
    }

}
