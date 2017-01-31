package org.arip.multitenancy.config.util;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Component
public class MultiTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Override
    protected DataSource selectAnyDataSource() {
        return null;
    }

    @Override
    protected DataSource selectDataSource(String s) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/" + s);
        dataSource.setUsername("postgres");
        dataSource.setPassword("P0stgres");

        return dataSource;
    }
}
