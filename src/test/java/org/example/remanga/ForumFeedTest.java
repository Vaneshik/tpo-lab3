package org.example.remanga;

import org.junit.jupiter.api.Test;

class ForumFeedTest extends BaseTest {
    @Test
    void user_filters_forum_by_category() {
        forumPage()
                .open()
                .filterByNews()
                .shouldShowNewsFilterAndPosts();
    }

    @Test
    void user_searches_forum_posts() {
        forumPage()
                .open()
                .search("обмен")
                .shouldShowPosts();
    }

    @Test
    void user_opens_forum_post() {
        forumPage()
                .open()
                .openFirstPost()
                .shouldShowPostPage();
    }
}
