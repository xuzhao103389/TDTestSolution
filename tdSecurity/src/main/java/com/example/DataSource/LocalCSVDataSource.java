package com.example.DataSource;

import com.example.tables.RefData;
import com.example.tables.Report;
import com.example.tables.Trade;
import com.example.tables.Valuation;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalCSVDataSource extends DataSource{

    public LocalCSVDataSource(List<Trade> trades, List<RefData> refDatas,
                              List<Valuation> valuations, List<Report> report){
        super(trades, refDatas, valuations, report);
    }

    @Override
    public void getTables() {
        System.out.println("LocalCSVDataSource::populateTables");
        Resource resourceTrade = new ClassPathResource("trade.csv");
        Resource resourceValuation = new ClassPathResource("valuation.csv");
        Resource resourceRefData = new ClassPathResource("refdata.csv");
        try{
            String line;
            String[] split;
            //get trades
            List<Trade> trades = this.getTrades();
            InputStream tradeInputStream = resourceTrade.getInputStream();
            BufferedReader tradeReader = new BufferedReader(new InputStreamReader(tradeInputStream));
            tradeReader.readLine();//first line is title
            while((line = tradeReader.readLine()) != null){
                split = line.split(",");
                //populate trade object by the line read from file
                Trade trade = new Trade(split[0],split[1],split[2],split[3],split[4],split[5],split[6],split[7],split[8],split[9],
                        split[10],split[11],split[12],split[13],split[14],split[15],split[16]);
                trades.add(trade);
            }
            //get refdatas
            List<RefData> refDatas = this.getRefDatas();
            InputStream refDataInputStream = resourceRefData.getInputStream();
            BufferedReader refDataReader = new BufferedReader(new InputStreamReader(refDataInputStream));
            refDataReader.readLine();//first line is title
            while((line = refDataReader.readLine()) != null){
                split = line.split(",");
                //use the data read from file to populate the refData object
                RefData refData = new RefData(split[0],split[1],split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9]);
                refDatas.add(refData);
            }
            //get valuations
            List<Valuation> valuations = this.getValuations();
            InputStream valuationInputStream = resourceValuation.getInputStream();
            BufferedReader valuationReader = new BufferedReader(new InputStreamReader(valuationInputStream));
            valuationReader.readLine();//first line is title, so ignore it
            while((line = valuationReader.readLine()) != null){
                split = line.split(",");
                //use the data read from file to populate the valuation object
                Valuation valuation = new Valuation(split[0], split[1], split[2]);
                valuations.add(valuation);
            }
        } catch (IOException e) {}
    }

    @Override
    public void joinTables() {
        System.out.println("LocalCSVDataSource::joinTables");
        List<Trade> trades = this.getTrades();
        List<RefData> refDatas = this.getRefDatas();
        List<Valuation> valuations = this.getValuations();
        List<Report> report = this.getReport();

        trades.forEach((trade) -> {
            //join valuation and trade
            String tradeId = trade.getTradeId();
            List<Valuation> valuationList = valuations.stream().filter(valuation -> valuation.getTradeId().equals(tradeId)).collect(Collectors.toList());
            if(valuationList.isEmpty()){
                //if not found , then just set the valuation cols as blank and only copy trade cols
                Report tempRep = new Report();
                BeanUtils.copyProperties(trade, tempRep);
                report.add(tempRep);
            }else{
                valuationList.forEach((valuation) -> {
                    Report tempRep = new Report();
                    //copy trade cols
                    BeanUtils.copyProperties(trade, tempRep);
                    //copy valuation cols
                    BeanUtils.copyProperties(valuation, tempRep);
                    report.add(tempRep);
                });
            }
        });

        //join trade and redData
        //tempReportList is used if one inventory from  trade can map to more than one line in redData table
        List<Report> tempReportList = new ArrayList<>();

        report.forEach((rep) -> {
            String inventory = rep.getInventory();
            List<RefData> refDataList = refDatas.stream().filter(refData -> refData.getInventory().equals(inventory)).collect(Collectors.toList());
            if(!refDataList.isEmpty()){
                int size = refDataList.size();
                for(int i = 0; i < size; i++){
                    if(i > 0){
                        //i > 0 means that tfrom 2nd redData object, we need to generate one more report object, and then populate the refData
                        Report tempRep = new Report();
                        BeanUtils.copyProperties(rep, tempRep);
                        BeanUtils.copyProperties(refDataList.get(i), tempRep);
                        this.populateNewColumns(tempRep);
                        tempReportList.add(tempRep);
                    }else{
                        BeanUtils.copyProperties(refDataList.get(0), rep);
                        this.populateNewColumns( rep);
                    }
                }
            }
        });

        report.addAll(tempReportList);
    }

}
