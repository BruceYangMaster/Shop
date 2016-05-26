package com.deepblue.shop.Business.Adapter.HomeAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<GoodsInfo> goodsList;
    private LayoutInflater mLayoutInflater;
    //
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private View mHeaderView;

    public MyRecyclerViewAdapter(Context context, ArrayList<GoodsInfo> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    /**
     * 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_home_goods, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GoodsInfo goodsInfo = goodsList.get(position);
        holder.goodsName.setText(goodsInfo.getGoodsTitle());
        holder.goodsPrice.setText("￥" + goodsInfo.getGoodsPrice());
        Glide.with(context).load(goodsInfo.getGoodsUrl()).placeholder(R.mipmap.loading_small_icon).into(holder.goodsImg);
    }


    /**
     * 填充onCreateViewHolder方法返回的holder中的控件
     */

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView goodsImg;
        TextView goodsName;
        TextView goodsPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            goodsImg = (ImageView) itemView.findViewById(R.id.goods_img_url);
            goodsName = (TextView) itemView.findViewById(R.id.goods_name);
            goodsPrice = (TextView) itemView.findViewById(R.id.goods_price);
        }
    }
}
