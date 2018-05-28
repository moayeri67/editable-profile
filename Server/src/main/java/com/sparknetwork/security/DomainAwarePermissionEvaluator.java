package com.sparknetwork.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 07/29/2017, 12:05 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Component
public class DomainAwarePermissionEvaluator implements PermissionEvaluator
{
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission)
    {
        if ("place-order".equals(permission)) {
            Order order = (Order) targetDomainObject;
            if (order.getAmount() > 500) {
                return hasRole("ROLE_ADMIN", authentication);
            }
        }

        return true;
    }



    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission)
    {
        return hasPermission(authentication, new DomainObjectReference(targetId, targetType), permission);
    }



    private boolean hasRole(String role, Authentication auth)
    {

        if (auth == null || auth.getPrincipal() == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        if (CollectionUtils.isEmpty(authorities)) {
            return false;
        }

        return authorities.stream().filter(ga -> role.equals(ga.getAuthority())).findAny().isPresent();
    }



    static class DomainObjectReference
    {

        private Serializable targetId;
        private String targetType;



        DomainObjectReference(Serializable targetId, String targetType)
        {
            this.targetId = targetId;
            this.targetType = targetType;
        }



        public Serializable getTargetId()
        {
            return targetId;
        }



        public String getTargetType()
        {
            return targetType;
        }
    }
}
