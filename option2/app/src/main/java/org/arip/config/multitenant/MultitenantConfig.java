package org.arip.config.multitenant;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Arip Hidayat on 1/13/2017.
 */
@Configuration
@MapperScan("org.arip.persistence")
@PropertySource("classpath:database.properties")
public class MultitenantConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        File[] files = Paths.get("src/tenants").toFile().listFiles();
        Map<Object, Object> resolvedDataSources = new HashMap<>();

        for (File propertyFile : files) {
            Properties tenantProperties = new Properties();
            BasicDataSource dataSource = new BasicDataSource();

            try {
                tenantProperties.load(new FileInputStream(propertyFile));

                String tenantId = tenantProperties.getProperty("name");

                dataSource.setDriverClassName(tenantProperties.getProperty("db.driver"));
                dataSource.setUrl(tenantProperties.getProperty("db.url"));
                dataSource.setUsername(tenantProperties.getProperty("db.username"));
                dataSource.setPassword(tenantProperties.getProperty("db.password"));

                resolvedDataSources.put(tenantId, dataSource);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        MultitenantDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(defaultDataSource());
        dataSource.setTargetDataSources(resolvedDataSources);

        // finalize the initialization of the data source.
        dataSource.afterPropertiesSet();

        return dataSource;
    }

    private DataSource defaultDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sessionFactory() {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("org.arip.domain");
        return sessionFactory;
    }
}
