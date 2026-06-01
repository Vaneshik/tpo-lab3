package org.example.remanga.pages;

import org.example.remanga.BaseTest;

public class CommunityPage extends BasePage {
    public CommunityPage(BaseTest test) {
        super(test);
    }

    public CommunityPage openPublisher() {
        open("/publisher/kartnadzor/about");
        return this;
    }

    public CommunityPage openGuild() {
        open("/guild/testovaja-gi-4435669b/about");
        return this;
    }

    public void shouldShowPublisher() {
        shouldSee("//*[contains(normalize-space(.), 'Картнадзор')]", "Страница паблишера должна содержать название");
        shouldSee("//*[contains(normalize-space(.), 'Контакты')]", "Страница паблишера должна содержать контакты");
        shouldSee("//*[contains(normalize-space(.), 'Участники')]", "Страница паблишера должна содержать участников");
        shouldSee("//*[contains(normalize-space(.), 'Подписчики')]", "Страница паблишера должна содержать подписчиков");
    }

    public void shouldShowGuild() {
        shouldSee("//*[contains(normalize-space(.), 'НЕОфициальная РЕманга')]",
                "Страница гильдии должна содержать название");
        shouldSee("//*[contains(normalize-space(.), 'О гильдии')]", "Страница гильдии должна содержать описание");
        shouldSee("//*[contains(normalize-space(.), 'Бонусы')]", "Страница гильдии должна содержать бонусы");
        shouldSee("//*[contains(normalize-space(.), 'Состав')]", "Страница гильдии должна содержать состав");
    }
}
