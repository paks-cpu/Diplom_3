import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import myhome.Resources;
import myhome.api.UserApiStep;
import myhome.api.UserLoginRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationNewUserTest extends BaseTest {

    private final UserApiStep userApiStep = new UserApiStep();
    private String email;
    private String password;
    private String name;
    private String accessToken;

    @Before
    public void generateUserData() {
        name = Resources.faker.name().firstName();
        email = Resources.faker.internet().emailAddress();
        password = "TestPass123";
        accessToken = null;

    }
    @After
    public void cleanUp() {
        if (accessToken != null) {
            try {
                userApiStep.deleteUserByBeaver(accessToken);
                System.out.println("Пользователь успешно удален.");
            } catch (Exception e) {
                System.out.println("Не удалось удалить пользователя: " + e.getMessage());
            } finally {
                accessToken = null;
            }
        }
    }

        @Test
        @DisplayName("Регистрация пользователя")
        @Description("Успешная регистрации пользователя при вводе валидных данных")
        public void registrationNewUserSuccessValidDateTest () {
            mainPage.clickLoginAccountButton();
            authorizationPage.clickButtonRegistrationOnAuthPage();
            registrationPage.inputName(name);
            registrationPage.inputEmail(email);
            registrationPage.inputPassword(password);
            registrationPage.clickButtonRegistration();
            registrationPage.visibleButtonEnterForRegistrationOnRegistrationPage();
            assertTrue("Кнопка войти не отобразилась",
                    registrationPage.visibleButtonEnterForRegistrationOnRegistrationPage());
            //получение accessToken для удаления его в before
            UserLoginRequest userLoginRequest = new UserLoginRequest(email, password);
            accessToken = userApiStep.authUserAndGetToken(userLoginRequest);
        }


        @Test
        @DisplayName("Регистрация с невалидным паролем")
        @Description("Получение ошибки при попытке регистрации с невалидным паролем - менее 6 символов")
        public void failedRegistrationIncorrectPasswordTest () {
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
