import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.AuthorizationPage;
import pageobject.HomePage;
import pageobject.PersonalAccountPage;
import pogo.UserData;
import utils.DetailsUser;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class TransitionTest {

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
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    @Description("Пользователь может войти в личный кабинет по клику кнопки «Личный кабинет»")
    public void clickOnThePersonalAccountButton() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickPersonalAccountButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setValueInputEmail(email);
        authorizationPage.setValueInputPassword(password);
        authorizationPage.clickEntranceButton();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.getElementText();
        personalAccountPage.clickExitButton();
        authorizationPage.getInputElement();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор» из личного кабинета")
    @Description("Пользователь может войти в конструктор по клику из личного кабинета")
    public void clickOnTheConstructorButton() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickPersonalAccountButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setValueInputEmail("vlad1986@mail.ru");
        authorizationPage.setValueInputPassword("job777");
        authorizationPage.clickEntranceButton();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickConstructButton();
        homePage.getCheckoutButton();
        homePage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();
        authorizationPage.getInputElement();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Переход по клику на логотип «Stellar Burgers» из личного кабинета")
    @Description("Пользователь может перейти по клику «Stellar Burgers» из личного кабинета")
    public void clickOnTheStellarBurgersButton() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickPersonalAccountButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setValueInputEmail("marina1988@mail.ru");
        authorizationPage.setValueInputPassword("job777");
        authorizationPage.clickEntranceButton();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickStellarBurgersButton();
        homePage.getCheckoutButton();
        homePage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();
        authorizationPage.getInputElement();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Выход по кнопке «Выход» в личном кабинете")
    @Description("Пользователь может выйти из личного кабинета по клику кнопки «Выход»")
    public void clickOnTheExitButton() throws InterruptedException {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickPersonalAccountButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.setValueInputEmail("alex1988@mail.ru");
        authorizationPage.setValueInputPassword("job777");
        authorizationPage.clickEntranceButton();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.clickExitButton();
        authorizationPage.getInputElement();
        Thread.sleep(1000);
    }

    @After
    public void deleteUser() {
        ValidatableResponse response = detailsUser.login(userAuthorization);
        accessToken = response.extract().path("accessToken");
        detailsUser.removal(accessToken);
    }
}
