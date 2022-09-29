package ru.yandex_praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Cтраница ввода информации об аренде
public class InfoRentPage extends BasePage{

    //Конструктор класса InfoRentPage
    public InfoRentPage (WebDriver driver) {
        super(driver);
    }

    // локаторы полей ввода информации об аренде
    // локатор поля «*Когда привезти самокат»
    private By dateDeliveryField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля «*Срок аренды»
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    // локатор для «сутки»
    private By rentalFieldPeriodDay1 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'сутки')]");
    // локатор для «двое суток»
    private By rentalFieldPeriodDay2 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'двое')]");
    // локатор для «трое суток»
    private By rentalFieldPeriodDay3 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'трое')]");
    // локатор для «четверо суток»
    private By rentalFieldPeriodDay4 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'четверо')]");
    // локатор для «пятеро суток»
    private By rentalFieldPeriodDay5 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'пятеро')]");
    // локатор для «шестеро суток»
    private By rentalFieldPeriodDay6 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'шестеро')]");
    // локатор для «семеро суток»
    private By rentalFieldPeriodDay7 = By.xpath(".//div[@class='Dropdown-option' and contains(text(),'семеро')]");

    // локаторы полей цвета самоката
    private By blackColorField = By.id("black");
    private By greyColorField = By.id("grey");
    // локатор поля «Комментарий для курьера»
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки «Заказать»
    private By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM')  and (text()='Заказать')]");
    // локатор кнопки «Да» при подтверждении заказа
    private By yesButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text()='Да')]");
    //// локатор всплывающего окна «Заказ оформлен» при успешном оформлении заказа
    private By seeStatus = By.xpath(".//div[(@class='Order_ModalHeader__3FDaJ') and (text()='Заказ оформлен')]");

    // Константы количества суток аренды
    private final String ONEDAY = "1";
    private final String TWODAYS = "2";
    private final String THREEDAYS = "3";
    private final String FOURDAYS = "4";
    private final String FIVEDAYS = "5";
    private final String SIXDAYS = "6";
    private final String SEVENDAYS = "7";

    // Константы цветов самокатов
    private final String GREY = "Grey";
    private final String BLACK = "Black";

    // Методы для тестового сценария 2 (Заказ самоката)
    // Метод ожидания загрузки страницы с данными о заказе - кликабельности кнопки «Заказать»
    public void waitForLoadInfoRentPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
    }
    // Метод заполнения поля «*Срок аренды»
    public void fillDateDeliveryField(String date) {
        driver.findElement(dateDeliveryField).clear();
        driver.findElement(dateDeliveryField).sendKeys(date + Keys.ENTER);
    }
    // Метод заполнения поля «*Когда привезти самокат»
    public void fillRentalPeriodField(String amountDays) {
        driver.findElement(rentalPeriodField).click();
            if(amountDays.equals(ONEDAY)) {
                driver.findElement(rentalFieldPeriodDay1).click();
            } else if (amountDays.equals(TWODAYS)) {
                driver.findElement(rentalFieldPeriodDay2).click();
            } else if (amountDays.equals(THREEDAYS)) {
                driver.findElement(rentalFieldPeriodDay3).click();
            } else if (amountDays.equals(FOURDAYS)) {
                driver.findElement(rentalFieldPeriodDay4).click();
            } else if (amountDays.equals(FIVEDAYS)) {
                driver.findElement(rentalFieldPeriodDay5).click();
            } else if (amountDays.equals(SIXDAYS)) {
                driver.findElement(rentalFieldPeriodDay6).click();
            } else if (amountDays.equals(SEVENDAYS)) {
                driver.findElement(rentalFieldPeriodDay7).click();
            }
    }

    // Метод выбора цвета самоката
    public void chooseScooterColor(String scooterColor) {
        if (scooterColor.equals(GREY)) {
            driver.findElement(greyColorField).click();
        } else if (scooterColor.equals(BLACK)) {
            driver.findElement(blackColorField).click();
        }
    }

    // Метод заполнения поля «Комментарий для курьера»
    public void fillCommentField(String coment) {
        driver.findElement(commentField).sendKeys(coment);
    }

    // Метод нажатия на кнопку «Заказать»
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // Метод ожидания кликабельности кнопки «Да»
    public void waitForLoadYesButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(yesButton));

    }
    // Метод нажатия на кнопку «Да»
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    // Метод ожидания всплывающего окна с текстом «Заказ оформлен»
    public void waitForLoadOrderedPage() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(seeStatus));
    }
}
