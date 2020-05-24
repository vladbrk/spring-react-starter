package org.springsandbox.back.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springsandbox.core.configuration.DbConfiguration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.springsandbox.back")
@EnableJpaRepositories(basePackages = {"org.springsandbox.back.repo"})
@EntityScan(basePackages = "org.springsandbox.back.repo.entity")
@Import(DbConfiguration.class)
public class BackConfiguration {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
//        dataSource.setUsername("vladislavbiryukov");
//        dataSource.setPassword("");
//        return dataSource;
//    }
}
