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
package com.codbex.atlas.ui;

import org.eclipse.dirigible.tests.framework.Browser;
import org.eclipse.dirigible.tests.framework.HtmlAttribute;
import org.eclipse.dirigible.tests.framework.HtmlElementType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class EdmView {

    private final Browser browser;

    public EdmView(Browser browser) {
        this.browser = browser;
    }

    public void regenerate() {
        browser.clickElementByAttributePattern(HtmlElementType.BUTTON, HtmlAttribute.TITLE, "Regenerate");
        browser.assertElementExistsByTypeAndTextPattern(HtmlElementType.SPAN, "Generated from model");
    }
}

