package com.deepblue.shop.Business.Adapter.shopcaradapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.Business.Model.SharePrenceUtil;
import com.deepblue.shop.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 欢大哥 on 2016/5/23.
 */
public class CarContentAdapter extends BaseAdapter {
    private Context context;
    private String cooperNameStr;
    private HashMap<String ,String > map = new HashMap<>();
    private ArrayList<GoodsInfo> mlist;
    private SharedPreferences sp;
    public CarContentAdapter(Context context){
        this.context = context;
        sp = context.getSharedPreferences(SharePrenceUtil.SHARE_CAR_ALLCHECK, Context.MODE_PRIVATE);
    }
    public void setData(ArrayList<GoodsInfo> list){
        this.mlist = list;
        notifyDataSetChanged();
    }
    public void addData(ArrayList<GoodsInfo> list){
        this.mlist.addAll(list);
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
        final ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.order_item_content,null);
            viewHolder.goodsImg = (SimpleDraweeView) view.findViewById(R.id.order_item_content_img);  //图片
            viewHolder.nameTxt = (TextView) view.findViewById(R.id.order_item_content_title);   //名称
            viewHolder.priceTxt = (TextView) view.findViewById(R.id.order_item_content_price);   //价格
            viewHolder.jiaoyizhuangtaiTxt = (TextView) view.findViewById(R.id.jiaoyizhuangtai_txt);   //交易状态
            viewHolder.cooperLin = (LinearLayout) view.findViewById(R.id.order_goods_cooper);   //商家名称（是否隐藏）
            viewHolder.cooperName = (TextView) view.findViewById(R.id.cooper_name);   //商家名称
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //初始化数据
        final GoodsInfo info = (GoodsInfo) getItem(i);
        if (!TextUtils.isEmpty(info.getGoodsUrl())){
            Uri uri = Uri.parse(info.getGoodsUrl());
            viewHolder.goodsImg.setImageURI(uri);
        }
        viewHolder.nameTxt.setText(info.getGoodsTitle());
        viewHolder.priceTxt.setText("￥"+info.getGoodsPrice());
        //设置商家平台，区分不同商家
        if (info.getHave()){
            viewHolder.cooperLin.setVisibility(View.VISIBLE);
            viewHolder.cooperName.setText(info.getGoodsBusinessName());
        }else {
            viewHolder.cooperLin.setVisibility(View.GONE);
        }

        switch (info.getType()){
            case 1:
                viewHolder.jiaoyizhuangtaiTxt.setText(R.string.success);
                break;
            case 2:
                viewHolder.jiaoyizhuangtaiTxt.setText(R.string.daifukuan_txt);
                break;
            case 3:
                viewHolder.jiaoyizhuangtaiTxt.setText(R.string.daifahuo_txt);
                break;
            case 4:
                viewHolder.jiaoyizhuangtaiTxt.setText(R.string.daishouhuo_txt);
                break;
            case 5:
                viewHolder.jiaoyizhuangtaiTxt.setText(R.string.daipingjia_txt);
                break;
            case 6:
                viewHolder.jiaoyizhuangtaiTxt.setText(R.string.tuihuanhuo_txt);
                break;
        }





        return view;
    }

    class ViewHolder{
        TextView nameTxt;
        TextView priceTxt;
        SimpleDraweeView goodsImg;
        LinearLayout cooperLin;
        TextView cooperName;
        TextView jiaoyizhuangtaiTxt;
    }
}
