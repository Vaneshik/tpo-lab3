package org.example.remanga;

import org.junit.jupiter.api.Test;

class TitleTabsTest extends BaseTest {
    @Test
    void user_opens_title_chapters_tab() {
        titlePage()
                .openEleceed()
                .openChapters()
                .shouldShowChaptersTab();
    }

    @Test
    void user_opens_title_discussions_tab() {
        titlePage()
                .openEleceed()
                .openDiscussions()
                .shouldShowDiscussionsTab();
    }

    @Test
    void user_opens_title_moments_tab() {
        titlePage()
                .openEleceed()
                .openMoments()
                .shouldShowMomentsTab();
    }

    @Test
    void user_opens_title_cards_tab() {
        titlePage()
                .openEleceed()
                .openCards()
                .shouldShowCardsTab();
    }

    @Test
    void user_opens_title_characters_tab() {
        titlePage()
                .openEleceed()
                .openCharacters()
                .shouldShowCharactersTab();
    }

    @Test
    void user_opens_title_voiceover_tab() {
        titlePage()
                .openEleceed()
                .openVoiceover()
                .shouldShowVoiceoverTab();
    }
}
