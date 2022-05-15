package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage {

    //локатор кнопки "Войти"
    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement loginButton;

    //метод клика по кнопке "Войти"
    public void clickLoginButton() {
        loginButton.click();
    }
}
