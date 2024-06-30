package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {

    //Локаторы
    //Блок с вопросами
    private By faq = By.className("accordion");

    //Кнопки Заказать
    private By[] toMakeAnOrderButtons = {By.className("Button_Button__ra12g"),
                                         By.className("Button_Middle__1CSJM")};
   //Массив со списком вопросов
    private By[] questions = {By.id("accordion__heading-0"), By.id("accordion__heading-1"),
            By.id("accordion__heading-2"), By.id("accordion__heading-3"), By.id("accordion__heading-4"),
            By.id("accordion__heading-5"), By.id("accordion__heading-6"), By.id("accordion__heading-7")};

    //Массив со списком ответов
    private By[] answers = {By.id("accordion__panel-0"), By.id("accordion__panel-1"), By.id("accordion__panel-2"),
            By.id("accordion__panel-3"), By.id("accordion__panel-4"), By.id("accordion__panel-5"),
            By.id("accordion__panel-6"), By.id("accordion__panel-7"),};

    //Лого Самокат
    private By scooterLogo = By.xpath(".//img[@alt='Scooter']");
    //Лого Яндекс
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");

    //Кнопка Статус заказа
    private By orderStatusButton = By.xpath(".//button[text()='Статус заказа']");
    //Поле для ввода номера заказа
    private By orderNumberInputField = By.xpath(".//input[@placeholder='Введите номер заказа']");
    //Кнопка Go
    private By goButton = By.xpath(".//button[text()='Go!']");




    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOrderButton(int index) {
        driver.findElement(toMakeAnOrderButtons[index]).click();
    }
    //Кликаем по вопросу и получаем текст ответа
    public String getAnswerText(int index) {
        WebElement questionElement = driver.findElement(questions[index]);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        wait
                .until(ExpectedConditions.elementToBeClickable(questions[index])).click();
        wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(answers[index])));
        return driver.findElement(answers[index]).getText();

    }

    //Кликаем на логотип Яндекса и получаем title новой страницы
    public String clickYandexLogo() {
        driver.findElement(yandexLogo).click();
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        return driver.getTitle();
    }

    //Кликаем на логотип Самоката
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

   //Проверяем, что появился заголовок
    public boolean isMainScooterPage() {
        clickScooterLogo();
        return driver.findElement(By.className("Home_Header__iJKdX")).isDisplayed();
    }

    //Кликаем на кнопку Статус заказа
    public void clickOrderStatusButton() {
            driver.findElement(orderStatusButton).click();
    }

    //Вводим несуществующий номер заказа
    public void inputWrongOrderNumber(String wrongOrderNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberInputField));
        driver.findElement(orderNumberInputField).sendKeys(wrongOrderNumber);
    }

    //Кликаем на кнопку Go
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

}
