package com.deepblue.shop.Business.Adapter.personadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/5/31.
 */
public class CouponAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsInfo> mList;
    public CouponAdapter(Context context){
        this.context = context;
    }

    public void setData(ArrayList<GoodsInfo> list){
        this.mList = list;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_you_hui_quan,null);
            viewHolder = new ViewHolder();
            viewHolder.coupon_img = (ImageView) view.findViewById(R.id.coupon_item_img);
            viewHolder.time_coupon = (TextView) view.findViewById(R.id.coupon_item_time);
            viewHolder.price_coupon = (TextView) view.findViewById(R.id.coupon_price);
            viewHolder.limit_coupon = (TextView) view.findViewById(R.id.coupon_limit);
            viewHolder.title_coupon = (TextView) view.findViewById(R.id.coupon_item_title);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsInfo info = (GoodsInfo) getItem(i);
        viewHolder.limit_coupon.setText(info.getCouponLimit());
        if (!TextUtils.isEmpty(info.getGoodsUrl()))
            Glide.with(context).load(info.getGoodsUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.coupon_img);
        viewHolder.time_coupon.setText(info.getCouponTime());
        viewHolder.price_coupon.setText("￥"+info.getCouponPrice());
        viewHolder.title_coupon.setText(info.getGoodsTitle());
        return view;
    }

    class ViewHolder{
        ImageView coupon_img;
        TextView title_coupon,time_coupon,price_coupon,limit_coupon;
    }
}
