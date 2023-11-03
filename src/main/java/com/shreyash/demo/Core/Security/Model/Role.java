package com.shreyash.demo.Core.Security.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.shreyash.demo.Core.Security.Model.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),

    ADMIN(
            Set.of(ADMIN_READ, ADMIN_WRITE, ADMIN_UPDATE, MANAGER_UPDATE, MANAGER_WRITE, MANAGER_READ)
    ),

    MANAGER(
            Set.of(MANAGER_UPDATE, MANAGER_WRITE, MANAGER_READ)
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList();

        return authorities;

    }


}
