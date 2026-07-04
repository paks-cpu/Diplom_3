package myhome.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverThePasswordPage {
    private final WebDriver driver;

    private final By buttonLoginLinkOnForgotPassword = By.cssSelector("a[href='/login']");

    public RecoverThePasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Нажать кнопку Войти при восстановлении пароля")
    public void clickButtonLoginLinkOnForgotPassword(){driver.findElement(buttonLoginLinkOnForgotPassword).click();}
}
