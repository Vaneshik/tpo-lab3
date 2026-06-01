package org.example.remanga;

import org.junit.jupiter.api.Test;

class HomePageTest extends BaseTest {
    @Test
    void home_page_contains_navigation_and_title_sections() {
        openHomePage();

        assertVisible("//a[contains(normalize-space(.), 'Каталог')]", "В навигации должна быть ссылка на каталог");
        assertVisible("//a[contains(normalize-space(.), 'Топы') and contains(@href, '/manga/top')]", "В навигации должна быть ссылка на топы");
        assertVisible("//a[contains(normalize-space(.), 'Форум') and contains(@href, '/forum/feed')]", "В навигации должна быть ссылка на форум");
        assertVisible("//button[normalize-space(.)='Что ищем, семпай?']", "На главной должен быть доступен поиск");
        assertVisible("//*[contains(normalize-space(.), 'Горячие новинки') or contains(normalize-space(.), 'Твой чит-код на ReManga')]",
                "На главной должен быть контентный блок с подборками");
        assertAnyVisible("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "На главной должны отображаться карточки или ссылки на тайтлы");
    }
}
