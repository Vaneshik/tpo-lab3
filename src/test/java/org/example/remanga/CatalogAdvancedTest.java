package org.example.remanga;

import org.junit.jupiter.api.Test;

class CatalogAdvancedTest extends BaseTest {
    @Test
    void user_opens_advanced_catalog_filters() {
        catalogPage()
                .open()
                .openFilters()
                .shouldShowAdvancedFilters();
    }

    @Test
    void user_types_title_into_catalog_filter() {
        catalogPage()
                .open()
                .openFilters()
                .typeTitleFilter("Элисед")
                .shouldHaveTitleFilterValue("Элисед");
    }
}
