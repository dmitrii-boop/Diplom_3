package utils;

import io.restassured.response.ValidatableResponse;
import pogo.UserData;

import static io.restassured.RestAssured.given;

public class DetailsUser extends UrlSite {

    //"Регистрация пользователя"
    public void registration(UserData user) {
        given()
                .spec(getUrlSpec())
                .body(user)
                .post("api/auth/register")
                .then();
    }

    //"Удаление пользователя"
    public void removal(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .spec(getUrlSpec())
                .delete("api/auth/user")
                .then();
    }

    //"Авторизация пользователя"
    public ValidatableResponse login(UserData user) {
        return given()
                .spec(getUrlSpec())
                .body(user)
                .post("api/auth/login")
                .then();
    }
}
