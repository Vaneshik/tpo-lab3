package org.example.remanga.pages;

import org.example.remanga.BaseTest;
import org.junit.jupiter.api.Assertions;

public class TitlePage extends BasePage {
    static final String ELECEED_PATH = "/manga/%3C29.04.2026%3Eeleceed_/main";

    public TitlePage(BaseTest test) {
        super(test);
    }

    public TitlePage openEleceed() {
        open(ELECEED_PATH);
        return this;
    }

    public TitlePage openFirstFromCurrentPage() {
        test.openFirstTitleFromCurrentPage();
        return this;
    }

    public TitlePage openChapters() {
        click("//button[@role='tab' and contains(normalize-space(.), 'Главы')]");
        return this;
    }

    public TitlePage openDiscussions() {
        click("//button[@role='tab' and contains(normalize-space(.), 'Обсуждения')]");
        return this;
    }

    public TitlePage openMoments() {
        click("//button[@role='tab' and contains(normalize-space(.), 'Моменты')]");
        return this;
    }

    public TitlePage openCards() {
        click("//button[@role='tab' and contains(normalize-space(.), 'Карты')]");
        return this;
    }

    public TitlePage openCharacters() {
        click("//button[@role='tab' and contains(normalize-space(.), 'Персонажи')]");
        return this;
    }

    public TitlePage openVoiceover() {
        click("//button[@role='tab' and contains(normalize-space(.), 'Озвучка')]");
        return this;
    }

    public void shouldShowTitlePage() {
        Assertions.assertFalse(test.browserTitle().isBlank(), "У страницы тайтла должен быть заголовок браузера");
        shouldSee("//h1[normalize-space(.)='Элисед']", "На странице тайтла должно быть название");
        shouldSee("//a[normalize-space(.)='Читать' and contains(@href, '/manga/')]", "На странице тайтла должна быть кнопка чтения");
        shouldSee("//button[contains(normalize-space(.), 'Главы')]", "На странице тайтла должна быть вкладка глав");
        shouldSee("//*[contains(normalize-space(.), 'Лайков:') and contains(normalize-space(.), 'Просмотров:')]",
                "На странице тайтла должна быть статистика");
    }

    public void shouldOpenFromList() {
        shouldSee("//h1 | //a[normalize-space(.)='Читать'] | //button[contains(normalize-space(.), 'Главы')]",
                "Из списка должен открываться тайтл");
    }

    public void shouldShowBookmarkAction() {
        shouldSee("//button[contains(normalize-space(.), 'В закладки')]"
                        + " | //button[contains(normalize-space(.), 'Заклад')]",
                "На странице тайтла авторизованному пользователю должны быть доступны пользовательские действия");
    }

    public void shouldShowCollections() {
        shouldSee("//*[normalize-space(.)='Коллекции по произведению']", "На странице тайтла должен быть блок коллекций");
        shouldSeeAny("//a[contains(@href, '/collections/') and string-length(normalize-space(.)) > 1]",
                "В блоке коллекций должны быть ссылки на коллекции");
    }

    public void shouldShowChaptersTab() {
        Assertions.assertTrue(urlContains("/chapters"), "После клика должна открыться вкладка глав");
        shouldSeeTitleHeader();
        shouldSee("//input[@placeholder='Поиск']", "На вкладке глав должен быть поиск по главам");
        shouldSeeAny("//a[contains(@href, '/manga/') and contains(normalize-space(.), 'Глава')]",
                "На вкладке глав должны отображаться главы");
    }

    public void shouldShowDiscussionsTab() {
        Assertions.assertTrue(urlContains("/posts"), "После клика должна открыться вкладка обсуждений");
        shouldSeeTitleHeader();
        shouldSee("//a[contains(@href, '/forum/create') and contains(normalize-space(.), 'Создать обсуждение')]"
                        + " | //*[contains(normalize-space(.), 'Создать обсуждение')]",
                "На вкладке обсуждений должна быть команда создания обсуждения");
        shouldSee("//a[contains(@href, '/forum/feed') and contains(normalize-space(.), 'На форум')]"
                        + " | //*[contains(normalize-space(.), 'На форум')]",
                "На вкладке обсуждений должна быть ссылка на форум");
    }

    public void shouldShowMomentsTab() {
        Assertions.assertTrue(urlContains("/moments"), "После клика должна открыться вкладка моментов");
        shouldSeeTitleHeader();
        shouldSee("//button[@role='tab' and contains(normalize-space(.), 'Моменты')]",
                "Вкладка моментов должна быть доступна");
        shouldSeeAny("//*[string-length(normalize-space(.)) > 20 and not(self::script)]",
                "На вкладке моментов должен отображаться пользовательский контент");
    }

    public void shouldShowCardsTab() {
        Assertions.assertTrue(urlContains("/cards"), "После клика должна открыться вкладка карт");
        shouldSee("//*[contains(normalize-space(.), 'Прогресс коллекции карт')]",
                "На вкладке карт должен быть прогресс коллекции");
        shouldSee("//button[@role='tab' and contains(normalize-space(.), 'Карты')]",
                "Вкладка карт должна быть доступна");
    }

    public void shouldShowCharactersTab() {
        Assertions.assertTrue(urlContains("/characters"), "После клика должна открыться вкладка персонажей");
        shouldSeeTitleHeader();
        shouldSeeAny("//a[contains(@href, '/characters') or contains(normalize-space(.), 'Кайден') or contains(normalize-space(.), 'Со Джи У')]",
                "На вкладке персонажей должны отображаться персонажи");
    }

    public void shouldShowVoiceoverTab() {
        Assertions.assertTrue(urlContains("/voiceover"), "После клика должна открыться вкладка озвучки");
        shouldSeeTitleHeader();
        shouldSee("//button[@role='tab' and normalize-space(.)='Озвучка']",
                "Вкладка озвучки должна быть доступна");
        shouldSee("//*[contains(normalize-space(.), 'Оставить комментарий') or contains(normalize-space(.), 'Sygest')]",
                "На вкладке озвучки должен быть контент озвучки или комментарии");
    }

    private void shouldSeeTitleHeader() {
        shouldSee("//h1[normalize-space(.)='Элисед']", "Название тайтла должно оставаться видимым");
    }
}
