package org.example.remanga;

import org.junit.jupiter.api.Test;

class HomePageTest extends BaseTest {
    @Test
    void home_page_contains_navigation_and_title_sections() {
        homePage().open().shouldShowMainSections();
    }
}
