package com.example.DataSourceFactory;

import com.example.DataSource.LocalCSVDataSource;
import com.example.DataSource.MysqlDataSource;
import com.example.DataSource.WebServiceDataSource;
import com.example.DataSource.DataSource;
import java.util.ArrayList;

public class DataSourceFactory {
    public static DataSource getDataSource(String dataSourceType){
        if(dataSourceType.equalsIgnoreCase("mysql"))
            return new MysqlDataSource(new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>());
        else if(dataSourceType.equalsIgnoreCase("webService"))
            return new WebServiceDataSource(new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>());
        else//this is the default localCSV
            return new LocalCSVDataSource(new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>());
    }
}
