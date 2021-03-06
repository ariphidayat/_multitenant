package org.arip.config.multitenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Arip Hidayat on 1/13/2017.
 */
public class MultitenantDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        if (TenantContext.getResolvedDataSources().size() > 0) {
            setTargetDataSources(TenantContext.getResolvedDataSources());
            afterPropertiesSet();
        }
        return TenantContext.getCurrentTenant();
    }
}
