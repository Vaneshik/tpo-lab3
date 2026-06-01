package org.example.remanga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SearchAndTitleTest extends BaseTest {
    @Test
    void user_opens_search_and_types_query() {
        openHomePage();

        click("//button[normalize-space(.)='Что ищем, семпай?']");
        String searchInput = "//input[@placeholder='Что ищем, семпай?']";
        type(searchInput, "Элисед");

        assertEquals("Элисед", valueOfFirstVisible(searchInput), "Поисковое поле должно принимать запрос");
    }

    @Test
    void user_opens_title_card_from_home_page() {
        openPath("/manga/%3C29.04.2026%3Eeleceed_/main");

        assertTitlePageOpened();
    }

    private void assertTitlePageOpened() {
        assertFalse(driver.getTitle().isBlank(), "У страницы тайтла должен быть заголовок браузера");
        assertVisible("//h1[normalize-space(.)='Элисед']", "На странице тайтла должно быть название");
        assertVisible("//a[normalize-space(.)='Читать' and contains(@href, '/manga/')]", "На странице тайтла должна быть кнопка чтения");
        assertVisible("//button[contains(normalize-space(.), 'Главы')]", "На странице тайтла должна быть вкладка глав");
        assertVisible("//*[contains(normalize-space(.), 'Лайков:') and contains(normalize-space(.), 'Просмотров:')]",
                "На странице тайтла должна быть статистика");
    }
}
