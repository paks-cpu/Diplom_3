package myhome.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import myhome.Resources;

public class UserApiStep {



    public static RequestSpecification getBaseSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Resources.HOME_PAGE);
    }

    @Step("Создание нового пользователя")
    public String registeredAndGetToken(UserCreateRequest userCreateRequest) {
        Response response = getBaseSpec()
                .body(userCreateRequest)
                .post(Resources.POST_REGISTRATION_USER)
                .then()
                .statusCode(200)
                .extract()
                .response();

        String accessToken = response.jsonPath().get("accessToken");
        if (accessToken == null || accessToken.isBlank()){
            throw new IllegalStateException("Не удалось извлечь accessToken из ответа API");
        }
        return accessToken;
    }

    @Step("Удаление пользователя")
    public void deleteUserByBeaver(String accessToken) {
        if (accessToken == null || accessToken.isBlank()) {
            throw new IllegalArgumentException("accessToken не может быть null или пустым");
        }

        given()
                .spec(getBaseSpec())
                .log().all()
                .header("Authorization", accessToken)
                .delete(Resources.DELETE_USER)
                .then()
                .statusCode(202);
    }

    @Step("Авторизация пользователя и получение его токена")
    public String authUserAndGetToken(UserLoginRequest userLoginRequest){
        Response response = getBaseSpec()
                .body(userLoginRequest)
                .post(Resources.AUTHORIZATION_PAGE)
                .then()
                .statusCode(200)
                .extract()
                .response();

        String accessToken = response.jsonPath().get("accessToken");
        if (accessToken == null || accessToken.isBlank()){
            throw new IllegalStateException("Не удалось извлечь token из ответа API");
        }
        return accessToken;
    }
}
