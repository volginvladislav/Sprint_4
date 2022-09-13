package ru.yandex_praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    // Конструктор класса HomePage
    public HomePage (WebDriver driver) {
        super(driver);
    }
    // локатор для куки - кнопки "Да все привыкли"
    private By cookieButton = By.id("rcc-confirm-button");
    // локатор копки «Заказать» вверху страницы справа
    private By orderButtonUpRightPage = By.className("Button_Button__ra12g");
    // локатор копки «Заказать» внизу страницы по-середине
    private By orderButtonAtTheBottomMiddlePage = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestions= By.className("accordion__button");

    //Локаторы для пунктов из выпадающего списка в разделе «Вопросы о важном»
    //локатор пункта №1 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber1 = By.id("accordion__heading-0");
    //локатор пункта №2 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber2 = By.id("accordion__heading-1");
    //локатор пункта №3 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber3 = By.id("accordion__heading-2");
    //локатор пункта №4 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber4 = By.id("accordion__heading-3");
    //локатор пункта №5 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber5 = By.id("accordion__heading-4");
    //локатор пункта №6 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber6 = By.id("accordion__heading-5");
    //локатор пункта №7 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber7 = By.id("accordion__heading-6");
    //локатор пункта №8 выпадающего списка в разделе «Вопросы о важном»
    private By faqQuestionNumber8 = By.id("accordion__heading-7");

    //Локаторы для ответов на вопросы пунктов из выпадающего списка в разделе «Вопросы о важном»
    //локатор ответа на пункт №1 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber1 = By.id("accordion__panel-0");
    //локатор ответа на пункт №2 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber2 = By.id("accordion__panel-1");
    //локатор ответа на пункт №3 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber3 = By.id("accordion__panel-2");
    //локатор ответа на пункт №4 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber4 = By.id("accordion__panel-3");
    //локатор ответа на пункт №5 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber5 = By.id("accordion__panel-4");
    //локатор ответа на пункт №6 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber6 = By.id("accordion__panel-5");
    //локатор ответа на пункт №7 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber7 = By.id("accordion__panel-6");
    //локатор ответа на пункт №8 выпадающего списка в разделе «Вопросы о важном»
    private By faqAnswerNumber8 = By.id("accordion__panel-7");

    // Методы для тестового сценария 1 (Проверка выпадающего списка в разделе «Вопросы о важном»)
    // Метод ожидания наличия всплывающего окна куки (при наличии - нажимаем)
    public void clickCookieButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(cookieButton)).click();
    }

    // Метод ожидания кликабильности списка «Вопросы о важном»
    public void waitForLoadFaqQuestions() {
        new WebDriverWait(driver, 40)
                .until(ExpectedConditions.elementToBeClickable(faqQuestions));
    }

    // Метод скроллинга списка «Вопросы о важном» до последнего элемента №8
    public void scrollToFaqQuestion() {
        WebElement element = driver.findElement(faqQuestionNumber8);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метода клика по заданному вопросу из списка «Вопросы о важном»
    public void clickFaqQuestionNumber(String i) {
        if (i == "1") {
            driver.findElement(faqQuestionNumber1).click();
        } else if (i == "2") {
            driver.findElement(faqQuestionNumber2).click();
        } else if (i == "3") {
            driver.findElement(faqQuestionNumber3).click();
        } else if (i == "4") {
            driver.findElement(faqQuestionNumber4).click();
        } else if (i == "5") {
            driver.findElement(faqQuestionNumber5).click();
        } else if (i == "6") {
            driver.findElement(faqQuestionNumber6).click();
        } else if (i == "7") {
            driver.findElement(faqQuestionNumber7).click();
        } else if (i == "8") {
            driver.findElement(faqQuestionNumber8).click();
        }
    }

    // Метод ожидания текста ответа после клика по вопросу «Вопросы о важном»
    public void waitForLoadAnswerText(String i) {
        By element = null;
        if(i == "1") {
            element = faqAnswerNumber1;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "2") {
            element = faqAnswerNumber2;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "3") {
            element = faqAnswerNumber3;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "4") {
            element = faqAnswerNumber4;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "5") {
            element = faqAnswerNumber5;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "6") {
            element = faqAnswerNumber6;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "7") {
            element = faqAnswerNumber7;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else if(i == "8") {
            element = faqAnswerNumber8;
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        }
    }

    // Метод получает текст ответа при нажатии на вопросы выпадающего списка «Вопросы о важном»
    public String getTextFaqAnswer(String i) {
        String text = null;
        if (i == "1") {
            text = driver.findElement(faqAnswerNumber1).getText();
        } else if (i == "2") {
            text = driver.findElement(faqAnswerNumber2).getText();
        } else if (i == "3") {
            text = driver.findElement(faqAnswerNumber3).getText();
        } else if (i == "4") {
            text = driver.findElement(faqAnswerNumber4).getText();
        } else if (i == "5") {
            text = driver.findElement(faqAnswerNumber5).getText();
        } else if (i == "6") {
            text = driver.findElement(faqAnswerNumber6).getText();
        } else if (i == "7") {
            text = driver.findElement(faqAnswerNumber7).getText();
        } else if (i == "8") {
            text = driver.findElement(faqAnswerNumber8).getText();
        }
        return text;
    }

    // Методы для тестового сценария 2 (Заказ самоката)
    // Метод ожидания кликабильности кнопки «Заказать»
    public void waitForLoadOrderButton(String i) {
        if(i == "up") {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(orderButtonUpRightPage));
        } else if(i == "down") {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(orderButtonAtTheBottomMiddlePage));
        }
    }

    // Метод скроллинга страницы до кнопки «Заказать»
    public void scrollToButton(String i) {
        if(i == "down") {
            WebElement element = driver.findElement(orderButtonAtTheBottomMiddlePage);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        } else if(i == "up") {
            WebElement element = driver.findElement(orderButtonUpRightPage);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }
    }

    // Метода нажатия на кнопку «Заказать»
    public void clickOrderButton(String i) {
        if(i == "down") {
            driver.findElement(orderButtonAtTheBottomMiddlePage).click();
        } else if(i == "up") {
            driver.findElement(orderButtonUpRightPage).click();
        }
    }
}




