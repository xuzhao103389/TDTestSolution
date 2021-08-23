package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class DataSourceConfig {
    @Value("${tdSecurities.dataSource:localCSV}")
    public String datasource;
}
