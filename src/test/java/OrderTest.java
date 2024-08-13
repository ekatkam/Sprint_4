import Pages.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import static org.junit.Assert.assertTrue;



@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String comment;
    private final int index;
    private final String color;


    public OrderTest(String name, String surname, String address, String station, String phoneNumber, String comment, int index, String color) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.index = index;
        this.color = color;

    }

    @Parameterized.Parameters
    public static Object[][] getData () {
        return new Object[][] {
            {"Иван", "Иванов", "пл.Ленина д.1", "Бабушк", "1111111111111", "Первый тест", 0, "black"},
            {"Анна Мария", "Петрова", "Москва, пл.Ленина д.2", "Сокольники", "12345678901", "", 1, "grey"},
        };
    }

    @Test
    public void checkOrderFlow() {

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderButton(index);

        OrderForWhomPage objOrderForWhomPage = new OrderForWhomPage(driver);
        objOrderForWhomPage.waitForLoadForWhomHeader();
        objOrderForWhomPage.fillInForWhomPage(name, surname, address, station, phoneNumber);
        objOrderForWhomPage.clickNextButton();

        OrderRentPage objOrderPageRent = new OrderRentPage(driver);
        objOrderPageRent.waitForLoadRentHeader();
        objOrderPageRent.fillInRentPage(color, comment, index);
        objOrderPageRent.clickOrderButton();

        OrderToConfirmPage objOrderToConfirmPage = new OrderToConfirmPage(driver);
        objOrderToConfirmPage.waitForConfirmHeader();
        objOrderToConfirmPage.clickYesButton();

        OrderIsConfirmedPage objOrderIsConfirmedPage = new OrderIsConfirmedPage(driver);
        objOrderIsConfirmedPage.waitForConfirmMessage();
        boolean result = objOrderIsConfirmedPage.checkIfSuccessMessageIsDisplayed();
        assertTrue(result);
    }
}
