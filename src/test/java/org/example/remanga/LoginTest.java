package org.example.remanga;

import org.junit.jupiter.api.Test;

class LoginTest extends BaseTest {
    @Test
    void user_sees_error_for_invalid_login() {
        homePage().open();

        loginPage()
                .openDialog()
                .submit("wrong-user-" + System.currentTimeMillis(), "wrong-password")
                .shouldShowInvalidCredentialsError();
    }
}
