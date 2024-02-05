package com.codbex.atlas.ui.tests;

import com.codbex.atlas.ui.Atlas;
import com.codbex.atlas.ui.framework.HtmlElementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomePageIT extends UserInterfaceIntegrationTest {

    private static final String ECLIPSE_DIRIGIBLE_HEADER = "Eclipse Dirigible";

    private Atlas atlas;

    @BeforeEach
    void setUp() {
        this.atlas = new Atlas(browser);
    }

    @Test
    void testOpenHomepage() {
        atlas.openHomePage();

        browser.assertElementExistsByTypeAndText(HtmlElementType.HEADER5, ECLIPSE_DIRIGIBLE_HEADER);
    }}
