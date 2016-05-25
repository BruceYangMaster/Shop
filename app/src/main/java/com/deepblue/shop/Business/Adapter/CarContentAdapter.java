package com.deepblue.shop.Business.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.Business.Model.SharePrenceUtil;
import com.deepblue.shop.R;
import com.deepblue.shop.UnlessBusiness.Utils.Logs;
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
            view = LayoutInflater.from(context).inflate(R.layout.car_item_content,null);
            viewHolder.check = (CheckBox) view.findViewById(R.id.car_checkbox);    //多选控件
            viewHolder.goodsImg = (SimpleDraweeView) view.findViewById(R.id.car_item_content_img);  //图片
            viewHolder.nameTxt = (TextView) view.findViewById(R.id.car_item_content_title);   //名称
            viewHolder.priceTxt = (TextView) view.findViewById(R.id.car_item_content_price);   //价格
            viewHolder.editText = (EditText) view.findViewById(R.id.num_textview);    //数量编辑框
            viewHolder.addTxt = (TextView) view.findViewById(R.id.num_add_textview);   //加
            viewHolder.DecTxt = (TextView) view.findViewById(R.id.num_desc_textview);   //减

            viewHolder.cooperLin = (LinearLayout) view.findViewById(R.id.car_goods_cooper);   //商家名称（是否隐藏）
            viewHolder.cooperName = (TextView) view.findViewById(R.id.cooper_name);   //商家名称
            viewHolder.coopCheck = (CheckBox) view.findViewById(R.id.car_cooper_check);  //商家全选按钮
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



        viewHolder.coopCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Logs.d("coopCheck-------"+b);
                if (b){
                    map.put(info.getGoodsBusinessName(),info.getGoodsBusinessName());
                }else {
                    map.put(info.getGoodsBusinessName(),"");
//                    sp.edit().putString(SharePrenceUtil.ISALLCHECK,"").commit();
                }
                notifyDataSetChanged();
            }
        });
        viewHolder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Logs.d("check-------"+b);
                if (b){

                }else {
                    sp.edit().putString(SharePrenceUtil.ISALLCHECK,"").commit();

                }
            }
        });

        if (!TextUtils.isEmpty(map.get(info.getGoodsBusinessName()))&&map.get(info.getGoodsBusinessName()).equals(info.getGoodsBusinessName())){
            viewHolder.coopCheck.setChecked(true);
            viewHolder.check.setChecked(true);
        } else {
            viewHolder.coopCheck.setChecked(false);
            viewHolder.check.setChecked(false);
        }
        Logs.e("iii----"+i+"----getcount()--"+getCount());
        Logs.d("sp.getString(SharePrenceUtil.ISALLCHECK,\"\")----"+sp.getString(SharePrenceUtil.ISALLCHECK,""));

        if (sp.getString(SharePrenceUtil.ISALLCHECK,"").equals("1")){
            viewHolder.coopCheck.setChecked(true);
            viewHolder.check.setChecked(true);
            if (getCount() == i+1){
                sp.edit().putString(SharePrenceUtil.ISALLCHECK,"").commit();
            }
        }else if (sp.getString(SharePrenceUtil.ISALLCHECK,"").equals("0")){
            viewHolder.coopCheck.setChecked(false);
            viewHolder.check.setChecked(false);
            if (getCount() == i+1){
                sp.edit().putString(SharePrenceUtil.ISALLCHECK,"").commit();
            }
        }


        return view;
    }

    class ViewHolder{
        CheckBox check,coopCheck;
        TextView nameTxt;
        TextView priceTxt;
        EditText editText;
        SimpleDraweeView goodsImg;
        TextView addTxt;
        TextView DecTxt;
        LinearLayout cooperLin;
        TextView cooperName;
    }
}
