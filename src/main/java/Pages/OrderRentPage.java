package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class OrderRentPage extends BasePage {

    //Локаторы
    //Когда привезут самокат
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    //Черный цвет самоката
    public By black = By.id("black");
    //Серый цвет самоката
    private By grey = By.id("grey");
    //Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //Конструктор
    public OrderRentPage(WebDriver driver) {
        super(driver);
    }

    //Методы
    //Устанавливаем дату
    public void setDate(int index) {
        driver.findElement(dateField).click();
        if (index==0) {
            driver.findElement(By.xpath(".//button[@aria-label='Next Month']")).click();
            driver.findElement(By.xpath(".//div[text()='1']")).click();
        }
            else {
                driver.findElement(By.xpath(".//div[text()='13']")).click();
        }
    }

   //Устанавливаем срок аренды
    public void setRentalPeriod(int index) {
        driver.findElement(rentalPeriodField).click();
        if (index == 0) {
            driver.findElement(By.xpath(".//div[text()='сутки']")).click();
        } else {
            WebElement periodElement = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[last()]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", periodElement);
            periodElement.click();

        }
    }

    //Выбираем цвет
    public void setColor(String color) {
        if (Objects.equals(color, "black")) {
            driver.findElement(black).click();
        }
        else {
            driver.findElement(grey).click();
        }
    }

    //Заполняем поле комментарий
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Шаг для заполнения всей формы
    public void fillInRentPage(String color, String comment, int index) {
        setDate(index);
        setRentalPeriod(index);
        setColor(color);
        setComment(comment);
    }

    public void waitForLoadRentHeader(){
        wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Про аренду']")));
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
