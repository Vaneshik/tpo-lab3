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
        accountPage()
                .openBookmarksFromHeader()
                .shouldShowBookmarksSection();
    }

    @Test
    void authenticated_user_sees_profile_block() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();

        accountPage().shouldShowProfileBlock(configuredLogin());
    }

    @Test
    void authenticated_user_can_open_bookmark_action_on_title_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();

        titlePage()
                .openEleceed()
                .shouldShowBookmarkAction();
    }
}
