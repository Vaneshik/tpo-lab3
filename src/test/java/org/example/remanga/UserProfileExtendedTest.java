package org.example.remanga;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("auth")
class UserProfileExtendedTest extends BaseTest {
    @Test
    void authenticated_user_opens_notifications() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/notifications/0");

        assertVisible("//*[normalize-space(.)='Уведомления']", "Должен открыться раздел уведомлений");
        assertVisible("//button[contains(normalize-space(.), 'Обновления')]", "В уведомлениях должна быть вкладка обновлений");
        assertVisible("//button[contains(normalize-space(.), 'Социальное')]", "В уведомлениях должна быть социальная вкладка");
        assertVisible("//button[contains(normalize-space(.), 'Важное')]", "В уведомлениях должна быть вкладка важного");
    }

    @Test
    void authenticated_user_opens_profile_settings() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/settings/root");

        assertVisible("//*[contains(normalize-space(.), 'Vaneshik')]", "Настройки должны отображать текущий профиль");
        assertVisible("//*[contains(normalize-space(.), 'Профиль')]", "Настройки должны содержать раздел профиля");
        assertVisible("//*[contains(normalize-space(.), 'Безопасность и вход в аккаунт')]",
                "Настройки должны содержать раздел безопасности");
        assertVisible("//button[contains(normalize-space(.), 'Сохранить') or contains(normalize-space(.), 'Изменить')]"
                        + " | //input | //textarea",
                "Настройки должны содержать элементы редактирования профиля");
    }

    @Test
    void authenticated_user_opens_friends_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/776671/friends");

        assertVisible("//*[normalize-space(.)='Друзья']", "Должна открыться страница друзей");
        assertVisible("//*[contains(normalize-space(.), 'Пусто') or contains(normalize-space(.), 'Vaneshik')]",
                "Страница друзей должна показать список или пустое состояние");
    }

    @Test
    void authenticated_user_opens_profile_social_posts() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/776671/social/posts");

        assertVisible("//button[normalize-space(.)='Посты']", "Социальный раздел должен содержать вкладку постов");
        assertVisible("//button[normalize-space(.)='Комментарии']", "Социальный раздел должен содержать вкладку комментариев");
        assertVisible("//button[contains(normalize-space(.), 'Отслеживаемое')]",
                "Социальный раздел должен содержать отслеживаемое");
    }

    @Test
    void authenticated_user_opens_achievements_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/776671/achievements");

        assertVisible("//*[normalize-space(.)='Ачивки']", "Должна открыться страница достижений");
        assertVisible("//*[contains(normalize-space(.), 'Голос сообщества') or contains(normalize-space(.), 'Покоритель страниц')]",
                "Страница достижений должна содержать список достижений");
    }
}
