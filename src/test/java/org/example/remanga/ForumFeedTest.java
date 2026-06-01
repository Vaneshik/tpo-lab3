package org.example.remanga;

import org.junit.jupiter.api.Test;

class ForumFeedTest extends BaseTest {
    @Test
    void user_filters_forum_by_category() {
        openPath("/forum/feed?ordering=-id&week=0");

        click("//button[normalize-space(.)='Новости сайта']");

        assertVisible("//button[normalize-space(.)='Новости сайта']", "Выбранная категория должна оставаться доступной");
        assertAnyVisible("//a[contains(@href, '/forum/') and string-length(normalize-space(.)) > 1]",
                "После выбора категории форум должен показывать записи");
    }

    @Test
    void user_searches_forum_posts() {
        openPath("/forum/feed?ordering=-id&week=0");

        String searchInput = "//input[@name='search_term_string' and @placeholder='Поиск постов']";
        type(searchInput, "обмен");

        assertVisible(searchInput, "Поле поиска постов должно оставаться доступным");
        assertAnyVisible("//a[contains(@href, '/forum/') and string-length(normalize-space(.)) > 1]",
                "Форум должен показывать записи при работе с поиском");
    }

    @Test
    void user_opens_forum_post() {
        openPath("/forum/feed?ordering=-id&week=0");

        click("(//a[contains(@href, '/forum/') and not(contains(@href, '/forum/feed')) and string-length(normalize-space(.)) > 1])[1]");

        assertVisible("//a[contains(@href, '/forum/feed') and contains(normalize-space(.), 'Форум')]"
                        + " | //button[contains(normalize-space(.), 'Ответить')]"
                        + " | //*[contains(normalize-space(.), 'Комментарии')]",
                "Должна открыться страница записи форума");
    }
}
