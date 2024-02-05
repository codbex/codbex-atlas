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
