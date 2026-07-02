import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import myhome.Resources;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationNewUserTest extends BaseTest {

    private String email;
    private String password;
    private String name;

    @Before
    public void generateUserData() {
        name = Resources.faker.name().firstName();
        email = Resources.faker.internet().emailAddress();
        password = "TestPass123";
    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Успешная регистрации пользователя при вводе валидных данных")
    public void registrationNewUserSuccessValidDateTest(){
        mainPage.clickLoginAccountButton();
        authorizationPage.clickButtonRegistrationOnAuthPage();
        registrationPage.inputName(name);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.clickButtonRegistration();
        registrationPage.visibleButtonEnterForRegistrationOnRegistrationPage();
    }

    @Test
    @DisplayName("Регистрация с невалидным паролем")
    @Description("Получение ошибки при попытке регистрации с невалидным паролем - менее 6 символов")
    public void failedRegistrationIncorrectPasswordTest(){
        mainPage.clickLoginAccountButton();
        authorizationPage.clickButtonRegistrationOnAuthPage();
        registrationPage.inputName(name);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("12345");
        registrationPage.clickButtonRegistration();
        assertTrue("Не отобразилось сообщение об ошибке для невалидного пароля",
                registrationPage.errorMessageIncorrectPasswordDisplayed());
    }
}
