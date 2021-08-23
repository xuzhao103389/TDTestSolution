package com.example.DataSource;

import com.example.tables.RefData;
import com.example.tables.Report;
import com.example.tables.Trade;
import com.example.tables.Valuation;

import java.util.List;

public class WebServiceDataSource extends DataSource{

    public WebServiceDataSource(List<Trade> trades, List<RefData> refDatas,
                                List<Valuation> valuations, List<Report> report){
        super(trades, refDatas, valuations, report);
    }

    @Override
    public void getTables() {
        System.out.println("WebServiceDataSource::populateTables");
    }

    @Override
    public void joinTables() {
        System.out.println("WebServiceDataSource::joinTables");
    }

}
