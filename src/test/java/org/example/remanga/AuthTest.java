package org.example.remanga;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("auth")
class AuthTest extends BaseTest {
    @Test
    void authenticated_user_opens_bookmarks() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        click("//a[contains(@href, '/user/bookmarks') and contains(normalize-space(.), 'Закладки')]"
                + " | //button[contains(normalize-space(.), 'Закладки')]");

        assertVisible("//*[contains(normalize-space(.), 'Закладки')]"
                        + " | //*[contains(normalize-space(.), 'Избранное')]"
                        + " | //*[contains(normalize-space(.), 'Читаю')]",
                "После авторизации должен открываться раздел закладок");
    }

    @Test
    void authenticated_user_sees_profile_block() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();

        assertVisible("//a[contains(@href, '/user/bookmarks') and contains(normalize-space(.), 'Закладки')]",
                "После входа должна быть доступна ссылка на закладки");
        assertVisible("//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), "
                        + xpathLiteral(configuredLogin().toLowerCase()) + ")]",
                "После входа должен отображаться текущий пользователь");
        assertVisible("//a[contains(@href, '/user/notifications')]"
                        + " | //*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), "
                        + xpathLiteral(configuredLogin().toLowerCase()) + ")]",
                "После входа должны быть доступны пользовательские элементы шапки");
    }

    @Test
    void authenticated_user_can_open_bookmark_action_on_title_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openHomePage();
        openPath("/manga/%3C29.04.2026%3Eeleceed_/main");

        assertVisible("//button[contains(normalize-space(.), 'В закладки')]"
                        + " | //button[contains(normalize-space(.), 'Заклад')]",
                "На странице тайтла авторизованному пользователю должны быть доступны пользовательские действия");
    }
}
