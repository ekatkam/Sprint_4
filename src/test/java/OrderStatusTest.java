import Pages.MainPage;
import Pages.OrderStatusPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest extends BaseTest {

    @Test
    public void wrongOrderNumberIsNotDisplayed() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderStatusButton();
        objMainPage.inputWrongOrderNumber("123");
        objMainPage.clickGoButton();

        OrderStatusPage objOrderStatusPage = new OrderStatusPage(driver);
        boolean noSuchOrderMessageIsDisplayed = objOrderStatusPage.noSuchOrderMessageIsDisplayed();
        assertTrue(noSuchOrderMessageIsDisplayed);
    }
}
