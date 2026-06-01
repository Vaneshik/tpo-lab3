package org.example.remanga;

import org.junit.jupiter.api.Test;

class CatalogTest extends BaseTest {
    @Test
    void user_opens_catalog_and_sees_filters_with_titles() {
        catalogPage().open().shouldShowCatalog();
    }

    @Test
    void user_applies_available_catalog_filter() {
        catalogPage()
                .open()
                .applyManhwaFilter()
                .shouldShowTitles();
    }
}
