package org.example.remanga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CatalogTest extends BaseTest {
    @Test
    void user_opens_catalog_and_sees_filters_with_titles() {
        openPath("/catalog");

        assertTrue(
                waitUrlContainsAny("/catalog") || exists("//*[contains(normalize-space(.), 'Фильтры')]"),
                "После перехода должен открыться каталог"
        );
        assertVisible("//*[normalize-space(.)='Каталог']", "В каталоге должен быть заголовок");
        assertVisible("//button[normalize-space(.)='По популярности']", "В каталоге должна быть сортировка");
        assertVisible("//button[normalize-space(.)='Манга']", "В каталоге должен быть фильтр типа");
        assertVisible("//button[normalize-space(.)='Фильтры']", "В каталоге должна быть кнопка фильтров");
        assertAnyVisible("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "Каталог должен показывать список тайтлов");
    }

    @Test
    void user_applies_available_catalog_filter() {
        openPath("/catalog");

        click("//button[normalize-space(.)='Манхва']");

        assertAnyVisible("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "После выбора фильтра каталог должен продолжать показывать тайтлы");
    }
}
