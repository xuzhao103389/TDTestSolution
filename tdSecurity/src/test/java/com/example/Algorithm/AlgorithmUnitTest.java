package com.example.Algorithm;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmUnitTest {

    @Test
    public void calDifference_unit_tests() {
        Assert.assertEquals("0.0", Algorithm.calDifference(0.0f, 0.0f));
        Assert.assertEquals("123456.0", Algorithm.calDifference(123456.0f, 0.0f));
        Assert.assertEquals("123456.0", Algorithm.calDifference(0.0f, 123456.0f));
    }

    @Test
    public void differenceInAbsolute_unit_tests() {
        Assert.assertEquals("", Algorithm.differenceInAbsolute(-0.5f));
        Assert.assertEquals("0-99", Algorithm.differenceInAbsolute(98.5f));
        Assert.assertEquals("100-999", Algorithm.differenceInAbsolute(105.5f));
        Assert.assertEquals("1000-9999", Algorithm.differenceInAbsolute(1005.5f));
        Assert.assertEquals("10000-99999", Algorithm.differenceInAbsolute(55555.5f));
        Assert.assertEquals("100000+", Algorithm.differenceInAbsolute(999992.5f));
    }

    @Test
    public void MaturityDateToToday_unit_tests() {
        Assert.assertEquals("", Algorithm.MaturityDateToToday(null));
        Assert.assertEquals(Algorithm.MaturityDateToToday(""), "");
        Assert.assertEquals("", Algorithm.MaturityDateToToday("20200921"));
        Assert.assertEquals("0m-1m", Algorithm.MaturityDateToToday("20210921"));
        Assert.assertEquals("0m-1m", Algorithm.MaturityDateToToday("20210831"));
        Assert.assertEquals("1m-6m", Algorithm.MaturityDateToToday("20211221"));
        Assert.assertEquals("1m-6m", Algorithm.MaturityDateToToday("20211221"));
        Assert.assertEquals("6m-1yr", Algorithm.MaturityDateToToday("20220821"));
        Assert.assertEquals("1yr-10yr", Algorithm.MaturityDateToToday("20220831"));
        Assert.assertEquals("10yr-30yr", Algorithm.MaturityDateToToday("20320831"));
        Assert.assertEquals("10yr-30yr", Algorithm.MaturityDateToToday("20330831"));
        Assert.assertEquals("30yr-50yr", Algorithm.MaturityDateToToday("20550131"));
        Assert.assertEquals("30yr-50yr", Algorithm.MaturityDateToToday("20710131"));
        Assert.assertEquals("50yr+", Algorithm.MaturityDateToToday("20711031"));
    }

}

