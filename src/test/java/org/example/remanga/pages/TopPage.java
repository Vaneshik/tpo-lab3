package org.example.remanga.pages;

import org.example.remanga.BaseTest;

public class TopPage extends BasePage {
    public TopPage(BaseTest test) {
        super(test);
    }

    public TopPage open() {
        open("/manga/top");
        return this;
    }

    public TopPage openFirstTitle() {
        test.openFirstTitleFromCurrentPage();
        return this;
    }

    public void shouldShowTops() {
        shouldSee("//*[normalize-space(.)='Топы']", "Должен открыться раздел топов");
        shouldSee("//a[normalize-space(.)='Новинок' and contains(@href, 'period=new')]", "В топах должен быть фильтр периода");
        shouldSee("//a[normalize-space(.)='Месяца' and contains(@href, 'period=monthly')]", "В топах должен быть фильтр месяца");
        shouldSeeAny("//a[contains(@href, '/manga/') and contains(@href, '/main') and string-length(normalize-space(.)) > 1]",
                "В топах должен быть список тайтлов");
    }
}
