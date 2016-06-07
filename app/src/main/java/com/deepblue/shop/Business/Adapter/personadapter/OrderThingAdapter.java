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
 * Created by 欢大哥 on 2016/6/6.
 */
public class OrderThingAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsInfo> mList;
    public OrderThingAdapter(Context context){
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
            view = LayoutInflater.from(context).inflate(R.layout.order_thing_item,null);
            viewHolder = new ViewHolder();
            viewHolder.thing_item_imgae = (ImageView) view.findViewById(R.id.order_thing_content_img);
            viewHolder.thing_title = (TextView) view.findViewById(R.id.order_thing_content_title);
            viewHolder.thing_price = (TextView) view.findViewById(R.id.order_thing_content_price);
            viewHolder.thing_num = (TextView) view.findViewById(R.id.order_thing_content_num);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsInfo info = (GoodsInfo) getItem(i);
        if (!TextUtils.isEmpty(info.getGoodsUrl())){
            Glide.with(context).load(info.getGoodsUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.thing_item_imgae);
        }
        viewHolder.thing_title.setText(info.getGoodsTitle());
        viewHolder.thing_price.setText("￥"+info.getGoodsPrice());
        viewHolder.thing_num.setText("x"+info.getGoodsNum());
        return view;
    }

    class ViewHolder{
        ImageView thing_item_imgae;
        TextView thing_title;
        TextView thing_price;
        TextView thing_num;
    }
}
