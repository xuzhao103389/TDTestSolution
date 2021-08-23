package com.example.DataSource;

import com.example.tables.RefData;
import com.example.tables.Trade;
import com.example.tables.Valuation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LocalCSVUnitTest extends DataSourceTestBase{

    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void getTables_unitTests(){
         List<Trade> trades = new ArrayList<>();
         List<RefData> refDatas = new ArrayList<>();
         List<Valuation> valuations = new ArrayList<>();
        this.dataSource = new LocalCSVDataSource(trades, refDatas, valuations, new ArrayList<>());
        this.dataSource.getTables();
        Assert.assertEquals(16,this.dataSource.getTrades().size());
        Assert.assertEquals(23,this.dataSource.getRefDatas().size());
        Assert.assertEquals(18,this.dataSource.getValuations().size());
    }

    @Test
    public void joinTables_unitTests(){
        this.dataSource = new LocalCSVDataSource(this.trades, this.refDatas, this.valuations, this.report);

        this.dataSource.joinTables();
        Assert.assertEquals("rrr,eee,qqqq,qqq,rrr,1,12,q,w,wwwww,1,2,3,123456,1,1,1,1,1,1,1,1,1,1,1,20180201,123.4,345.6,222.20001,100-999,", this.report.get(0).toString());
        Assert.assertEquals("222,33,44,tt,g,f,u,,,eeeee,1,2,3,123457,1,1,1,1,1,1,1,1,1,1,1,20220201,11111111.0,222222222.0,2.1111112E8,100000+,1m-6m", this.report.get(1).toString());
        Assert.assertEquals("222,33,44,tt,g,f,u,,,eeeee,1,2,3,123457,1,1,1,1,1,1,1,1,1,1,1,20220201,,,,,1m-6m", this.report.get(2).toString());
        Assert.assertEquals(",,,,,,,,,rrrrr,1,,,123458,1,1,1,1,1,1,1,1,1,1,1,20350201,,,,,", this.report.get(3).toString());
        Assert.assertEquals("555,yyy,hhh,jjj,iii,22,1cc2,o,77,wwwww,1,2,3,123456,1,1,1,1,1,1,1,1,1,1,1,20180201,123.4,345.6,222.20001,100-999,", this.report.get(4).toString());
    }
}
