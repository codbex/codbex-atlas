/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package com.codbex.atlas.integration.tests;

import org.eclipse.dirigible.tests.framework.browser.HtmlElementType;
import org.junit.jupiter.api.Test;

class HomePageIT extends AtlasIntegrationTest {

    /**
     * Static copy on the Home landing page - deterministic, unlike the user-dependent greeting.
     */
    private static final String HOME_LANDING_TAGLINE = "Everything starts here. Pick where you want to work today.";

    /**
     * The root path lands on the Home launchpad, which carries no IDE perspectives - the Workbench
     * welcome view is asserted separately.
     */
    @Test
    void testOpenHomePage() {
        ide.openHomePage();

        browser.assertElementExistsByTypeAndText(HtmlElementType.SPAN, "Atlas");
        browser.assertElementExistsByTypeAndText(HtmlElementType.PARAGRAPH, HOME_LANDING_TAGLINE);
    }

    @Test
    void testOpenWorkbench() {
        ide.openIde();

        browser.assertElementExistsByTypeAndText(HtmlElementType.HEADER3, "Welcome to Atlas");
    }
}
