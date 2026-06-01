package org.example.remanga;

import org.junit.jupiter.api.Test;

class NavigationTest extends BaseTest {
    @Test
    void user_opens_tops_and_first_title() {
        openPath("/manga/top");

        assertVisible("//*[normalize-space(.)='Топы']", "Должен открыться раздел топов");
        assertVisible("//a[normalize-space(.)='Новинок' and contains(@href, 'period=new')]", "В топах должен быть фильтр периода");
        assertVisible("//a[normalize-space(.)='Месяца' and contains(@href, 'period=monthly')]", "В топах должен быть фильтр месяца");
        assertAnyVisible("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "В топах должен быть список тайтлов");
        openFirstTitleFromCurrentPage();

        assertVisible("//h1 | //a[normalize-space(.)='Читать'] | //button[contains(normalize-space(.), 'Главы')]",
                "Из топов должен открываться тайтл");
    }

    @Test
    void user_opens_news_or_forum_section() {
        openPath("/forum/feed?ordering=-id&week=0");

        assertVisible("//a[contains(normalize-space(.), 'Форум') and contains(@href, '/forum/feed')]",
                "Должен открыться форумный раздел");
        assertVisible("//*[normalize-space(.)='Популярное за неделю'] | //button[normalize-space(.)='Новости сайта']",
                "На форуме должны отображаться категории или популярные записи");
        assertAnyVisible("//a[contains(@href, '/forum/') and string-length(normalize-space(.)) > 1]",
                "На форуме должен быть список записей");
    }

    @Test
    void user_sees_title_collections() {
        openPath("/manga/%3C29.04.2026%3Eeleceed_/main");

        assertVisible("//*[normalize-space(.)='Коллекции по произведению']", "На странице тайтла должен быть блок коллекций");
        assertAnyVisible("//a[contains(@href, '/collections/') and string-length(normalize-space(.)) > 1]",
                "В блоке коллекций должны быть ссылки на коллекции");
    }
}
