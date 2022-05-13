package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class PersonalAccountPage {

    //локатор кнопки "Конструктор"
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__link__3D_hX")
    public ElementsCollection constructButton;

    //локатор кнопки "Stellar burgers"
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgersButton;

    //локатор кнопки "Выход"
    @FindBy(how = How.XPATH,using = ".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement exitButton;

    //локатор текста "В этом разделе вы можете изменить свои персональные данные"
    @FindBy(how = How.XPATH,using = ".//p[@class='Account_text__fZAIn text text_type_main-default']")
    private SelenideElement elementText;


    //метод получения локатора текста "В этом разделе вы можете изменить свои персональные данные"
    public void getElementText() {
        elementText.shouldBe(visible);
    }

    //метод клика по кнопке "Конструктор"
    public void clickConstructButton() {
        constructButton.get(0).click();
    }

    //метод клика по логотипу "Stellar Burgers"
    public void clickStellarBurgersButton() {
        stellarBurgersButton.click();
    }

    //метод клика по кнопке "Выход"
    public void clickExitButton() {
        exitButton.click();
    }
}
