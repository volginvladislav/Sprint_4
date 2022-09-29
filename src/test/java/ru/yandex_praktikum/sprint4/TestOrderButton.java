package ru.yandex_praktikum.sprint4;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestOrderButton {
    private String name;
    private String surName;
    private String adress;
    private String metro;
    private String phoneNumber;
    private String date;
    private String amountDays;
    private String scootercolor;
    private String coment;
    private String orderLocation;
    WebDriver driver;

    // Конструктор класса с тестируемыми полями
    public TestOrderButton(String choosedDriver, String name, String surName, String adress, String metro, String phoneNumber, String date, String amountDays, String scooterColor, String coment, String orderLocation)
    {
        this.name = name;
        this.surName = surName;
        this.adress = adress;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.amountDays = amountDays;
        this.scootercolor = scooterColor;
        this.coment = coment;
        this.orderLocation = orderLocation;
        if(choosedDriver.equals("Chrome")){
            driver = new ChromeDriver();
        }else if(choosedDriver.equals("FireFox")){
            driver = new FirefoxDriver();
        }

    }

    // Набор входных параметров для проверки позитивного сценария заказа самоката
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Chrome","Григорьев","Сергей","Красная Площадь","Охотный Ряд","+79117777777","12.09.2022", "7", "Black","Доставить вечером","up"},
                { "Chrome","Герасимов","Антон","Ленина 27","Лубянка","+79215555555","28.09.2022", "1","Grey","","down"},
                { "FireFox","Петров","Георгий","Патриотов 94","Сокольники","+79811111111","12.09.2022", "2","Grey","Доставить утром","down"},
                { "FireFox","Унунян","Артур","Героев 66","Митино","+79068888888","15.09.2022", "5","Black","","up"},
        };
    }

    @Before
    public void setUp() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderedShouldBeDisplayedWithButton() {
        HomePage objHomePage = new HomePage(driver);
        DataInputPage  objDataInputPage = new DataInputPage(driver);
        InfoRentPage   objInfoRentPage = new InfoRentPage(driver);
        // Подтверждение куки, если есть
        objHomePage.clickCookieButton();
        // Ожидание кликабельности кнопки «Заказать»
        objHomePage.waitForLoadOrderButton(orderLocation);
        // Скроллинг до кнопки «Заказать»
        objHomePage.scrollToButton(orderLocation);
        // Клик кнопки «Заказать»
        objHomePage.clickOrderButton(orderLocation);
        // Ожидание загрузки страницы
        objDataInputPage.waitForLoadDataInputPage();
        // Заполнение поля «*Имя»
        objDataInputPage.fillNameField(name);
        // Заполнение поля «*Фамилия»
        objDataInputPage.fillSurNameField(surName);
        // Заполнение поля «*Адрес: куда привезти заказ»
        objDataInputPage.fillAdressField(adress);
        // Заполнение поля «*Станция метро»
        objDataInputPage.fillMetroField(metro);
        // Заполнение поля «*Телефон: на него позвонит курьер»
        objDataInputPage.fillPhoneNumberField(phoneNumber);
        // Нажатие кнопки «Далее»
        objDataInputPage.clickNextButton();
        // Ожидание загрузки следующей страницы
        objInfoRentPage.waitForLoadInfoRentPage();
        // Заполнение поля «Дата»
        objInfoRentPage.fillDateDeliveryField(date);
        // Заполнение поля «Срок аренды»
        objInfoRentPage.fillRentalPeriodField(amountDays);
        // Заполнение поля «Цвет самоката»
        objInfoRentPage.chooseScooterColor(scootercolor);
        // Заполнение поля «Комментарий для курьера»
        objInfoRentPage.fillCommentField(coment);
        // Клик кнопки  «Заказать»
        objInfoRentPage.clickOrderButton();
        // Ожидание кликабельности кнопки «Да»
        objInfoRentPage.waitForLoadYesButton();
        // Подтверждение заказа - нажатие кнопки «Да»
        objInfoRentPage.clickYesButton();
        // Ожидание появления всплывающего окно с сообщением об успешном создании заказа
        objInfoRentPage.waitForLoadOrderedPage();
    }
    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}
