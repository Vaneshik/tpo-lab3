package org.example.remanga;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("auth")
class AccountServicesTest extends BaseTest {
    @Test
    void authenticated_user_opens_chat() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/chat");

        assertVisible("//*[contains(normalize-space(.), 'Чаты')]", "Должен открыться раздел чатов");
        assertVisible("//input[@placeholder='Поиск']", "В чате должен быть поиск");
        assertVisible("//*[contains(normalize-space(.), 'Бета-версия чата') or contains(normalize-space(.), 'Выберите чат')]",
                "Чат должен показывать рабочую область или бета-уведомление");
    }

    @Test
    void authenticated_user_opens_subscription_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/subscription");

        assertVisible("//*[contains(normalize-space(.), 'RePremium')]", "Страница подписки должна показывать RePremium");
        assertVisible("//button[contains(normalize-space(.), 'Попробовать') or contains(normalize-space(.), 'Подписка')]",
                "Страница подписки должна содержать действие подключения");
    }

    @Test
    void authenticated_user_opens_customization_shop() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/customization/feed/avatar");

        assertVisible("//*[normalize-space(.)='Магазин']", "Должен открыться магазин кастомизации");
        assertVisible("//button[normalize-space(.)='Аватарки']", "В магазине должна быть вкладка аватарок");
        assertVisible("//button[normalize-space(.)='Рамки']", "В магазине должна быть вкладка рамок");
        assertVisible("//button[normalize-space(.)='Обои']", "В магазине должна быть вкладка обоев");
    }

    @Test
    void authenticated_user_opens_billing_history() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/billing");

        assertVisible("//*[contains(normalize-space(.), 'История транзакций')]",
                "Должна открыться история транзакций");
        assertVisible("//button[normalize-space(.)='Молнии']", "В биллинге должна быть вкладка молний");
        assertVisible("//button[normalize-space(.)='Монеты']", "В биллинге должна быть вкладка монет");
        assertVisible("//button[normalize-space(.)='Тикеты']", "В биллинге должна быть вкладка тикетов");
    }

    @Test
    void authenticated_user_opens_dungeon_hunters_event() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/dungeon-hunters");

        assertVisible("//*[contains(normalize-space(.), 'ОХОТНИКИ')]", "Должна открыться страница ивента");
        assertVisible("//button[contains(normalize-space(.), 'Принять вызов')]", "Ивент должен содержать действие принятия");
        assertVisible("//button[contains(normalize-space(.), 'Отказаться')]", "Ивент должен содержать действие отказа");
    }

    @Test
    void authenticated_user_opens_battlepass_info() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        openPath("/user/battlepass/info");

        assertVisible("//*[contains(normalize-space(.), 'Re:Pass') or contains(normalize-space(.), 'Pass')]",
                "Должно открыться описание Re:Pass");
        assertVisible("//button[contains(normalize-space(.), 'Вступить') or contains(normalize-space(.), 'Получить') or contains(normalize-space(.), 'Открыть')]"
                        + " | //a[contains(@href, '/user/battlepass')]",
                "Re:Pass должен содержать действие или навигацию battlepass");
    }
}
