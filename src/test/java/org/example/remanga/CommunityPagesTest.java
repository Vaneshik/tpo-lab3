package org.example.remanga;

import org.junit.jupiter.api.Test;

class CommunityPagesTest extends BaseTest {
    @Test
    void user_opens_publisher_page() {
        communityPage().openPublisher().shouldShowPublisher();
    }

    @Test
    void user_opens_guild_page() {
        communityPage().openGuild().shouldShowGuild();
    }
}
