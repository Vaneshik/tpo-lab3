package org.example.remanga;

import org.junit.jupiter.api.Test;

class SearchAndTitleTest extends BaseTest {
    @Test
    void user_opens_search_and_types_query() {
        homePage().open();

        searchPage()
                .openFromHome()
                .search("Элисед")
                .shouldContainQuery("Элисед");
    }

    @Test
    void user_opens_title_card_from_home_page() {
        titlePage().openEleceed().shouldShowTitlePage();
    }
}
