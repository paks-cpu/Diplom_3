package myhome.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //поле Email
    public final By emailInputField = By.xpath("//label[text()='Email']/parent::div/input");
    //поле Пароль
    public final By passwordInputField = By.xpath("//label[text()='Пароль']/parent::div/input");
    //кнопка Зарегистрироваться на странице авторизации
    public final By buttonRegistrationOnAuthPage = By.cssSelector("a[href='/register']");
    //кнопка Восстановить пароль
    public final By buttonForgotPasswordOnAuthPage = By.cssSelector("a[href='/forgot-password']");
    //кнопка Войти
    public final By buttonEnterForRegistrationOnAuthPage = By.xpath("//button[normalize-space()='Войти']");
    //кнопка Профиль в личном кабинете после авторизации
    private final By buttonProfileLink = By.xpath("//a[normalize-space()='Профиль']");



    public AuthorizationPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Нажать кнопку Войти при авторизации")
    public void clickEnterOnAuthPage(){
        driver.findElement(buttonEnterForRegistrationOnAuthPage).click();
    }

    @Step("Нажать кнопку Зарегистрироваться на странице авторизации")
    public void clickButtonRegistrationOnAuthPage(){
        driver.findElement(buttonRegistrationOnAuthPage).click();
    }

    @Step("Нажать Восстановить пароль на странице авторизации")
    public void clickForgotPasswordOnAuthPage(){
        driver.findElement(buttonForgotPasswordOnAuthPage).click();
    }

    @Step("Отображение кнопки Профиль на странице авторизации")
    public void assertProfileLinkIsVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonProfileLink));
    }

    @Step("Ввод почты в поле email")
    public void sendEmailInFieldEmail(String email){
        driver.findElement(emailInputField).sendKeys(email);
    }
    @Step("Ввод пароля в поле password")
    public void sendPasswordInFieldPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }
}
