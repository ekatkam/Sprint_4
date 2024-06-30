package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderIsConfirmedPage extends BasePage {

    private By orderConfirmed = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderIsConfirmedPage(WebDriver driver) {
        super(driver);
    }

    public void waitForConfirmMessage() {
        wait
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmed));
    }

    public boolean checkIfSuccessMessageIsDisplayed() {
        return driver.findElement(orderConfirmed).isDisplayed();

    }
}
