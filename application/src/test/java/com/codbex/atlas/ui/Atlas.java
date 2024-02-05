package com.codbex.atlas.ui;

import com.codbex.atlas.ui.framework.Browser;
import com.codbex.atlas.ui.framework.HtmlAttribute;
import com.codbex.atlas.ui.framework.HtmlElementType;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Atlas {
    private static final Logger LOGGER = LoggerFactory.getLogger(Atlas.class);

    private static final String LOGIN_PAGE_TITLE = "Please sign in";

    private static final String ROOT_PATH = "/";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static final String USERNAME_FIELD_ID = "username";
    private static final String PASSWORD_FIELD_ID = "password";
    private static final String SUBMIT_TYPE = "submit";

    private static final String SIGN_IN_BUTTON_TEXT = "Sign in";

    private final Browser browser;

    public Atlas(Browser browser) {
        this.browser = browser;
    }

    public void openHomePage() {
        browser.openPath(ROOT_PATH);
        login();
    }

    public void login() {
        SelenideElement title = browser.waitUntilExist(HtmlElementType.TITLE);
        String pageTitle = title.getOwnText();
        if (!LOGIN_PAGE_TITLE.equals(pageTitle)) {
            LOGGER.info("Skipping login");
            return;
        }
        LOGGER.info("Logging...");
        browser.enterTextInElementByAttributePattern(HtmlElementType.INPUT, HtmlAttribute.ID, USERNAME_FIELD_ID, USERNAME);
        browser.enterTextInElementByAttributePattern(HtmlElementType.INPUT, HtmlAttribute.ID, PASSWORD_FIELD_ID, PASSWORD);
        browser.clickElementByAttributePatternAndText(HtmlElementType.BUTTON, HtmlAttribute.TYPE, SUBMIT_TYPE, SIGN_IN_BUTTON_TEXT);
    }
}
