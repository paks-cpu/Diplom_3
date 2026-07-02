package myhome.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static myhome.Resources.HOME_PAGE;

public class UserApiStep {

    public static final String POST_REGISTER_USER = "/api/auth/register"; //создание пользователя
    public static final String DELETE_USER = "/api/auth/user"; //удаление полььзователя


    public static RequestSpecification getBaseSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(HOME_PAGE);
    }

    @Step("Создание нового пользователя")
    public String registeredAndGetToken(UserCreateRequest userCreateRequest) {
        Response response = getBaseSpec()
                .body(userCreateRequest)
                .post(POST_REGISTER_USER)
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
                .delete(DELETE_USER)
                .then()
                .statusCode(202);
    }
}
