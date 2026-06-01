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
        accountPage().openNotifications().shouldShowNotifications();
    }

    @Test
    void authenticated_user_opens_profile_settings() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openSettings().shouldShowSettings();
    }

    @Test
    void authenticated_user_opens_friends_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openFriends().shouldShowFriends();
    }

    @Test
    void authenticated_user_opens_profile_social_posts() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openSocialPosts().shouldShowSocialPosts();
    }

    @Test
    void authenticated_user_opens_achievements_page() {
        assumeTrue(credentialsProvided(), "Для auth-тестов передайте -Dremanga.login/-Dremanga.password или REMANGA_LOGIN/REMANGA_PASSWORD");

        loginWithConfiguredUser();
        accountPage().openAchievements().shouldShowAchievements();
    }
}
