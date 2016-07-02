package com.deepblue.shop.Business.Adapter.HomeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepblue.shop.Business.Model.Home.SearchGoodsBean;
import com.deepblue.shop.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class SearchGoodsGvAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<SearchGoodsBean> mGoodsList;

    public SearchGoodsGvAdapter(ArrayList<SearchGoodsBean> goodsList, Context context) {
        this.mGoodsList = goodsList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mGoodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search_goods, null);
            viewHolder.searchGoodsImage = (ImageView) convertView.findViewById(R.id.search_goods_image);
            viewHolder.searchGoodsName = (TextView) convertView.findViewById(R.id.search_goods_name);
            viewHolder.searchGoodsPrice = (TextView) convertView.findViewById(R.id.search_goods_price);
            viewHolder.searchGoodsSaleVolume = (TextView) convertView.findViewById(R.id.search_goods_sale_volume);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SearchGoodsBean searchGoodsBean = (SearchGoodsBean) getItem(position);
        Glide.with(mContext).load(searchGoodsBean.getGoodsImgUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.searchGoodsImage);
        viewHolder.searchGoodsName.setText(searchGoodsBean.getGoodsName());
        viewHolder.searchGoodsPrice.setText("￥" + searchGoodsBean.getGoodsPrice());
        viewHolder.searchGoodsSaleVolume.setText("月销量" + searchGoodsBean.getGoodsSaleVolume() + "件");
        return convertView;
    }

    class ViewHolder {
        ImageView searchGoodsImage;
        TextView searchGoodsName;
        TextView searchGoodsPrice;
        TextView searchGoodsSaleVolume;
    }
}
