package com.deepblue.shop.Business.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 欢大哥 on 2016/5/24.
 */
public class SharePrenceUtil {
    private SharedPreferences sp;
    /**
     * 购物车share
     */
    public static final String SHARE_CAR_ALLCHECK = "com.deepblue.shop.carallcheck";
    public static final String ISALLCHECK = "isallcheck";

    public SharePrenceUtil(Context context){
        sp = context.getSharedPreferences(SHARE_CAR_ALLCHECK, Context.MODE_PRIVATE);
    }

}
