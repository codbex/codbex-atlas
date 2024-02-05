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
