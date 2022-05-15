import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;
import pogo.UserData;
import utils.DetailsUser;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class EntranceTest {

    private final String name = RandomStringUtils.randomAlphabetic(6);
    private final String email = RandomStringUtils.randomAlphabetic(6) + "@mail.ru";
    private final String password = RandomStringUtils.randomAlphabetic(7);
    public String accessToken;

    DetailsUser detailsUser;
    UserData userRegistration = new UserData(email, password, name);
    UserData userAuthorization = new UserData(email, password);

    @Before
    public void setUp() {
        detailsUser = new DetailsUser();
        detailsUser.registration(userRegistration);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Пользователь может войти в аккаунт с главной страницы")
    public void userAuthorizationViaLoginToAccount() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setValueInputEmail(email);
        authorizationPage.setValueInputPassword(password);
        authorizationPage.clickEntranceButton();
        homePage.assertCheckoutButtonVisible();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();
        authorizationPage.assertInscriptionEntranceVisible();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Пользователь может войти в аккаунт через «Личный кабинет»")
    public void userAuthorizationThroughThePersonalAccount() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickPersonalAccountButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setValueInputEmail(email);
        authorizationPage.setValueInputPassword(password);
        authorizationPage.clickEntranceButton();
        homePage.assertCheckoutButtonVisible();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();
        authorizationPage.assertInscriptionEntranceVisible();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Пользователь может войти в аккаунт на форме регистрации")
    public void userAuthorizationOnTheRegistrationForm() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickLoginButton();
        authorizationPage.setValueInputEmail(email);
        authorizationPage.setValueInputPassword(password);
        authorizationPage.clickEntranceButton();
        homePage.assertCheckoutButtonVisible();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();
        authorizationPage.assertInscriptionEntranceVisible();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Пользователь может войти в аккаунт на форме восстановления пароля")
    public void userAuthorizationOnThePasswordRecoveryForm() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRestorePasswordButton();
        PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
        passwordRecoveryPage.clickLoginButton();
        authorizationPage.setValueInputEmail(email);
        authorizationPage.setValueInputPassword(password);
        authorizationPage.clickEntranceButton();
        homePage.assertCheckoutButtonVisible();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();
        authorizationPage.assertInscriptionEntranceVisible();
        Thread.sleep(1000);
    }

    @After
    public void deleteUser() {
        ValidatableResponse response = detailsUser.login(userAuthorization);
        accessToken = response.extract().path("accessToken");
        detailsUser.removal(accessToken);
    }
}
