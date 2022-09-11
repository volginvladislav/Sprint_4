package ru.yandex_praktikum.sprint4;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Cтраница ввода персональных данных для заказа
public class DataInputPage extends BasePage{

    //Конструктор класса DataInputPage
    public DataInputPage (WebDriver driver) {
        super(driver);
    }

    // локаторы полей ввода личных данных для заказа
    // локатор поля «*Имя»
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // локатор поля «*Фамилия»
    private By surnameField= By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор поля «*Адрес: куда привезти заказ»
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор поля «*Станция метро»
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    // локатор поля «*Телефон: на него позвонит курьер»
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор кнопки «Далее»
    private By nextButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text()='Далее')]");

    // Методы для тестового сценария 2 (Заказ самоката)
    // Метод ожидания загрузки страницы ввода персональных данных для заказа - кликабельности кнопки «Далее»
    public void waitForLoadDataInputPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    // Метод заполнения поля «*Имя»
    public void fillNameField(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    // Метод заполнения поля «*Фамилия»
    public void fillSurNameField(String surName) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surName);
    }

    // Метод заполнения поля «*Адрес: куда привезти заказ»
    public void fillAdressField(String adress) {
        driver.findElement(adressField).clear();
        driver.findElement(adressField).sendKeys(adress);
    }

    // Метод заполнения поля «*Станция метро»
    public void fillMetroField(String metro) {
        driver.findElement(metroField).clear();
        driver.findElement(metroField).sendKeys(metro + Keys.DOWN + Keys.ENTER);
    }

    // Метод заполнения поля «*Телефон: на него позвонит курьер»
    public void fillPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Метод нажатия кнопки «Далее»
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}

