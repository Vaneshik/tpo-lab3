package org.example.remanga.pages;

import org.example.remanga.BaseTest;

public class HomePage extends BasePage {
    public HomePage(BaseTest test) {
        super(test);
    }

    public HomePage open() {
        test.openHomePage();
        return this;
    }

    public void shouldShowMainSections() {
        shouldSee("//a[contains(normalize-space(.), 'Каталог')]", "В навигации должна быть ссылка на каталог");
        shouldSee("//a[contains(normalize-space(.), 'Топы') and contains(@href, '/manga/top')]", "В навигации должна быть ссылка на топы");
        shouldSee("//a[contains(normalize-space(.), 'Форум') and contains(@href, '/forum/feed')]", "В навигации должна быть ссылка на форум");
        shouldSee("//button[normalize-space(.)='Что ищем, семпай?']", "На главной должен быть доступен поиск");
        shouldSee("//*[contains(normalize-space(.), 'Горячие новинки') or contains(normalize-space(.), 'Твой чит-код на ReManga')]",
                "На главной должна быть лента тайтлов");
        shouldSeeAny("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "На главной должны быть карточки тайтлов");
    }
}
