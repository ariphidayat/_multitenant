package org.arip.config;

import org.arip.domain.Property;
import org.arip.utils.CustomFilenameFilter;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@Configuration
@MapperScan("org.arip.persistence")
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        String home = System.getenv("CATALINA_HOME");
        File[] files = Paths.get(home + "/webapps").toFile().listFiles(new CustomFilenameFilter());
        logger.info(files.toString());

        if (files.length < 1) {
            return defaultDataSource();
        }

        String host = "";
        String clientId = "";
        for (File f : files) {
            Properties clientProperties = new Properties();
            try {
                clientProperties.load(new FileInputStream(f));
                host = clientProperties.getProperty("host");
                clientId = clientProperties.getProperty("client.id");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        RestTemplate restTemplate = new RestTemplate();
        Property property = restTemplate.getForObject(host + "/" + clientId, Property.class);
        logger.info(property.toString());

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(property.getDatabaseUrl());
        dataSource.setUsername(property.getUsername());
        dataSource.setPassword(property.getPassword());

        return dataSource;
    }

    private DataSource defaultDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sessionFactory() {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("org.arip.domain");
        return sessionFactory;
    }
}
