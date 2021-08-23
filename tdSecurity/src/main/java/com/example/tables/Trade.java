package com.example.tables;

import lombok.Data;

@Data
public class Trade {
    private String inventory;
    private String book;
    private String system;
    private String legalEntity;
    private String tradeId;
    private String version;
    private String tradeStatus;
    private String productType;
    private String resettingLeg;
    private String productSubType;
    private String TDSProductType;
    private String secCodeSubType;
    private String swapType;
    private String description;
    private String tradeDate;
    private String startDate;
    private String maturityDate;

    public Trade(String inventory, String book, String system, String legalEntity, String tradeId, String version, String tradeStatus,
                 String productType, String resettingLeg, String productSubType, String TDSProductType, String secCodeSubType,
                 String swapType, String description, String tradeDate, String startDate, String maturityDate) {
        this.inventory = inventory;
        this.book = book;
        this.system = system;
        this.legalEntity = legalEntity;
        this.tradeId = tradeId;
        this.version = version;
        this.tradeStatus = tradeStatus;
        this.productType = productType;
        this.resettingLeg = resettingLeg;
        this.productSubType = productSubType;
        this.TDSProductType = TDSProductType;
        this.secCodeSubType = secCodeSubType;
        this.swapType = swapType;
        this.description = description;
        this.tradeDate = tradeDate;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
    }
}
