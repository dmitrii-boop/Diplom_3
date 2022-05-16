//главная страница
package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class HomePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки "Личный кабинет"
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__link__3D_hX")
    public ElementsCollection personalAccountButton;

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement signInButton;

    //локатор кнопок "Булки Соусы Начинки"
    @FindBy(how = How.XPATH,using = ".//span[@class='text text_type_main-default']")
    public ElementsCollection bunsSaucesToppingsButtons;

    //локатор разделов "Булки Соусы Начинки"
    @FindBy(how = How.XPATH,using = ".//h2[@class='text text_type_main-medium mb-6 mt-10']")
    public ElementsCollection bunsSaucesToppingsChapters;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement checkoutButton;


    //метод клика по кнопке "Войти в аккаунт"
    public void clickSignInButton() {
        signInButton.click();
    }

    //метод клика по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        personalAccountButton.get(2).click();
    }

    //метод получения локатора кнопки "Оформить заказ"
    public void assertCheckoutButtonVisible() {
        checkoutButton.shouldBe(visible);
    }

    //метод клика по кнопке "Соусы"
    public void clickSaucesButton() {
        bunsSaucesToppingsButtons.get(1).click();
    }

    //метод клика по кнопке "Начинки"
    public void clickToppingsButton() {
        bunsSaucesToppingsButtons.get(2).click();
    }

    //метод клика по кнопке "Булки"
    public void clickBunsButton() {
        bunsSaucesToppingsButtons.get(0).click();
    }

    //метод получения локатора раздела "Соусы"
    public void assertSaucesChaptersVisible() {
        bunsSaucesToppingsChapters.get(1).shouldBe(visible);
    }

    //метод получения локатора раздела "Начинки"
    public void assertToppingsChaptersVisible() {
        bunsSaucesToppingsChapters.get(2).shouldBe(visible);
    }

    //метод получения локатора раздела "Булки"
    public void assertBunsChaptersVisible() {
        bunsSaucesToppingsChapters.get(0).shouldBe(visible);
    }
}
