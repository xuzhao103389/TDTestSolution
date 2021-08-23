package com.example.DataSource;

import com.example.Algorithm.Algorithm;
import com.example.tables.RefData;
import com.example.tables.Report;
import com.example.tables.Trade;
import com.example.tables.Valuation;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Data
public abstract class DataSource {
    private List<Trade> trades;
    private List<RefData> refDatas;
    private List<Valuation> valuations;
    private List<Report> report;
    public DataSource(List<Trade> trades, List<RefData> refDatas,
        List<Valuation> valuations, List<Report> report){
        this.trades = trades;
        this.refDatas = refDatas;
        this.valuations = valuations;
        this.report = report;
    }

    //the way to get data and join tables will be different depending on different data resoures
    public abstract void getTables();
    public abstract void joinTables();
    //the way to generate report should be all the same for all data sources, because it will just generate a .csv file
    public void generateReport() {
        System.out.println("DataSource::generateReport");
        List<Report> report = this.getReport();
        File csvOutputFile = new File("report.csv");

        String title = "topOfHouse,segment,viceChair,globalBusiness,Policy,desk,portfolio,BU,CLINE,Inventory,Book,System,LegalEntity,TradeId,Version,TradeStatus,ProductType,Resetting Leg,ProductSubType,TDSProductType,SecCodeSubType,SwapType,Description,TradeDate,StartDate,MaturityDate,UQL_OC_MMB_MS,UQL_OC_MMB_MS_PC,MS-PC,BreakStatus,Term";
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            //write tile line
            pw.println(title);
            // write the lines of report
            report.stream().forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //this is to set the 3 new columns
    protected void populateNewColumns(Report rep) {
        //only if UQL_OC_MMB_MS and UQL_OC_MMB_MS_PC having values, then can calculate the cols, otherwise just blank
        if(!rep.getUQL_OC_MMB_MS().isBlank() && !rep.getUQL_OC_MMB_MS_PC().isBlank()) {
            String ms_pc = Algorithm.calDifference(Float.parseFloat(rep.getUQL_OC_MMB_MS()), Float.parseFloat(rep.getUQL_OC_MMB_MS_PC()));
            rep.setMS_PC(ms_pc);
            rep.setBreakStatus(Algorithm.differenceInAbsolute(Float.parseFloat(ms_pc)));
        }
        //set term
        rep.setTerm(Algorithm.MaturityDateToToday(rep.getMaturityDate()));
    }
}
