package com.deepblue.shop.Business.Adapter.HomeAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/6/8 0008.
 */

/**
 * 用来适配商品详情可以左右滑动的vp。里面全是view
 */
public class GoodsMainAdapter extends PagerAdapter {
    private List<View> mViewLists;
    private Context mContext;

    public GoodsMainAdapter(List<View> viewLists, Context context) {
        this.mViewLists = viewLists;
        this.mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewLists.get(position), 0);
        return mViewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mViewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
