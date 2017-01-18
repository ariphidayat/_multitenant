package org.arip.config.multitenant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arip Hidayat on 1/13/2017.
 */
public class TenantContext {

    private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();

    private static Map<Object, Object> resolvedDataSources = new HashMap<>();

    public static void setCurrentTenant(Object tenant) {
        currentTenant.set(tenant);
    }

    public static Object getCurrentTenant() {
        return currentTenant.get();
    }

    public static Map<Object, Object> getResolvedDataSources() {
        return resolvedDataSources;
    }

    public static void setResolvedDataSources(Map<Object, Object> resolvedDataSources) {
        TenantContext.resolvedDataSources = resolvedDataSources;
    }
}
