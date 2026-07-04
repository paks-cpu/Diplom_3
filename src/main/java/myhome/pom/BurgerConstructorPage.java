package myhome.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BurgerConstructorPage {
    private final WebDriver driver;

    public BurgerConstructorPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
    }

    private final By tabBunIngredients = By.xpath("//span[text()='Булки']");
    private final By activeTabBunIngredients = By.xpath("//span[text()='Булки']/parent::div[contains(@class, 'tab_tab_type_current')]");
    private final By tabSauceIngredients = By.xpath("//span[text()='Соусы']");
    private final By activeTabSauceIngredients = By.xpath("//span[text()='Соусы']/parent::div[contains(@class, 'tab_tab_type_current')]");
    private final By tabFillingIngredients = By.xpath("//span[text()='Начинки']");
    private final By activeTabFillingIngredients = By.xpath("//span[text()='Начинки']/parent::div[contains(@class, 'tab_tab_type_current')]");

    @Step("Нажатие на вкладку Булки")
    public void switchToBuns(){ driver.findElement(
            tabBunIngredients).click();
    }
    @Step("Вкладка Булки стала активной (имеет класс текущей вкладки)")
    public boolean activeTabBunIngredients(){
        return driver.findElement(activeTabBunIngredients).isDisplayed();
    }
    @Step("Нажатие на вкладку Соусы")
    public void switchToSauce(){
        driver.findElement(tabSauceIngredients).click();
    }
    @Step("Вкладка Соусы стала активной (имеет класс текущей вкладки)")
    public boolean activeTabSauceIngredients(){
        return driver.findElement(activeTabSauceIngredients).isDisplayed();
    }
    @Step("Нажатие на вкладку Начинки")
    public void switchToFilling(){
        driver.findElement(tabFillingIngredients).click();
    }
    @Step("Вкладка Начинки стала активной (имеет класс текущей вкладки)")
    public boolean activeTabFillingIngredients(){
        return driver.findElement(activeTabFillingIngredients).isDisplayed();
    }
}
