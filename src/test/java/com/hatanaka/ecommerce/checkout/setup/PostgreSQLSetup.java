package com.hatanaka.ecommerce.checkout.setup;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

@TestConfiguration
public class PostgreSQLSetup {

    private static final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("checkout")
            .withUsername("admin")
            .withPassword("admin");

    static {
        postgreSQLContainer.start();
        postgreSQLContainer.waitingFor(Wait.forHealthcheck());
        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
    }
}
