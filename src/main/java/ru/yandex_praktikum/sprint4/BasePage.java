package ru.yandex_praktikum.sprint4;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage (WebDriver driver) {
        this.driver = driver;
    }

}
