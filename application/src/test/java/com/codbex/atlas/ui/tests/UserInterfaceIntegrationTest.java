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

import com.codbex.atlas.ui.IntegrationTest;
import com.codbex.atlas.ui.framework.Browser;
import com.codbex.atlas.ui.framework.BrowserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.web.server.LocalServerPort;

abstract class UserInterfaceIntegrationTest extends IntegrationTest {

    @LocalServerPort
    private int localServerPort;

    protected Browser browser;

    @BeforeEach
    final void initBrowser() {
        this.browser = new BrowserImpl(localServerPort);
    }

}
