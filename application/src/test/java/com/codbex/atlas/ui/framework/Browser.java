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
package com.codbex.atlas.ui.framework;

import com.codeborne.selenide.SelenideElement;

public interface Browser {

    void openPath(String path);

    void enterTextInElementByAttributePattern(HtmlElementType elementType, HtmlAttribute attribute, String pattern, String text);

    void clickElementByAttributePatternAndText(HtmlElementType elementType, HtmlAttribute attribute, String pattern, String text);

    void assertElementExistsByTypeAndText(HtmlElementType elementType, String text);

    void clickElementByTypeAndText(HtmlElementType span, String string);

    String getPageTitle();

    SelenideElement waitUntilExist(HtmlElementType elementType);

}
