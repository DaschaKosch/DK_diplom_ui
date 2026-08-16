package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import testdata.TestData;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.TestData.*;

@Owner("Darya Koshman")
@Epic("UI Тестирование Befree")
@Feature("Главная страница")

public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    TestData td = new TestData();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка хэдера на главной странице")
    @Description("Проверка логотипа, меню, корзины")
    void shouldDisplayHeaderOnMainPage() {

        mainPage.openPage()
                .acceptCookies()
                .verifyHeaderIsCorrect();

        assertThat(title())
                .as("Заголовок должен содержать 'Befree'")
                .containsIgnoringCase(SITE_TITLE);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск товара через строку поиска")
    @Description("Ввод запроса и проверка отображения результатов")
    void shouldDisplayProductsWhenSearchHasResults() {
        mainPage.openPage().acceptCookies().searchFor(td.searchQueryValid);
        $$(".digi-product__label").shouldHave(sizeGreaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Открытие корзины")
    @Description("Проверка перехода на страницу корзины")
    void shouldOpenCart() {
        CartPage cartPage = mainPage.openPage()
                .acceptCookies()
                .openCart();
        cartPage.verifyCartLoaded();
        assertThat(cartPage.getCurrentUrl())
                .as("URL должен указывать на страницу корзины")
                .containsIgnoringCase(CART_PAGE);
    }
}


