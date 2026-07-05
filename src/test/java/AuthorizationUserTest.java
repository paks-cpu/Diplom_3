import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import myhome.api.UserApiStep;
import myhome.api.UserCreateRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import myhome.Resources;

public class AuthorizationUserTest extends BaseTest{

    private final UserApiStep userApiStep = new UserApiStep();
    private String email;
    private String password;
    private String name;
    private String accessToken;


    @Before
    public void setupTestData(){
        name = Resources.faker.name().firstName();
        email = Resources.faker.internet().emailAddress();
        password = "TestPass123";
        accessToken = null;
        UserCreateRequest request = new UserCreateRequest(name, email, password);
        accessToken = userApiStep.registeredAndGetToken(request);
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной странице")
    @Description("Успешная авторизация пользователя при вводе валидных данных")
    public void authNewUserOnMainPage(){
        mainPage.clickLoginAccountButton();
        authorizationPage.sendEmailInFieldEmail(email);
        authorizationPage.sendPasswordInFieldPassword(password);
        authorizationPage.clickEnterOnAuthPage();
        mainPage.clickPersonalAccountButton();
        authorizationPage.assertProfileLinkIsVisible();
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("Успешная авторизация пользователя при вводе валидных данных")
    public void authNewUserOnProfilePage(){
        mainPage.clickPersonalAccountButton();
        authorizationPage.sendEmailInFieldEmail(email);
        authorizationPage.sendPasswordInFieldPassword(password);
        authorizationPage.clickEnterOnAuthPage();
        mainPage.clickPersonalAccountButton();
        authorizationPage.assertProfileLinkIsVisible();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Успешная авторизация пользователя при вводе валидных данных")
    public void authNewUserOnRegistrationPage(){
        mainPage.clickLoginAccountButton();
        authorizationPage.clickButtonRegistrationOnAuthPage();
        registrationPage.clickButtonEnter();
        authorizationPage.sendEmailInFieldEmail(email);
        authorizationPage.sendPasswordInFieldPassword(password);
        authorizationPage.clickEnterOnAuthPage();
        mainPage.clickPersonalAccountButton();
        authorizationPage.assertProfileLinkIsVisible();

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Успешная авторизация пользователя при вводе валидных данных")
    public void authNewUserOnForgotPasswordPage(){
        mainPage.clickLoginAccountButton();
        authorizationPage.clickForgotPasswordOnAuthPage();
        recoverThePasswordPage.clickButtonLoginLinkOnForgotPassword();
        authorizationPage.sendEmailInFieldEmail(email);
        authorizationPage.sendPasswordInFieldPassword(password);
        authorizationPage.clickEnterOnAuthPage();
        mainPage.clickPersonalAccountButton();
        authorizationPage.assertProfileLinkIsVisible();
    }

    @After
    public void cleanUp() {
        if (accessToken != null) {
            try {
                userApiStep.deleteUserByBeaver(accessToken);
            } catch (Exception e) {
                System.out.println("Не удалось удалить пользователя: " + e.getMessage());
            } finally {
                accessToken = null;
            }
        }
    }
}
