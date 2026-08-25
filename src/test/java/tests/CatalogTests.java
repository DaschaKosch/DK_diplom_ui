package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.ProductPage;
import static org.assertj.core.api.Assertions.assertThat;


    @Owner("Darya Koshman")
    @Epic("UI Тестирование Befree")
    @Feature("Навигация в каталоге")
    public class CatalogTests extends TestBase {

        @Test
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Переход в каталог 'Женское' с главной страницы")
        @Description("Проверка корректности перехода и URL раздела")
        void shouldNavigateToWomenCatalog() {
            CatalogPage catalogPage = mainPage.openPage()
                    .acceptCookies()
                    .goToWomenSection();
            catalogPage.verifyCatalogLoaded();
            assertThat(catalogPage.getCurrentUrl())
                    .as("URL должен содержать раздел женской одежды")
                    .containsIgnoringCase("zhenskaya");
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @DisplayName("Проверка отображения списка товаров в каталоге")
        @Description("Убеждаемся, что каталог не пустой и товары загружены")
        void shouldDisplayProductListInCatalog() {
            mainPage.openPage()
                    .acceptCookies()
                    .goToWomenSection()
                    .verifyCatalogLoaded()
                    .verifyProductListDisplayed();
        }

        @Test
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Открытие страницы товара из каталога")
        @Description("Клик по первому товару и проверка загрузки страницы продукта")
        void shouldOpenProductPageFromCatalog() {
            ProductPage productPage = mainPage.openPage()
                    .acceptCookies()
                    .goToWomenSection()
                    .verifyCatalogLoaded()
                    .openFirstProduct();

            productPage.verifyProductLoaded();
        }
    }

