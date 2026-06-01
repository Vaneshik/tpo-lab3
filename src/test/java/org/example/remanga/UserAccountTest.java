package org.example.remanga;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("auth")
class UserAccountTest extends BaseTest {
    @Test
    void authenticated_user_sees_bookmark_status_filters() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/bookmarks");

        assertVisible("//*[normalize-space(.)='Закладки']", "Должен открыться раздел закладок");
        assertVisible("//button[contains(normalize-space(.), 'Все')]", "В закладках должен быть фильтр всех тайтлов");
        assertVisible("//button[contains(normalize-space(.), 'Читаю')]", "В закладках должен быть фильтр 'Читаю'");
        assertVisible("//button[contains(normalize-space(.), 'Буду читать')]", "В закладках должен быть фильтр 'Буду читать'");
        assertVisible("//button[contains(normalize-space(.), 'Прочитано')]", "В закладках должен быть фильтр 'Прочитано'");
        assertVisible("//button[contains(normalize-space(.), 'По дате обновлений глав')]",
                "В закладках должна быть сортировка");
    }

    @Test
    void authenticated_user_opens_reading_history() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/history");

        assertVisible("//*[contains(normalize-space(.), 'История чтения')]", "Должна открыться история чтения");
        assertVisible("//button[contains(normalize-space(.), 'Удалить всю историю')]",
                "В истории чтения должна быть команда очистки");
        assertAnyVisible("//a[contains(@href, '/manga/') and contains(@href, '/main')]",
                "История чтения должна содержать ссылки на тайтлы или главы");
    }

    @Test
    void authenticated_user_opens_requests_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/requests");

        assertVisible("//*[normalize-space(.)='Заявки']", "Должна открыться страница заявок");
        assertVisible("//button[contains(normalize-space(.), 'Все статусы')]", "В заявках должен быть фильтр статуса");
        assertVisible("//button[contains(normalize-space(.), 'Все типы')]", "В заявках должен быть фильтр типа");
    }

    @Test
    void authenticated_user_opens_own_public_profile() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/776671/about");

        assertVisible("//*[contains(normalize-space(.), 'Vaneshik')]", "Профиль должен отображать имя пользователя");
        assertVisible("//*[contains(normalize-space(.), 'ID: 776671')]", "Профиль должен отображать ID пользователя");
        assertVisible("//button[normalize-space(.)='Профиль']", "В профиле должна быть вкладка профиля");
        assertVisible("//button[normalize-space(.)='Инвентарь']", "В профиле должна быть вкладка инвентаря");
        assertVisible("//button[normalize-space(.)='Социальное']", "В профиле должна быть вкладка социального раздела");
        assertVisible("//*[normalize-space(.)='Бейджи'] | //*[normalize-space(.)='Ачивки']",
                "Профиль должен содержать блоки достижений");
    }
}
