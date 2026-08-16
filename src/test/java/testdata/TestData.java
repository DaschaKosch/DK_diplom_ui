package testdata;

import net.datafaker.Faker;

public class TestData {
    private final Faker faker = new Faker();

    public static final String WOMEN_CATALOG = "/zhenskaya";
    public static final String CART_PAGE = "/cart";
    public static final String SITE_TITLE = "Befree";
    public static final String EMPTY_CART_MESSAGE = "здесь пока пусто";
    public static final String COOKIE_ACCEPT_TEXT = "ОК";
    public final String searchQueryValid = faker.options().option(
            "платье", "футболка", "джинсы", "юбка", "блузка",
            "свитер", "куртка", "пальто", "рубашка", "брюки"
    );

}