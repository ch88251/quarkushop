package com.cfhayes.quarkushop.utils;

import java.util.Map;
import java.util.HashMap;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainerResource implements QuarkusTestResourceLifecycleManager {

    private static final PostgreSQLContainer<?> DATABASE = 
        new PostgreSQLContainer<>("postgres:13");

    @Override
    public Map<String, String> start() {
        DATABASE.start();
        
        Map<String, String> confMap = new HashMap<>();
        confMap.put("quarkus.datasource.jdbc.url", DATABASE.getJdbcUrl());
        confMap.put("quarkus.datasource.username", DATABASE.getUsername());
        confMap.put("quarkus.datasource.password", DATABASE.getPassword());

        return confMap;
    }

    @Override
    public void stop() {
        DATABASE.close();
    }
}
