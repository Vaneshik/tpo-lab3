package org.example.remanga;

import org.junit.jupiter.api.Test;

class LoginTest extends BaseTest {
    @Test
    void user_sees_error_for_invalid_login() {
        openHomePage();
        openLoginDialog();
        fillLoginForm("wrong-user-" + System.currentTimeMillis(), "wrong-password");

        assertVisible("//*[contains(normalize-space(.), 'Произошла ошибка') "
                        + "or contains(normalize-space(.), 'Введен неверный логин/почта или пароль')]",
                "При неверных данных должна отображаться ошибка авторизации");
    }
}
