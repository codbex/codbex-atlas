package com.codbex.atlas.ui.tests;

import org.eclipse.dirigible.tests.UserInterfaceIntegrationTest;
import org.springframework.context.annotation.Import;

@Import(TestConfigurations.class)
public abstract class AtlasIntegrationTest extends UserInterfaceIntegrationTest {
}
