package com.codbex.atlas.ui.framework;

public enum HtmlAttribute {
    ID("id"), //
    TYPE("type"), //
    ARIA_LABEL("aria-label"), PLACEHOLDER("placeholder");

    private final String attribute;

    HtmlAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
