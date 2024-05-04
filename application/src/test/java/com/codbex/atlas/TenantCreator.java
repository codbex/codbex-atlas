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

import org.eclipse.dirigible.components.tenants.domain.Tenant;
import org.eclipse.dirigible.components.tenants.domain.TenantStatus;
import org.eclipse.dirigible.components.tenants.service.TenantService;
import org.eclipse.dirigible.components.tenants.service.UserService;
import org.eclipse.dirigible.tests.DirigibleTestTenant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TenantCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TenantCreator.class);

    private final TenantService tenantService;
    private final UserService userService;

    TenantCreator(TenantService tenantService, UserService userService) {
        this.tenantService = tenantService;
        this.userService = userService;
    }

    public void createTenant(DirigibleTestTenant tenant) {
        if (tenant.isDefaultTenant()) {
            LOGGER.info("Tenant [{}] is the default and creation is not needed.", tenant);
            return;
        }
        createTenantEntity(tenant);
        userService.createNewUser(tenant.getUsername(), tenant.getPassword(), tenant.getId());

        LOGGER.info("Created tenant [{}]", tenant);
    }

    private Tenant createTenantEntity(DirigibleTestTenant tenant) {
        Tenant tenantEntity = new Tenant();
        tenantEntity.setId(tenant.getId());
        tenantEntity.setName(tenant.getName());
        tenantEntity.setSubdomain(tenant.getSubdomain());
        tenantEntity.setStatus(TenantStatus.INITIAL);
        tenantEntity.setLocation("-");
        tenantEntity.setType(Tenant.ARTEFACT_TYPE);
        tenantEntity.updateKey();

        return tenantService.save(tenantEntity);
    }

    public boolean isTenantProvisioned(DirigibleTestTenant tenant) {
        Tenant foundTenant = tenantService.findById(tenant.getId())
                                          .orElseThrow(() -> new IllegalStateException("Tenant [" + tenant + "] doesn't exist"));
        return foundTenant.getStatus() == TenantStatus.PROVISIONED;
    }
}
