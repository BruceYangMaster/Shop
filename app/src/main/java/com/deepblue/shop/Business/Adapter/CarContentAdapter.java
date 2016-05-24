package com.deepblue.shop.Business.Adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/5/23.
 */
public class CarContentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsInfo> mlist;
    public CarContentAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<GoodsInfo> list){
        this.mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.car_item_content,null);
            viewHolder.check = (CheckBox) view.findViewById(R.id.car_checkbox);    //多选控件
            viewHolder.goodsImg = (SimpleDraweeView) view.findViewById(R.id.car_item_content_img);  //图片
            viewHolder.nameTxt = (TextView) view.findViewById(R.id.car_item_content_title);   //名称
            viewHolder.priceTxt = (TextView) view.findViewById(R.id.car_item_content_price);   //价格
            viewHolder.editText = (EditText) view.findViewById(R.id.num_textview);    //数量编辑框
            viewHolder.addTxt = (TextView) view.findViewById(R.id.num_add_textview);   //加
            viewHolder.DecTxt = (TextView) view.findViewById(R.id.num_desc_textview);   //减

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsInfo info = (GoodsInfo) getItem(i);
        if (TextUtils.isEmpty(info.getGoodsUrl())){
            Uri uri = Uri.parse(info.getGoodsUrl());
            viewHolder.goodsImg.setImageURI(uri);
        }
        viewHolder.nameTxt.setText(info.getGoodsTitle());
        viewHolder.priceTxt.setText("￥"+info.getGoodsPrice());



        return view;
    }

    class ViewHolder{
        CheckBox check;
        TextView nameTxt;
        TextView priceTxt;
        EditText editText;
        SimpleDraweeView goodsImg;
        TextView addTxt;
        TextView DecTxt;
    }
}
