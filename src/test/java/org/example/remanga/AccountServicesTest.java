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
        accountServicesPage().openChat().shouldShowChat();
    }

    @Test
    void authenticated_user_opens_subscription_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountServicesPage().openSubscription().shouldShowSubscription();
    }

    @Test
    void authenticated_user_opens_customization_shop() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountServicesPage().openCustomizationShop().shouldShowCustomizationShop();
    }

    @Test
    void authenticated_user_opens_billing_history() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountServicesPage().openBilling().shouldShowBilling();
    }

    @Test
    void authenticated_user_opens_dungeon_hunters_event() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountServicesPage().openDungeonHunters().shouldShowDungeonHunters();
    }

    @Test
    void authenticated_user_opens_battlepass_info() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountServicesPage().openBattlepassInfo().shouldShowBattlepassInfo();
    }
}
