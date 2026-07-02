package myhome.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class MainPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    //Кнопка "Войти в аккаунт"
    final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.cssSelector("a[href='/account']");
    //Кнопка "Конструктор"
    private final By constructorButton = By.cssSelector("a[href='/']");
    //Кнопка "Лента заказов"
    private final By orderFeedButton = By.cssSelector("a[href='/feed']");
    //Кнопка-логотип stellarBurgers
    private final By stellarBurgersButton = By.cssSelector(".AppHeader_header__logo__2D0X2");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на кнопку Лента заказов")
    public void clickOrderFeedButton(){
        driver.findElement(orderFeedButton).click();
    }

    @Step("Нажать на логотип stellarBurgers в верхней части сайта по центру")
    public void slickStellarBurgersButton(){
        driver.findElement(stellarBurgersButton).click();
    }
}
