package com.entertainment.test.utility;

import java.sql.Timestamp;

public class DateUtility {
    /**
     * 获取当前时间转化的 Timestamp
     *
     * @return 当前时间
     */
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

}
