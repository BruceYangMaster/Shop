package com.deepblue.shop.Business.Adapter.personadapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deepblue.shop.Business.Activity.other.OrderTuiKuanActivity;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/5/23.
 */
public class OrderTuiKuanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsInfo> mlist;
    public OrderTuiKuanAdapter(Context context){
        this.context = context;
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
            viewHolder.contentRelat = (RelativeLayout) view.findViewById(R.id.order_content);   //内容布局
            viewHolder.goodsImg = (SimpleDraweeView) view.findViewById(R.id.order_item_content_img);  //图片
            viewHolder.nameTxt = (TextView) view.findViewById(R.id.order_item_content_title);   //名称
            viewHolder.priceTxt = (TextView) view.findViewById(R.id.order_item_content_price);   //价格
            viewHolder.jiaoyizhuangtaiTxt = (TextView) view.findViewById(R.id.jiaoyizhuangtai_txt);   //交易状态
            viewHolder.cooperLin = (LinearLayout) view.findViewById(R.id.order_goods_cooper);   //商家名称（是否隐藏）
            viewHolder.cooperName = (TextView) view.findViewById(R.id.cooper_name);   //商家名称
            viewHolder.goodsNumTxt = (TextView) view.findViewById(R.id.order_item_content_num);   //商品数量

            viewHolder.totalRelat = (RelativeLayout) view.findViewById(R.id.order_total_relat);  //总价layout
            viewHolder.totalNum = (TextView) view.findViewById(R.id.order_total_num);    //总数
            viewHolder.totalPrice = (TextView) view.findViewById(R.id.order_total_price);   //总价

            viewHolder.orderStatusLin = (LinearLayout) view.findViewById(R.id.order_status_lin);   //状态响应layout
            viewHolder.deleteTxt = (TextView) view.findViewById(R.id.order_delete);   //删除
            viewHolder.cancalTxt = (TextView) view.findViewById(R.id.order_cancal);   //取消
            viewHolder.payMoneyTxt = (TextView) view.findViewById(R.id.order_pay_money);   //付款
            viewHolder.pingjiaTxt = (TextView) view.findViewById(R.id.order_pingjia);   //评价
            viewHolder.seeLogTxt = (TextView) view.findViewById(R.id.order_see_log);   //查看物流
            viewHolder.sureTxt = (TextView) view.findViewById(R.id.order_sure_goods);   //确认收货

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
        viewHolder.goodsNumTxt.setText("x"+info.getGoodsNum());
        viewHolder.contentRelat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent intent = new Intent(context, OrderTuiKuanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        //设置商家平台，区分不同商家
        if (info.getHave()){
            viewHolder.cooperLin.setVisibility(View.VISIBLE);
            viewHolder.cooperName.setText(info.getGoodsBusinessName());
        }else {
            viewHolder.cooperLin.setVisibility(View.GONE);
        }
        if (info.getType() == 6){
            viewHolder.jiaoyizhuangtaiTxt.setText(R.string.tuihuanhuo_txt);
        }

        if (info.getIsEndType() == 6){
            viewHolder.totalRelat.setVisibility(View.VISIBLE);
            viewHolder.orderStatusLin.setVisibility(View.VISIBLE);
        }else {
            viewHolder.totalRelat.setVisibility(View.GONE);
            viewHolder.orderStatusLin.setVisibility(View.GONE);
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
        RelativeLayout totalRelat,contentRelat;
        TextView totalNum;
        TextView totalPrice;
        LinearLayout orderStatusLin;
        TextView deleteTxt;
        TextView sureTxt;
        TextView pingjiaTxt;
        TextView seeLogTxt;
        TextView cancalTxt;
        TextView payMoneyTxt;
        TextView goodsNumTxt;
    }
}
