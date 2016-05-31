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
 * Created by 欢大哥 on 2016/5/30.
 */
public class PointAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsInfo> mList;
    public PointAdapter(Context context){
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
                view = LayoutInflater.from(context).inflate(R.layout.point_item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.point_img = (ImageView) view.findViewById(R.id.point_item_img);
            viewHolder.title_point = (TextView) view.findViewById(R.id.point_item_title);
            viewHolder.time_point = (TextView) view.findViewById(R.id.point_item_time);
            viewHolder.change_point = (TextView) view.findViewById(R.id.point_change_num);
            view.setTag(viewHolder);
            }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsInfo info = (GoodsInfo) getItem(i);
        viewHolder.title_point.setText(info.getGoodsTitle());
        if (!TextUtils.isEmpty(info.getGoodsUrl()))
        Glide.with(context).load(info.getGoodsUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.point_img);
        viewHolder.time_point.setText(info.getPointTime());
        viewHolder.change_point.setText("+"+info.getPointNum());

        return view;
    }

    class ViewHolder{
        ImageView point_img;
        TextView title_point,time_point,change_point;
    }
}
