package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderToConfirmPage extends BasePage {

    //Локаторы
    //Хотите оформить заказ
    private By confirmOrder = By.xpath(".//div[text()='Хотите оформить заказ?']");
    //Хотите оформить заказ -> Да
    private By yesButton = By.xpath(".//button[text()='Да']");


    public OrderToConfirmPage(WebDriver driver) {
        super(driver);
    }

    public void waitForConfirmHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder));
}

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

}
