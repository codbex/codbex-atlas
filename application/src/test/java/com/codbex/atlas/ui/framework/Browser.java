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
