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
package com.codbex.atlas;

import org.awaitility.Awaitility;
import org.eclipse.dirigible.tests.DirigibleTestTenant;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AtlasApplication.class)
public abstract class IntegrationTest {

    @Autowired
    private TenantCreator tenantCreator;

    @Autowired
    private DirigibleCleaner cleaner;

    @AfterEach
    final void cleanUp() {
        cleaner.clean();
    }

    protected void createTenants(DirigibleTestTenant... tenants) {
        createTenants(Arrays.asList(tenants));
    }

    protected void createTenants(List<DirigibleTestTenant> tenants) {
        tenants.forEach(tenantCreator::createTenant);
    }

    protected void waitForTenantsProvisioning(List<DirigibleTestTenant> tenants) {
        tenants.stream()
                .forEach(this::waitForTenantProvisioning);
    }

    protected void waitForTenantProvisioning(DirigibleTestTenant tenant) {
        Awaitility.await()
                .atMost(35, TimeUnit.SECONDS)
                .until(() -> tenantCreator.isTenantProvisioned(tenant));
    }

}
