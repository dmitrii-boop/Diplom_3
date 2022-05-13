import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pageobject.HomePage;
import pageobject.AuthorizationPage;
import pageobject.RegistrationPage;
import pogo.UserData;
import utils.DetailsUser;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    private final String name = RandomStringUtils.randomAlphabetic(6);
    private final String email = RandomStringUtils.randomAlphabetic(6) + "@mail.ru";
    private final String password = RandomStringUtils.randomAlphabetic(7);
    public String accessToken;

    DetailsUser detailsUser;
    UserData userAuthorization = new UserData(email, password);

    @Before
    public void setUp() {
        detailsUser = new DetailsUser();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Пользователя можно зарегистрировать")
    public void userRegistration() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setValueInputName(name);
        registrationPage.setValueInputEmail(email);
        registrationPage.setValueInputPassword(password);
        registrationPage.clickRegisterButton();
        authorizationPage.getInputElement();
        Thread.sleep(1000);
        ValidatableResponse response = detailsUser.login(userAuthorization);
        accessToken = response.extract().path("accessToken");
        detailsUser.removal(accessToken);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Возникает ошибка для пароля меньше 6 символов")
    public void passwordError() {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setValueInputName(name);
        registrationPage.setValueInputEmail(email);
        registrationPage.setValueInputPassword("lol17");
        registrationPage.clickRegisterButton();
        registrationPage.getIncorrectPassword();
    }
}
