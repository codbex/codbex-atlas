/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package com.codbex.atlas.ui.tests;

import com.codbex.atlas.ui.Atlas;
import com.codbex.atlas.ui.framework.HtmlElementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomePageIT extends UserInterfaceIntegrationTest {

    private static final String CODBEX_HEADER = "codbex";

    private Atlas atlas;

    @BeforeEach
    void setUp() {
        this.atlas = new Atlas(browser);
    }

    @Test
    void testOpenHomepage() {
        atlas.openHomePage();

        browser.assertElementExistsByTypeAndText(HtmlElementType.HEADER5, CODBEX_HEADER);
    }}
