package com.example.tables;

import lombok.Data;

@Data
public class Report {
    //clos from RefData
    private String topOfHouse = "";
    private String segment = "";
    private String viceChair = "";
    private String globalBusiness = "";
    private String policy = "";
    private String desk = "";
    private String portfolio = "";
    private String BU = "";
    private String CLINE = "";
    private String inventory = "";
    //cols from trade
    private String book = "";
    private String system = "";
    private String legalEntity = "";;
    private String tradeId = "";;
    private String version = "";;
    private String tradeStatus = "";;
    private String productType = "";;
    private String resettingLeg = "";;
    private String productSubType = "";;
    private String TDSProductType = "";;
    private String secCodeSubType = "";;
    private String swapType = "";;
    private String description = "";;
    private String tradeDate = "";;
    private String startDate = "";;
    private String maturityDate = "";;
    //cols from valuation
    private String UQL_OC_MMB_MS = "";
    private String UQL_OC_MMB_MS_PC = "";
    //3 new cols
    private String MS_PC = "";
    private String breakStatus = "";
    private String term = "";

    //override the toString, for generating the report
    @Override
    public String toString() {
        return this.getTopOfHouse() + "," + this.getSegment() + "," + this.getViceChair() + "," + this.getGlobalBusiness() + ","
                + this.getPolicy() + "," + this.getDesk() + "," + this.getPortfolio() + "," + this.getBU() + "," + this.getCLINE() + "," + this.getInventory() + ","
                + this.getBook() + "," + this.getSystem() + "," + this.getLegalEntity() + "," + this.getTradeId() + "," + this.getVersion() + "," + this.getTradeStatus() + "," + this.getProductType() + ","
                + this.getResettingLeg() + "," + this.getProductSubType() + "," + this.getTDSProductType() + "," + this.getSecCodeSubType() + ","
                + this.getSwapType() + "," + this.getDescription() + "," + this.getTradeDate() + "," + this.getStartDate() + "," + this.getMaturityDate() + ","
                + this.getUQL_OC_MMB_MS() + "," + this.getUQL_OC_MMB_MS_PC() + "," + this.getMS_PC() + "," + this.getBreakStatus() + "," + this.getTerm();
    }
}
