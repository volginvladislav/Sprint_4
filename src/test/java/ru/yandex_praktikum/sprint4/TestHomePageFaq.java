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
    private String numberOfQuestion;
    // Переменная, в которой будем хранить правильный ответ для сравнения с актуальным ответом
    private String correctAnswer;
    WebDriver driver;

    public TestHomePageFaq(String choosedDriver, String numberOfQuestion) {
        if (choosedDriver.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (choosedDriver.equals("FireFox")) {
            driver = new FirefoxDriver();
        }
        this.numberOfQuestion = numberOfQuestion;
        if (numberOfQuestion =="1"){
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER1;
        } else if (numberOfQuestion =="2") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER2;
        }else if (numberOfQuestion =="3") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER3;
        }else if (numberOfQuestion =="4") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER4;
        }else if (numberOfQuestion =="5") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER5;
        }else if (numberOfQuestion =="6") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER6;
        }else if (numberOfQuestion =="7") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER7;
        }else if (numberOfQuestion =="8") {
            correctAnswer = FAQ_ANSWER_TEXT_NUMBER8;
        }
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Chrome", "1"},
                {"Chrome", "2"},
                {"Chrome", "3"},
                {"Chrome", "4"},
                {"Chrome", "5"},
                {"Chrome", "6"},
                {"Chrome", "7"},
                {"Chrome", "8"},
                {"FireFox", "1"},
                {"FireFox", "2"},
                {"FireFox", "3"},
                {"FireFox", "4"},
                {"FireFox", "5"},
                {"FireFox", "6"},
                {"FireFox", "7"},
                {"FireFox", "8"},
        };
    }

    @Before
    public void setUp() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void matchedAnswerTofaqQuestion() {
        HomePage objHomePage = new HomePage(driver);
        // Ожидание куки, клик, если они есть
        objHomePage.clickCookieButton();
        // Ожидание списка вопросов
        objHomePage.waitForLoadFaqQuestions();
        // Скроллинг до списка вопросов
        objHomePage.scrollToFaqQuestion();
        // Клик по вопросу
        objHomePage.clickFaqQuestionNumber(numberOfQuestion);
        // Ожидание ответа
        objHomePage.waitForLoadAnswerText(numberOfQuestion);
        // Проверка на совпадение текста ответа
        assertEquals("Неверный текст ответа на вопрос", correctAnswer, objHomePage.getTextFaqAnswer(numberOfQuestion));
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }

}
