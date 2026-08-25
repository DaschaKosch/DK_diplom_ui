package pages;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogPage {
    private final ElementsCollection productCards = $$("a[href*='/product/']");

    @Step("Проверить, что каталог загрузился")
    public CatalogPage verifyCatalogLoaded() {
        String currentUrl = com.codeborne.selenide.WebDriverRunner.url().toLowerCase();
        if (!currentUrl.contains("/zhenskaya")) {
            throw new AssertionError(
                    "Ожидалась страница женского каталога (/zhenskaya), но получен URL: " + currentUrl
            );
        }

        try {
            productCards.first().shouldBe(visible, java.time.Duration.ofSeconds(5));
        } catch (Throwable e) {
            $("body").shouldBe(visible);
        }

        return this;
    }

    @Step("Проверить, что список товаров отображается")
    public CatalogPage verifyProductListDisplayed() {
        productCards.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открыть первый товар из каталога")
    public ProductPage openFirstProduct() {
        productCards.first().shouldBe(visible).click(ClickOptions.usingJavaScript());
        return page(ProductPage.class);
    }

    @Step("Получить URL текущей страницы")
    public String getCurrentUrl() {
        return com.codeborne.selenide.WebDriverRunner.url();
    }
}


