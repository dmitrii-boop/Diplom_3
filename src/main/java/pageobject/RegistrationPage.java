//страница регистрации
package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationPage {

    //локатор полей "Имя", "Email", "Пароль"
    @FindBy(how = How.XPATH,using = ".//input[@class='text input__textfield text_type_main-default']")
    public ElementsCollection nameEmailPasswordInputFields;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement loginButton;

    //локатор надписи "Некорректный пароль"
    @FindBy(how = How.XPATH,using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement messageWrongPassword;


    //метод заполнения поля "Имя"
    public void setValueInputName(String name) {
        nameEmailPasswordInputFields.get(0).setValue(name);
    }

    //метод заполнения поля "Email"
    public void setValueInputEmail(String email) {
        nameEmailPasswordInputFields.get(1).setValue(email);
    }

    //метод заполнения поля "Пароль"
    public void setValueInputPassword(String password) {
        nameEmailPasswordInputFields.get(2).setValue(password);
    }

    //метод клика по кнопке "Зарегистрироваться"
    public void clickRegisterButton() {
        registerButton.click();
    }

    //метод получения локатора надписи "Некорректный пароль"
    public void assertMessageWrongPassword() {
        messageWrongPassword.shouldBe(visible);
    }

    //метод клика по кнопке "Войти"
    public void clickLoginButton() {
        loginButton.click();
    }

}
