package com.alin.activiti_demo.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class ActivitiConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * 初始化配置表
     */
    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration() {
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
        configuration.setAsyncExecutorActivate(false);
        return configuration;
    }

    /**
     * 初始化引擎
     */
    @Bean
    public ProcessEngine processEngine(){
        return processEngineConfiguration().buildProcessEngine();
    }
}
