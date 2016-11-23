package io.pivotal.bds.mastercard.ess.query.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class ValueGeneratorUtil {
    private static final Random random = new Random();

    public Object generateRandomDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1 * random.nextInt(365));
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fmt.format(cal.getTime());
    }
}
