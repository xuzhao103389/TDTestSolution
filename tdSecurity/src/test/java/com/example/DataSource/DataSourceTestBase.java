package com.example.DataSource;

import com.example.tables.RefData;
import com.example.tables.Report;
import com.example.tables.Trade;
import com.example.tables.Valuation;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class DataSourceTestBase {
    public List<Trade> trades = new ArrayList<>();
    public List<RefData> refDatas = new ArrayList<>();
    public List<Valuation> valuations = new ArrayList<>();
    public List<Report> report = new ArrayList<>();

    public Valuation Valuation1 = new Valuation("123456", "123.4","345.6");
    public Valuation Valuation2 = new Valuation("123457", "11111111.0", "222222222.0");
    public Valuation Valuation3 = new Valuation("123457", "", "");

    public Trade trade1 = new Trade("wwwww", "1","2","3","123456","1","1","1",
            "1","1","1","1","1","1","1","1","20180201");
    public Trade trade2 = new Trade("eeeee", "1","2","3","123457","1","1","1",
            "1","1","1","1","1","1","1","1","20220201");
    public Trade trade3 = new Trade("rrrrr", "1","","","123458","1","1","1",
            "1","1","1","1","1","1","1","1","20350201");

    public RefData refData1 = new RefData("rrr","eee","qqqq","qqq","rrr","1","12","q","w","wwwww");
    public RefData refData2 = new RefData("555","yyy","hhh","jjj","iii","22","1cc2","o","77","wwwww");
    public RefData refData3 = new RefData("222","33","44","tt","g","f","u","","","eeeee");

    public DataSource dataSource;

    @Before
    void setUp(){
        this.valuations.add(this.Valuation1);
        this.valuations.add(this.Valuation2);
        this.valuations.add(this.Valuation3);

        this.trades.add(this.trade1);
        this.trades.add(this.trade2);
        this.trades.add(this.trade3);

        this.refDatas.add(this.refData1);
        this.refDatas.add(this.refData2);
        this.refDatas.add(this.refData3);
    }
}
