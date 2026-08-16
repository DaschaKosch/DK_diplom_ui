package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {


        private final SelenideElement productName = $("[data-testid*='title']");
        private final SelenideElement addToCartButton = $(byAttribute("data-testid", "product-button-add-cart"));

        @Step("Проверить, что страница товара загрузилась")
        public ProductPage verifyProductLoaded() {
            productName.shouldBe(visible);
            return this;
        }

    @Step("Выбрать первый доступный размер")
    public ProductPage selectFirstAvailableSize() {
        $$("[data-testid^='product-size-']")
                .first()
                .shouldBe(visible, Duration.ofSeconds(5))
                .click(ClickOptions.usingJavaScript());

        return this;
    }

        @Step("Добавить товар в корзину")
        public ProductPage addToCart() {
            addToCartButton.shouldBe(visible).scrollTo().click();
            return this;
        }

        @Step("Перейти в корзину")
        public CartPage goToCart() {
            $("[data-testid='header-cart-link']").click();
            return new CartPage();
        }
    }

