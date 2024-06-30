import Pages.MainPage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoTest extends BaseTest {

    @Test
    public void checkYandexLogo() {
        MainPage objMainPage = new MainPage(driver);
        String title = objMainPage.clickYandexLogo();
        assertEquals("Дзен", title);
    }

    @Test
    public void checkScooterLogo() {
        MainPage objMainPage = new MainPage(driver);
        boolean result = objMainPage.isMainScooterPage();
        assertTrue(result);
    }
}
