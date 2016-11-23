package io.pivotal.bds.mastercard.ess.query.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class ValueGeneratorUtilTest {
    ValueGeneratorUtil valueGeneratorUtil;

    @Test
    public void generateRandomDate() {
        valueGeneratorUtil = new ValueGeneratorUtil();
        System.err.println(valueGeneratorUtil.generateRandomDate());
    }
}
