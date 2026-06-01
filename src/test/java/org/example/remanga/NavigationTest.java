package org.example.remanga;

import org.junit.jupiter.api.Test;

class NavigationTest extends BaseTest {
    @Test
    void user_opens_tops_and_first_title() {
        topPage().open().shouldShowTops();

        topPage().openFirstTitle();
        titlePage().shouldOpenFromList();
    }

    @Test
    void user_opens_news_or_forum_section() {
        forumPage().open().shouldShowForum();
    }

    @Test
    void user_sees_title_collections() {
        titlePage()
                .openEleceed()
                .shouldShowCollections();
    }
}
