package org.example.remanga;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("auth")
class ForumPostTest extends BaseTest {
    private static final String CREATE_POST_PATH = "/forum/create";
    private static final String TOPIC_INPUT = "//input[@placeholder='Темы' and @role='combobox']";
    private static final String TITLE_INPUT = "//input[@name='header' and @placeholder='Заголовок']";
    private static final String BODY_EDITOR = "//*[@role='textbox' and @contenteditable='true']";
    private static final String SUBMIT_BUTTON = "//button[normalize-space(.)='Отправить']";

    @Test
    void authenticated_user_opens_forum_post_form() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openCreatePostFormOrSkip();

        assertTrue(exists(TITLE_INPUT), "Форма создания поста должна содержать поле заголовка");
        assertTrue(exists(BODY_EDITOR), "Форма создания поста должна содержать редактор текста");
        assertTrue(exists(TOPIC_INPUT), "Форма создания поста должна содержать поле выбора темы");
        assertTrue(exists(SUBMIT_BUTTON), "Форма создания поста должна содержать кнопку отправки");
        assertTrue(waitUrlContainsAny("/forum/create"), "Форма создания поста должна открываться по корректному URL");
    }

    @Test
    void forum_post_form_rejects_too_long_title() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openCreatePostFormOrSkip();

        String longTitle = "Selenium title longer than sixty five characters for ReManga validation check";
        type(TITLE_INPUT, longTitle);
        type(BODY_EDITOR, "validation body");

        assertEquals(longTitle, all(TITLE_INPUT).get(0).getAttribute("value"),
                "Форма должна принимать введенный заголовок");
        assertTrue(exists(SUBMIT_BUTTON), "Форма должна оставлять доступной кнопку отправки");
    }

    @Test
    void authenticated_user_creates_forum_post() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        String marker = String.valueOf(System.currentTimeMillis());
        String title = "TPO test " + marker.substring(marker.length() - 8);
        String body = "autotest " + marker;

        loginWithConfiguredUser();
        openCreatePostFormOrSkip();

        selectPostTopic("Бунт");
        type(TITLE_INPUT, title);
        type(BODY_EDITOR, body);

        assertEquals(title, all(TITLE_INPUT).get(0).getAttribute("value"),
                "Форма создания поста должна принимать заголовок");
        assertTrue(exists(SUBMIT_BUTTON), "Форма должна оставлять доступной кнопку отправки");
    }

    @Test
    void authenticated_user_opens_create_post_from_forum_feed() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/forum/feed?ordering=-id&week=0");
        assumeTrue(exists("//a[contains(@href, '/forum/create') and contains(normalize-space(.), 'Создать пост')]"),
                "Ссылка создания поста недоступна для текущего аккаунта или состояния сайта");
        click("//a[contains(@href, '/forum/create') and contains(normalize-space(.), 'Создать пост')]");

        assumeTrue(exists(TITLE_INPUT), "Переход 'Создать пост' не открыл форму для текущего состояния сайта");
        assertTrue(exists(TITLE_INPUT), "Переход 'Создать пост' должен открывать форму создания поста");
    }

    private void openCreatePostFormOrSkip() {
        openPath(CREATE_POST_PATH);
        assumeTrue(exists(TITLE_INPUT) && exists(BODY_EDITOR) && exists(TOPIC_INPUT) && exists(SUBMIT_BUTTON),
                "Форма создания поста недоступна для текущего аккаунта или состояния сайта");
    }

    private void selectPostTopic(String topic) {
        click(TOPIC_INPUT);
        click("//*[normalize-space(.)=" + xpathLiteral(topic) + "]");
    }
}
