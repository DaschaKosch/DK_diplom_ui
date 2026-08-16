package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static testdata.TestData.EMPTY_CART_MESSAGE;

public class CartPage {

    private final ElementsCollection cartItems = $$("[class*='sc-2d79c7ce'] a[href*='/product/']");

    @Step("Проверить, что корзина открылась")
    public CartPage verifyCartLoaded() {
        $(com.codeborne.selenide.Selectors.withText(EMPTY_CART_MESSAGE))
                .shouldBe(com.codeborne.selenide.Condition.visible);

        return this;
    }

    @Step("Проверить, что в корзине есть товары")
    public CartPage verifyCartHasItems() {
        cartItems.shouldHave(com.codeborne.selenide.CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить, что корзина пуста")
    public CartPage verifyCartIsEmpty() {
        $(com.codeborne.selenide.Selectors.withText(EMPTY_CART_MESSAGE))
                .shouldBe(com.codeborne.selenide.Condition.visible);
        return this;
    }
    @Step("Удалить первый товар из корзины")
    public CartPage removeFirstItem() {
        cartItems.shouldHave(com.codeborne.selenide.CollectionCondition.sizeGreaterThan(0),
                java.time.Duration.ofSeconds(5));
        com.codeborne.selenide.ElementsCollection minusButtons =
                $$("[data-testid='minus']");

        if (minusButtons.size() == 0) {
            throw new AssertionError("Кнопки удаления не найдены! Возможно, корзина пуста или структура изменилась.");
        }
        minusButtons.first()
                .shouldBe(com.codeborne.selenide.Condition.visible, java.time.Duration.ofSeconds(5))
                .click(com.codeborne.selenide.ClickOptions.usingJavaScript());

        return this;
    }

    @Step("Получить URL текущей страницы")
    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}
