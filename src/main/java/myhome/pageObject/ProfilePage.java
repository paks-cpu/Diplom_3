package myhome.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By logoutButtonLocator = By.cssSelector("button[type='button'][class*='Account_button']");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Проверить наличие и видимость кнопки «Выход»")
    public void verifyLogoutButtonIsVisible() {
        WebElement logoutButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator)
        );
    }
}
