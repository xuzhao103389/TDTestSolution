package com.example.tdsecurity;

import com.example.DataSource.DataSource;
import com.example.DataSource.LocalCSVDataSource;
import com.example.DataSource.MysqlDataSource;
import com.example.DataSource.WebServiceDataSource;
import com.example.config.DataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;

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

       String dataSourceName = dataSourceConfig.getDatasource();
       DataSource dataSource;

       switch (dataSourceName){
           case "mysql":
               dataSource = new MysqlDataSource(new ArrayList<>(), new ArrayList<>(),
                       new ArrayList<>(), new ArrayList<>());
               break;
           case "webService":
               dataSource = new WebServiceDataSource(new ArrayList<>(), new ArrayList<>(),
                       new ArrayList<>(), new ArrayList<>());
               break;
           case "localCSV":
           default:
               dataSource = new LocalCSVDataSource(new ArrayList<>(), new ArrayList<>(),
                       new ArrayList<>(), new ArrayList<>());
               break;
       }

       this.getResult(dataSource);
    }

    //generate the report
    private void getResult(DataSource dataSource)  {
        dataSource.getTables();
        dataSource.joinTables();
        dataSource.generateReport();
    }
}
