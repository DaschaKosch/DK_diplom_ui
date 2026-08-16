package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Darya Koshman")
@Epic("UI Тестирование Befree")
@Feature("Корзина")
public class CartTests extends TestBase {

    private final MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка пустой корзины при переходе с главной")
    @Description("Переход в корзину и проверка сообщения об отсутствии товаров")
    void shouldOpenEmptyCartFromMainPage() {
        CartPage cartPage = mainPage.openPage()
                .acceptCookies()
                .openCart();
        cartPage.verifyCartLoaded()
                .verifyCartIsEmpty();
        assertThat(cartPage.getCurrentUrl())
                .as("URL должен указывать на страницу корзины")
                .containsIgnoringCase("cart");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Добавление товара в корзину")
    @Description("Полный сценарий: Каталог → Товар → Выбор размера → Корзина")
    void shouldAddProductToCart() {
        CartPage cartPage = mainPage.openPage()
                .acceptCookies()
                .goToWomenSection()
                .verifyCatalogLoaded()
                .openFirstProduct()
                .verifyProductLoaded()
                .selectFirstAvailableSize()
                .addToCart()
                .goToCart();

        cartPage.verifyCartHasItems();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Удаление товара из корзины")
    @Description("Добавление товара → удаление товара → проверка пустой корзины")
    void shouldRemoveProductFromCart() {
        CartPage cartPage = mainPage.openPage()
                .acceptCookies()
                .goToWomenSection()
                .openFirstProduct()
                .selectFirstAvailableSize()
                .addToCart()
                .goToCart();

        cartPage.verifyCartHasItems()
                .removeFirstItem()
                .verifyCartIsEmpty();
    }
}