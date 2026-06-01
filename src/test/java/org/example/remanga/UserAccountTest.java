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
        accountPage().openBookmarks().shouldShowBookmarkFilters();
    }

    @Test
    void authenticated_user_opens_reading_history() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openHistory().shouldShowHistory();
    }

    @Test
    void authenticated_user_opens_requests_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openRequests().shouldShowRequests();
    }

    @Test
    void authenticated_user_opens_own_public_profile() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openPublicProfile().shouldShowPublicProfile();
    }
}
