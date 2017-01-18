package org.arip.service.impl;

import org.arip.config.multitenant.TenantContext;
import org.arip.domain.Property;
import org.arip.persistence.PropertyMapper;
import org.arip.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    public List<Property> getProperties() {
        return propertyMapper.getProperties();
    }

    public void updateProperties() {
        Map<Object, Object> resolvedDataSources = new HashMap<>();

        List<Property> properties = propertyMapper.getProperties();
        for (Property p : properties) {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(p.getDriver());
            dataSource.setUrl(p.getUrl());
            dataSource.setUsername(p.getUsername());
            dataSource.setPassword(p.getPassword());

            resolvedDataSources.put(p.getName(), dataSource);
        }
        TenantContext.setResolvedDataSources(resolvedDataSources);
    }
}
