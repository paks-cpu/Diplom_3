package myhome.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    final WebDriverWait wait;

    //поле ввода name
    private final By fieldNameForRegistration = By.xpath("//label[normalize-space()='Имя']/following-sibling::input");
    //поле ввода email
    private final By fieldEmailForRegistration = By.xpath("//label[normalize-space()='Email']/following-sibling::input");
    //поле ввода пароля
    private final By fieldPasswordForRegistration = By.xpath("//label[normalize-space()='Пароль']/following-sibling::input");
    //кнопка Зарегистрироваться
    private final By buttonRegistrationOnRegistrationPage = By.xpath("//button[normalize-space()='Зарегистрироваться']");
    //кнопка Войти
    private final By buttonEnterForRegistrationOnRegistrationPage = By.xpath("//a[@href='/login' and normalize-space()='Войти']");
    //сообщение Неккоректный пароль
    private final By errorMessageIncorrectPasswordOnRegistrationPage = By.xpath("//p[contains(@class, 'input__error') and normalize-space()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Ввод имени пользователя при регистрации")
    public void inputName(String name) {
        driver.findElement(fieldNameForRegistration).sendKeys(name);
    }

    @Step("Ввод почты пользоваля при регистрации")
    public void inputEmail(String email) {
        driver.findElement(fieldEmailForRegistration).sendKeys(email);
    }

    @Step("Ввод пароля пользователя при регистрации")
    public void inputPassword(String password) {
        driver.findElement(fieldPasswordForRegistration).sendKeys(password);
    }

    @Step("Нажать Зарегистрироваться при регистрации")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistrationOnRegistrationPage).click();
    }

    @Step("Нажать Войти при регистрации")
    public void clickButtonEnter() {
        driver.findElement(buttonEnterForRegistrationOnRegistrationPage).click();
    }

    @Step("Ошибка неправильного пароля видна")
    public boolean errorMessageIncorrectPasswordDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageIncorrectPasswordOnRegistrationPage)).isDisplayed();
    }

    @Step("Кнопки Войти на странице авторизации видна")
    public boolean visibleButtonEnterForRegistrationOnRegistrationPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonEnterForRegistrationOnRegistrationPage)).isDisplayed();
    }
}
