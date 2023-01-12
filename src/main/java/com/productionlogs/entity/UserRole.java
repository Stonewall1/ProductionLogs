package com.productionlogs.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN,
    WORKER;

    UserRole() {
    }

    @Override
    public String getAuthority() {
        return this.name();
    }
}
