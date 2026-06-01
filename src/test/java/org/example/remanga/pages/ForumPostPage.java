package org.example.remanga.pages;

import org.example.remanga.BaseTest;
import org.junit.jupiter.api.Assertions;

public class ForumPostPage extends BasePage {
    private static final String TOPIC_INPUT = "//input[@placeholder='Темы' and @role='combobox']";
    private static final String TITLE_INPUT = "//input[@name='header' and @placeholder='Заголовок']";
    private static final String BODY_EDITOR = "//*[@role='textbox' and @contenteditable='true']";
    private static final String SUBMIT_BUTTON = "//button[normalize-space(.)='Отправить']";

    public ForumPostPage(BaseTest test) {
        super(test);
    }

    public ForumPostPage openCreateForm() {
        open("/forum/create");
        return this;
    }

    public ForumPostPage openCreateFormFromFeed() {
        open("/forum/feed?ordering=-id&week=0");
        click("//a[contains(@href, '/forum/create') and contains(normalize-space(.), 'Создать пост')]");
        return this;
    }

    public ForumPostPage selectTopic(String topic) {
        click(TOPIC_INPUT);
        click("//*[normalize-space(.)=" + test.xpathLiteral(topic) + "]");
        return this;
    }

    public ForumPostPage typeTitle(String title) {
        type(TITLE_INPUT, title);
        return this;
    }

    public ForumPostPage typeBody(String body) {
        type(BODY_EDITOR, body);
        return this;
    }

    public ForumPostPage submit() {
        click(SUBMIT_BUTTON);
        return this;
    }

    public boolean createPostLinkExists() {
        return exists("//a[contains(@href, '/forum/create') and contains(normalize-space(.), 'Создать пост')]");
    }

    public boolean formOpened() {
        return exists(TITLE_INPUT);
    }

    public void shouldShowCreateForm() {
        Assertions.assertTrue(urlContains("/forum/create"), "Форма создания поста должна открываться по корректному URL");
        shouldSee(TOPIC_INPUT, "Форма должна содержать выбор темы");
        shouldSee(TITLE_INPUT, "Форма должна содержать заголовок");
        shouldSee(BODY_EDITOR, "Форма должна содержать редактор текста");
        shouldSee(SUBMIT_BUTTON, "Форма должна содержать кнопку отправки");
    }

    public void shouldRejectLongTitle() {
        Assertions.assertTrue(validationMessage(TITLE_INPUT).contains("65"),
                "Поле заголовка должно ограничивать длину");
    }

    public void shouldHaveTitleValue(String title) {
        Assertions.assertEquals(title, value(TITLE_INPUT), "Форма создания поста должна принимать заголовок");
    }

    public void shouldHaveSubmitButton() {
        Assertions.assertTrue(exists(SUBMIT_BUTTON), "Форма должна оставлять доступной кнопку отправки");
    }

    public void shouldOpenCreatedPost() {
        Assertions.assertTrue(urlContains("/forum/"), "После создания должен открыться пост на форуме");
        shouldSee("//*[contains(normalize-space(.), 'Автотест')] | //*[contains(normalize-space(.), 'Тестовый пост')]",
                "Созданный пост должен отображать тестовый заголовок или содержимое");
    }
}
