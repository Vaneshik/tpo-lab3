package org.example.remanga.pages;

import org.example.remanga.BaseTest;

public class InfoPage extends BasePage {
    public InfoPage(BaseTest test) {
        super(test);
    }

    public InfoPage open(String path) {
        super.open(path);
        return this;
    }

    public void shouldContain(String expectedText) {
        shouldSee("//*[contains(normalize-space(.), " + test.xpathLiteral(expectedText) + ")]",
                "Информационная страница должна содержать ожидаемый заголовок или ключевой текст");
    }
}
