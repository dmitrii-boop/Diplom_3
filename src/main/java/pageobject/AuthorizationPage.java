//страница авторизации
package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class AuthorizationPage {

    //локатор кнопок "Зарегистрироваться", "Восстановить пароль"
    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    public ElementsCollection registerRestorePasswordButtons;

    //локатор надписи "Вход"
    @FindBy(how = How.CLASS_NAME,using = "Auth_login__3hAey")
    public SelenideElement inscriptionEntrance;

    //локатор полей "Email", "Пароль"
    @FindBy(how = How.XPATH,using = ".//input[@class='text input__textfield text_type_main-default']")
    public ElementsCollection fieldsEmailPassword;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement entranceButton;


    //метод клика по кнопке "Зарегистрироваться"
    public void clickRegisterButton() {
        registerRestorePasswordButtons.get(0).click();
    }

    //метод получения локатора надписи "Вход"
    public void assertInscriptionEntranceVisible() {
        inscriptionEntrance.shouldBe(visible, Duration.ofSeconds(10));
    }

    //метод заполнения поля "Email"
    public void setValueInputEmail(String email) {
        fieldsEmailPassword.get(0).setValue(email);
    }

    //метод заполнения поля "Пароль"
    public void setValueInputPassword(String password) {
        fieldsEmailPassword.get(1).setValue(password);
    }

    //метод клика по кнопке "Войти"
    public void clickEntranceButton() {
        entranceButton.click();
    }

    //метод клика по кнопке "Восстановить пароль"
    public void clickRestorePasswordButton() {
        registerRestorePasswordButtons.get(1).click();
    }

}
