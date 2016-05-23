package com.deepblue.shop.UnlessBusiness.Utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class Logs {
    private static String TAG = "tag";
    private static boolean flag = true;//log开关，默认打开，app上架后就关闭，设置为false

    /**
     * v级别的log
     *
     * @param info
     */
    public static void v(String info) {
        if (flag) {
            Log.v(TAG, info);
        }
    }

    /**
     * d级别的log
     *
     * @param info
     */
    public static void d(String info) {
        if (flag) {
            Log.d(TAG, info);
        }
    }

    /**
     * i级别的log
     *
     * @param info
     */
    public static void i(String info) {
        if (flag) {
            Log.i(TAG, info);
        }
    }

    /**
     * w级别的log
     *
     * @param info
     */
    public static void w(String info) {
        if (flag) {
            Log.w(TAG, info);
        }
    }

    /**
     * e级别的log
     *
     * @param info
     */
    public static void e(String info) {
        if (flag) {
            Log.e(TAG, info);
        }
    }
}
