package com.example.tables;

import lombok.Data;

@Data
public class Valuation {
    private String tradeId;
    private String UQL_OC_MMB_MS;
    private String UQL_OC_MMB_MS_PC;

    public Valuation(String tradeId, String UQL_OC_MMB_MS, String UQL_OC_MMB_MS_PC){
        this.tradeId = tradeId;
        this.UQL_OC_MMB_MS = UQL_OC_MMB_MS;
        this.UQL_OC_MMB_MS_PC = UQL_OC_MMB_MS_PC;
    }
}
