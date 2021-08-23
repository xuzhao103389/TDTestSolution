package com.example.tables;

import lombok.Data;

@Data
public class RefData {
    private String topOfHouse;
    private String segment;
    private String viceChair;
    private String globalBusiness;
    private String policy;
    private String desk;
    private String portfolio;
    private String BU;
    private String CLINE;
    private String inventory;


    public RefData(String topOfHouse, String segment, String viceChair, String globalBusiness, String policy, String desk, String portfolio, String BU, String CLINE, String inventory) {
        this.topOfHouse = topOfHouse;
        this.segment = segment;
        this.viceChair = viceChair;
        this.globalBusiness = globalBusiness;
        this.policy = policy;
        this.desk = desk;
        this.portfolio = portfolio;
        this.BU = BU;
        this.CLINE = CLINE;
        this.inventory = inventory;
    }
}
