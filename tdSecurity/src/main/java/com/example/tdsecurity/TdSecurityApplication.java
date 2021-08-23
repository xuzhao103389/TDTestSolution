package com.example.tdsecurity;

import com.example.DataSource.DataSource;
import com.example.DataSourceFactory.DataSourceFactory;
import com.example.config.DataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.config"
}
)
public class TdSecurityApplication implements CommandLineRunner {
   final DataSourceConfig dataSourceConfig;

    @Autowired
    public TdSecurityApplication(DataSourceConfig dataSourceConfig) {
        //the data source config will tell what is the data source
        this.dataSourceConfig = dataSourceConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(TdSecurityApplication.class, args);
    }

    @Override
    public void  run(String... args) {
        DataSource dataSource = DataSourceFactory.getDataSource(dataSourceConfig.getDatasource());
        this.getResult(dataSource);
    }

    //generate the report
    private void getResult(DataSource dataSource)  {
        dataSource.getTables();
        dataSource.joinTables();
        dataSource.generateReport();
    }
}
