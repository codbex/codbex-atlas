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

public enum HtmlElementType {
    BUTTON("button"), //
    INPUT("input"), //
    ANCHOR("a"), //
    HEADER5("h5"), //
    TITLE("title"), //
    SPAN("span");

    private final String type;

    HtmlElementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
