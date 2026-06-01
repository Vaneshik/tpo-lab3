package org.example.remanga.pages;

import org.example.remanga.BaseTest;
import org.junit.jupiter.api.Assertions;

public class CatalogPage extends BasePage {
    private static final String TITLE_FILTER = "//input[@placeholder='Поиск по названию']";

    public CatalogPage(BaseTest test) {
        super(test);
    }

    public CatalogPage open() {
        open("/catalog");
        return this;
    }

    public CatalogPage openFilters() {
        click("//button[normalize-space(.)='Фильтры']");
        return this;
    }

    public CatalogPage applyManhwaFilter() {
        click("//button[normalize-space(.)='Манхва']");
        return this;
    }

    public CatalogPage typeTitleFilter(String title) {
        type(TITLE_FILTER, title);
        return this;
    }

    public void shouldShowCatalog() {
        Assertions.assertTrue(urlContains("/catalog") || exists("//*[contains(normalize-space(.), 'Фильтры')]"),
                "После перехода должен открыться каталог");
        shouldSee("//*[normalize-space(.)='Каталог']", "В каталоге должен быть заголовок");
        shouldSee("//button[normalize-space(.)='По популярности']", "В каталоге должна быть сортировка");
        shouldSee("//button[normalize-space(.)='Манга']", "В каталоге должен быть фильтр типа");
        shouldSee("//button[normalize-space(.)='Фильтры']", "В каталоге должна быть кнопка фильтров");
        shouldShowTitles();
    }

    public void shouldShowTitles() {
        shouldSeeAny("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "Каталог должен показывать список тайтлов");
    }

    public void shouldShowAdvancedFilters() {
        shouldSee(TITLE_FILTER, "В фильтрах должен быть поиск по названию");
        shouldSee("//input[@placeholder='От']", "В фильтрах должен быть ввод нижней границы года");
        shouldSee("//input[@placeholder='До']", "В фильтрах должен быть ввод верхней границы года");
        shouldSee("//button[contains(normalize-space(.), 'Сбросить фильтры')]",
                "В фильтрах должна быть команда сброса");
        shouldSee("//*[normalize-space(.)='Жанры']", "В фильтрах должен быть раздел жанров");
    }

    public void shouldHaveTitleFilterValue(String title) {
        Assertions.assertEquals(title, value(TITLE_FILTER), "Поле поиска по каталогу должно принимать название тайтла");
    }
}
