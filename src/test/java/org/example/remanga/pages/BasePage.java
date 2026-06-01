package org.example.remanga.pages;

import org.example.remanga.BaseTest;

abstract class BasePage {
    protected final BaseTest test;

    BasePage(BaseTest test) {
        this.test = test;
    }

    protected BasePage open(String path) {
        test.openPath(path);
        return this;
    }

    protected void shouldSee(String xpath, String message) {
        test.assertVisible(xpath, message);
    }

    protected void shouldSeeAny(String xpath, String message) {
        test.assertAnyVisible(xpath, message);
    }

    protected void click(String xpath) {
        test.click(xpath);
    }

    protected void type(String xpath, String value) {
        test.type(xpath, value);
    }

    protected String value(String xpath) {
        return test.valueOfFirstVisible(xpath);
    }

    protected String validationMessage(String xpath) {
        return test.validationMessage(xpath);
    }

    protected boolean exists(String xpath) {
        return test.exists(xpath);
    }

    protected boolean urlContains(String... fragments) {
        return test.waitUrlContainsAny(fragments);
    }
}
