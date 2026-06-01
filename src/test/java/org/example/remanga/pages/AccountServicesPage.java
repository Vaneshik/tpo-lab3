package org.example.remanga.pages;

import org.example.remanga.BaseTest;

public class AccountServicesPage extends BasePage {
    public AccountServicesPage(BaseTest test) {
        super(test);
    }

    public AccountServicesPage openChat() {
        open("/chat");
        return this;
    }

    public AccountServicesPage openSubscription() {
        open("/user/subscription");
        return this;
    }

    public AccountServicesPage openCustomizationShop() {
        open("/customization/feed/avatar");
        return this;
    }

    public AccountServicesPage openBilling() {
        open("/user/billing");
        return this;
    }

    public AccountServicesPage openDungeonHunters() {
        open("/dungeon-hunters");
        return this;
    }

    public AccountServicesPage openBattlepassInfo() {
        open("/user/battlepass/info");
        return this;
    }

    public void shouldShowChat() {
        shouldSee("//*[contains(normalize-space(.), 'Чаты')]", "Должен открыться раздел чатов");
        shouldSee("//input[@placeholder='Поиск']", "В чате должен быть поиск");
        shouldSee("//*[contains(normalize-space(.), 'Бета-версия чата') or contains(normalize-space(.), 'Выберите чат')]",
                "Чат должен показывать рабочую область или бета-уведомление");
    }

    public void shouldShowSubscription() {
        shouldSee("//*[contains(normalize-space(.), 'RePremium')]", "Страница подписки должна показывать RePremium");
        shouldSee("//button[contains(normalize-space(.), 'Попробовать') or contains(normalize-space(.), 'Подписка')]",
                "Страница подписки должна содержать действие подключения");
    }

    public void shouldShowCustomizationShop() {
        shouldSee("//*[normalize-space(.)='Магазин']", "Должен открыться магазин кастомизации");
        shouldSee("//button[normalize-space(.)='Аватарки']", "В магазине должна быть вкладка аватарок");
        shouldSee("//button[normalize-space(.)='Рамки']", "В магазине должна быть вкладка рамок");
        shouldSee("//button[normalize-space(.)='Обои']", "В магазине должна быть вкладка обоев");
    }

    public void shouldShowBilling() {
        shouldSee("//*[contains(normalize-space(.), 'История транзакций')]",
                "Должна открыться история транзакций");
        shouldSee("//button[normalize-space(.)='Молнии']", "В биллинге должна быть вкладка молний");
        shouldSee("//button[normalize-space(.)='Монеты']", "В биллинге должна быть вкладка монет");
        shouldSee("//button[normalize-space(.)='Тикеты']", "В биллинге должна быть вкладка тикетов");
    }

    public void shouldShowDungeonHunters() {
        shouldSee("//*[contains(normalize-space(.), 'ОХОТНИКИ')]", "Должна открыться страница ивента");
        shouldSee("//button[contains(normalize-space(.), 'Принять вызов')]", "Ивент должен содержать действие принятия");
        shouldSee("//button[contains(normalize-space(.), 'Отказаться')]", "Ивент должен содержать действие отказа");
    }

    public void shouldShowBattlepassInfo() {
        shouldSee("//*[contains(normalize-space(.), 'Re:Pass') or contains(normalize-space(.), 'Pass')]",
                "Должно открыться описание Re:Pass");
        shouldSee("//button[contains(normalize-space(.), 'Вступить') or contains(normalize-space(.), 'Получить') or contains(normalize-space(.), 'Открыть')]"
                        + " | //a[contains(@href, '/user/battlepass')]",
                "Re:Pass должен содержать действие или навигацию battlepass");
    }
}
