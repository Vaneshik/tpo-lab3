package org.example.remanga;

import org.junit.jupiter.api.Test;

class CommunityPagesTest extends BaseTest {
    @Test
    void user_opens_publisher_page() {
        openPath("/publisher/kartnadzor/about");

        assertVisible("//*[contains(normalize-space(.), 'Картнадзор')]", "Страница паблишера должна содержать название");
        assertVisible("//*[contains(normalize-space(.), 'Контакты')]", "Страница паблишера должна содержать контакты");
        assertVisible("//*[contains(normalize-space(.), 'Участники')]", "Страница паблишера должна содержать участников");
        assertVisible("//*[contains(normalize-space(.), 'Подписчики')]", "Страница паблишера должна содержать подписчиков");
    }

    @Test
    void user_opens_guild_page() {
        openPath("/guild/testovaja-gi-4435669b/about");

        assertVisible("//*[contains(normalize-space(.), 'НЕОфициальная РЕманга')]",
                "Страница гильдии должна содержать название");
        assertVisible("//*[contains(normalize-space(.), 'О гильдии')]", "Страница гильдии должна содержать описание");
        assertVisible("//*[contains(normalize-space(.), 'Бонусы')]", "Страница гильдии должна содержать бонусы");
        assertVisible("//*[contains(normalize-space(.), 'Состав')]", "Страница гильдии должна содержать состав");
    }
}
