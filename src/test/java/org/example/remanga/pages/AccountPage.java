package org.example.remanga.pages;

import org.example.remanga.BaseTest;

public class AccountPage extends BasePage {
    public AccountPage(BaseTest test) {
        super(test);
    }

    public AccountPage openBookmarksFromHeader() {
        click("//a[contains(@href, '/user/bookmarks') and contains(normalize-space(.), 'Закладки')]"
                + " | //button[contains(normalize-space(.), 'Закладки')]");
        return this;
    }

    public AccountPage openBookmarks() {
        open("/user/bookmarks");
        return this;
    }

    public AccountPage openHistory() {
        open("/user/history");
        return this;
    }

    public AccountPage openRequests() {
        open("/user/requests");
        return this;
    }

    public AccountPage openPublicProfile() {
        open("/user/776671/about");
        return this;
    }

    public AccountPage openNotifications() {
        open("/user/notifications/0");
        return this;
    }

    public AccountPage openSettings() {
        open("/user/settings/root");
        return this;
    }

    public AccountPage openFriends() {
        open("/user/776671/friends");
        return this;
    }

    public AccountPage openSocialPosts() {
        open("/user/776671/social/posts");
        return this;
    }

    public AccountPage openAchievements() {
        open("/user/776671/achievements");
        return this;
    }

    public void shouldShowBookmarksSection() {
        shouldSee("//*[contains(normalize-space(.), 'Закладки')]"
                        + " | //*[contains(normalize-space(.), 'Избранное')]"
                        + " | //*[contains(normalize-space(.), 'Читаю')]",
                "После авторизации должен открываться раздел закладок");
    }

    public void shouldShowProfileBlock(String login) {
        shouldSee("//a[contains(@href, '/user/bookmarks') and contains(normalize-space(.), 'Закладки')]",
                "После входа должна быть доступна ссылка на закладки");
        shouldSee("//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), "
                        + test.xpathLiteral(login.toLowerCase()) + ")]",
                "После входа должен отображаться текущий пользователь");
        shouldSee("//a[contains(@href, '/user/notifications')]"
                        + " | //*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), "
                        + test.xpathLiteral(login.toLowerCase()) + ")]",
                "После входа должны быть доступны пользовательские элементы шапки");
    }

    public void shouldShowBookmarkFilters() {
        shouldSee("//*[normalize-space(.)='Закладки']", "Должен открыться раздел закладок");
        shouldSee("//button[contains(normalize-space(.), 'Все')]", "В закладках должен быть фильтр всех тайтлов");
        shouldSee("//button[contains(normalize-space(.), 'Читаю')]", "В закладках должен быть фильтр 'Читаю'");
        shouldSee("//button[contains(normalize-space(.), 'Буду читать')]", "В закладках должен быть фильтр 'Буду читать'");
        shouldSee("//button[contains(normalize-space(.), 'Прочитано')]", "В закладках должен быть фильтр 'Прочитано'");
        shouldSee("//button[contains(normalize-space(.), 'По дате обновлений глав')]",
                "В закладках должна быть сортировка");
    }

    public void shouldShowHistory() {
        shouldSee("//*[contains(normalize-space(.), 'История чтения')]", "Должна открыться история чтения");
        shouldSee("//button[contains(normalize-space(.), 'Удалить всю историю')]",
                "В истории чтения должна быть команда очистки");
        shouldSeeAny("//a[contains(@href, '/manga/') and contains(@href, '/main')]",
                "История чтения должна содержать ссылки на тайтлы или главы");
    }

    public void shouldShowRequests() {
        shouldSee("//*[normalize-space(.)='Заявки']", "Должна открыться страница заявок");
        shouldSee("//button[contains(normalize-space(.), 'Все статусы')]", "В заявках должен быть фильтр статуса");
        shouldSee("//button[contains(normalize-space(.), 'Все типы')]", "В заявках должен быть фильтр типа");
    }

    public void shouldShowPublicProfile() {
        shouldSee("//*[contains(normalize-space(.), 'Vaneshik')]", "Профиль должен отображать имя пользователя");
        shouldSee("//*[contains(normalize-space(.), 'ID: 776671')]", "Профиль должен отображать ID пользователя");
        shouldSee("//button[normalize-space(.)='Профиль']", "В профиле должна быть вкладка профиля");
        shouldSee("//button[normalize-space(.)='Инвентарь']", "В профиле должна быть вкладка инвентаря");
        shouldSee("//button[normalize-space(.)='Социальное']", "В профиле должна быть вкладка социального раздела");
        shouldSee("//*[normalize-space(.)='Бейджи'] | //*[normalize-space(.)='Ачивки']",
                "Профиль должен содержать блоки достижений");
    }

    public void shouldShowNotifications() {
        shouldSee("//*[normalize-space(.)='Уведомления']", "Должен открыться раздел уведомлений");
        shouldSee("//button[contains(normalize-space(.), 'Обновления')]", "В уведомлениях должна быть вкладка обновлений");
        shouldSee("//button[contains(normalize-space(.), 'Социальное')]", "В уведомлениях должна быть социальная вкладка");
        shouldSee("//button[contains(normalize-space(.), 'Важное')]", "В уведомлениях должна быть вкладка важного");
    }

    public void shouldShowSettings() {
        shouldSee("//*[contains(normalize-space(.), 'Vaneshik')]", "Настройки должны отображать текущий профиль");
        shouldSee("//*[contains(normalize-space(.), 'Профиль')]", "Настройки должны содержать раздел профиля");
        shouldSee("//*[contains(normalize-space(.), 'Безопасность и вход в аккаунт')]",
                "Настройки должны содержать раздел безопасности");
        shouldSee("//button[contains(normalize-space(.), 'Сохранить') or contains(normalize-space(.), 'Изменить')]"
                        + " | //input | //textarea",
                "Настройки должны содержать элементы редактирования профиля");
    }

    public void shouldShowFriends() {
        shouldSee("//*[normalize-space(.)='Друзья']", "Должна открыться страница друзей");
        shouldSee("//*[contains(normalize-space(.), 'Пусто') or contains(normalize-space(.), 'Vaneshik')]",
                "Страница друзей должна показать список или пустое состояние");
    }

    public void shouldShowSocialPosts() {
        shouldSee("//button[normalize-space(.)='Посты']", "Социальный раздел должен содержать вкладку постов");
        shouldSee("//button[normalize-space(.)='Комментарии']", "Социальный раздел должен содержать вкладку комментариев");
        shouldSee("//button[contains(normalize-space(.), 'Отслеживаемое')]",
                "Социальный раздел должен содержать отслеживаемое");
    }

    public void shouldShowAchievements() {
        shouldSee("//*[normalize-space(.)='Ачивки']", "Должна открыться страница достижений");
        shouldSee("//*[contains(normalize-space(.), 'Голос сообщества') or contains(normalize-space(.), 'Покоритель страниц')]",
                "Страница достижений должна содержать список достижений");
    }
}
