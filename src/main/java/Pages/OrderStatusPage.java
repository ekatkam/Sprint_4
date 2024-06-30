package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderStatusPage extends BasePage {

    //Такого заказа нет
    private By orderNotFound = By.xpath(".//img[@alt = 'Not found']");

    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    //Проверяем, что появилось сообщение Такого заказа нет
    public boolean noSuchOrderMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNotFound));
       return driver.findElement(orderNotFound).isDisplayed();
    }
}
