package org.example.remanga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogAdvancedTest extends BaseTest {
    @Test
    void user_opens_advanced_catalog_filters() {
        openPath("/catalog");

        click("//button[normalize-space(.)='Фильтры']");

        assertVisible("//input[@placeholder='Поиск по названию']", "В фильтрах должен быть поиск по названию");
        assertVisible("//input[@placeholder='От']", "В фильтрах должен быть ввод нижней границы года");
        assertVisible("//input[@placeholder='До']", "В фильтрах должен быть ввод верхней границы года");
        assertVisible("//button[contains(normalize-space(.), 'Сбросить фильтры')]",
                "В фильтрах должна быть команда сброса");
        assertVisible("//*[normalize-space(.)='Жанры']", "В фильтрах должен быть раздел жанров");
    }

    @Test
    void user_types_title_into_catalog_filter() {
        openPath("/catalog");

        click("//button[normalize-space(.)='Фильтры']");
        String titleFilter = "//input[@placeholder='Поиск по названию']";
        type(titleFilter, "Элисед");

        assertEquals("Элисед", valueOfFirstVisible(titleFilter),
                "Поле поиска по каталогу должно принимать название тайтла");
    }
}
