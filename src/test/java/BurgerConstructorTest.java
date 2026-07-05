import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import myhome.pom.BurgerConstructorPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BurgerConstructorTest extends BaseTest{
    private BurgerConstructorPage burgerConstructorPage;

    @Before
    public void setUpPage() {
        burgerConstructorPage = new BurgerConstructorPage(driver, wait);
    }

    @Test
    @DisplayName("Переход на вкладку Булки")
    @Description("Удачный переход на вкладку Булки с отображением ингредиентов")
    public void checkTabNavigationInConstructorOnBuns(){
        mainPage.clickConstructorButton();
        burgerConstructorPage.switchToFilling(); //так как при переходе на страницу по умолчанию отображются булки, то делаю переход на начинки
        burgerConstructorPage.switchToBuns();
        assertTrue("Булки в ингредиентах не отобразились", burgerConstructorPage.activeTabBunIngredients());
    }

    @Test
    @DisplayName("Переход на вкладку Начинки")
    @Description("При переходе на вкладку Начинки начинает отображаться раздел Начинки")
    public void checkTabNavigationInConstructorOnFilling(){
        mainPage.clickConstructorButton();
        burgerConstructorPage.switchToFilling();
        assertTrue("Начинки в ингредиентах не отобразились", burgerConstructorPage.activeTabFillingIngredients());
    }

    @Test
    @DisplayName("Переход на вкладку Соусы")
    @Description("Удачный переход на вкладку Соусы с отображением ингредиентов")
    public void checkTabNavigationInConstructorOnSauce(){
        mainPage.clickConstructorButton();
        burgerConstructorPage.switchToSauce();
        assertTrue("Соусы в ингредиентах не отобразились", burgerConstructorPage.activeTabSauceIngredients());

    }
}
