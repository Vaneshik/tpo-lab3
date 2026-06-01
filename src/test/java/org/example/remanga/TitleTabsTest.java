package org.example.remanga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TitleTabsTest extends BaseTest {
    private static final String ELECEED_PATH = "/manga/%3C29.04.2026%3Eeleceed_/main";

    @Test
    void user_opens_title_chapters_tab() {
        openPath(ELECEED_PATH);

        click("//button[@role='tab' and contains(normalize-space(.), 'Главы')]");

        assertTrue(waitUrlContainsAny("/chapters"), "После клика должна открыться вкладка глав");
        assertVisible("//h1[normalize-space(.)='Элисед']", "Название тайтла должно оставаться видимым");
        assertVisible("//input[@placeholder='Поиск']", "На вкладке глав должен быть поиск по главам");
        assertAnyVisible("//a[contains(@href, '/manga/') and contains(normalize-space(.), 'Глава')]",
                "На вкладке глав должны отображаться главы");
    }

    @Test
    void user_opens_title_discussions_tab() {
        openPath(ELECEED_PATH);

        click("//button[@role='tab' and contains(normalize-space(.), 'Обсуждения')]");

        assertTrue(waitUrlContainsAny("/posts"), "После клика должна открыться вкладка обсуждений");
        assertVisible("//h1[normalize-space(.)='Элисед']", "Название тайтла должно оставаться видимым");
        assertVisible("//a[contains(@href, '/forum/create') and contains(normalize-space(.), 'Создать обсуждение')]"
                        + " | //*[contains(normalize-space(.), 'Создать обсуждение')]",
                "На вкладке обсуждений должна быть команда создания обсуждения");
        assertVisible("//a[contains(@href, '/forum/feed') and contains(normalize-space(.), 'На форум')]"
                        + " | //*[contains(normalize-space(.), 'На форум')]",
                "На вкладке обсуждений должна быть ссылка на форум");
    }

    @Test
    void user_opens_title_moments_tab() {
        openPath(ELECEED_PATH);

        click("//button[@role='tab' and contains(normalize-space(.), 'Моменты')]");

        assertTrue(waitUrlContainsAny("/moments"), "После клика должна открыться вкладка моментов");
        assertVisible("//h1[normalize-space(.)='Элисед']", "Название тайтла должно оставаться видимым");
        assertVisible("//button[@role='tab' and contains(normalize-space(.), 'Моменты')]",
                "Вкладка моментов должна быть доступна");
        assertAnyVisible("//*[string-length(normalize-space(.)) > 20 and not(self::script)]",
                "На вкладке моментов должен отображаться пользовательский контент");
    }

    @Test
    void user_opens_title_cards_tab() {
        openPath(ELECEED_PATH);

        click("//button[@role='tab' and contains(normalize-space(.), 'Карты')]");

        assertTrue(waitUrlContainsAny("/cards"), "После клика должна открыться вкладка карт");
        assertVisible("//*[contains(normalize-space(.), 'Прогресс коллекции карт')]",
                "На вкладке карт должен быть прогресс коллекции");
        assertVisible("//button[@role='tab' and contains(normalize-space(.), 'Карты')]",
                "Вкладка карт должна быть доступна");
    }

    @Test
    void user_opens_title_characters_tab() {
        openPath(ELECEED_PATH);

        click("//button[@role='tab' and contains(normalize-space(.), 'Персонажи')]");

        assertTrue(waitUrlContainsAny("/characters"), "После клика должна открыться вкладка персонажей");
        assertVisible("//h1[normalize-space(.)='Элисед']", "Название тайтла должно оставаться видимым");
        assertAnyVisible("//a[contains(@href, '/characters') or contains(normalize-space(.), 'Кайден') or contains(normalize-space(.), 'Со Джи У')]",
                "На вкладке персонажей должны отображаться персонажи");
    }

    @Test
    void user_opens_title_voiceover_tab() {
        openPath(ELECEED_PATH);

        click("//button[@role='tab' and contains(normalize-space(.), 'Озвучка')]");

        assertTrue(waitUrlContainsAny("/voiceover"), "После клика должна открыться вкладка озвучки");
        assertVisible("//h1[normalize-space(.)='Элисед']", "Название тайтла должно оставаться видимым");
        assertVisible("//button[@role='tab' and normalize-space(.)='Озвучка']",
                "Вкладка озвучки должна быть доступна");
        assertVisible("//*[contains(normalize-space(.), 'Оставить комментарий') or contains(normalize-space(.), 'Sygest')]",
                "На вкладке озвучки должен быть контент озвучки или комментарии");
    }
}
