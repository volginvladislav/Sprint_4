package ru.yandex_praktikum.sprint4;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestHomePageFaq {
    private final String FAQ_ANSWER_TEXT_NUMBER1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String FAQ_ANSWER_TEXT_NUMBER2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String FAQ_ANSWER_TEXT_NUMBER3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String FAQ_ANSWER_TEXT_NUMBER4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String FAQ_ANSWER_TEXT_NUMBER5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String FAQ_ANSWER_TEXT_NUMBER6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String FAQ_ANSWER_TEXT_NUMBER7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String FAQ_ANSWER_TEXT_NUMBER8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    WebDriver driver;

    public TestHomePageFaq(String choosedDriver) {
        if (choosedDriver.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (choosedDriver.equals("FireFox")) {
            driver = new FirefoxDriver();
        }
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Chrome"},
                {"FireFox"},
        };
    }

    @Before
    public void setUp() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Тест ответа на вопрос №1
    @Test
    public void matchedAnswerTofaqQuestionNumber1() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber1();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(1);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №1", FAQ_ANSWER_TEXT_NUMBER1, objHomePage.getTextFaqAnswer(1));
    }

    // Тест ответа на вопрос №2
    @Test
    public void matchedAnswerToFaqQuestionNumber2() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber2();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(2);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №2", FAQ_ANSWER_TEXT_NUMBER2, objHomePage.getTextFaqAnswer(2));
    }

    // Тест ответа на вопрос №3
    @Test
    public void matchedAnswerToFaqQuestionNumber3() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber3();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(3);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №3", FAQ_ANSWER_TEXT_NUMBER3, objHomePage.getTextFaqAnswer(3));
    }

    // Тест ответа на вопрос №4
    @Test
    public void matchedAnswerToFaqQuestionNumber4() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber4();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(4);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №4", FAQ_ANSWER_TEXT_NUMBER4, objHomePage.getTextFaqAnswer(4));
    }

    // Тест ответа на вопрос №5
    @Test
    public void matchedAnswerToFaqQuestionNumber5() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber5();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(5);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №5", FAQ_ANSWER_TEXT_NUMBER5, objHomePage.getTextFaqAnswer(5));
    }

    // Тест ответа на вопрос №6
    @Test
    public void matchedAnswerToFaqQuestionNumber6() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber6();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(6);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №6", FAQ_ANSWER_TEXT_NUMBER6, objHomePage.getTextFaqAnswer(6));
    }

    // Тест ответа на вопрос №7
    @Test
    public void matchedAnswerToFaqQuestionNumber7() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber7();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(7);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №7", FAQ_ANSWER_TEXT_NUMBER7, objHomePage.getTextFaqAnswer(7));
    }

    // Тест ответа на вопрос №8
    @Test
    public void matchedAnswerToFaqQuestionNumber8() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber8();
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(8);
        // Проверка на совпадение текста ответа
        assertEquals("Несовпадение текста ответа на вопрос №8", FAQ_ANSWER_TEXT_NUMBER8, objHomePage.getTextFaqAnswer(8));
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }

}
