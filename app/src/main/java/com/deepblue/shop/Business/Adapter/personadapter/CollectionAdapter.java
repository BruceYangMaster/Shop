package com.deepblue.shop.Business.Adapter.personadapter;

import android.content.Context;
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
 * Created by 欢大哥 on 2016/5/27.
 */
public class CollectionAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GoodsInfo> mList;
    public CollectionAdapter(Context context){
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.collection_grid_item_layout,null);
            viewHolder.goodsImage = (ImageView) view.findViewById(R.id.grid_image_item);
            viewHolder.deacTxt = (TextView) view.findViewById(R.id.grid_desc_txt_item);
            viewHolder.priceTxt = (TextView) view.findViewById(R.id.grid_price_txt_item);
            viewHolder.delImage = (ImageView) view.findViewById(R.id.grid_delete_image);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GoodsInfo info = (GoodsInfo) getItem(i);
        Glide.with(context).load(info.getGoodsUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.goodsImage);

        viewHolder.deacTxt.setText(info.getGoodsTitle());
        if (info.getGoodsPrice() !=0){
            viewHolder.priceTxt.setText("￥"+info.getGoodsPrice());
        }else {
            viewHolder.priceTxt.setVisibility(View.GONE);
        }
        viewHolder.delImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mList.remove(i);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    class ViewHolder{
        ImageView goodsImage;
        TextView deacTxt;
        TextView priceTxt;
        ImageView delImage;
    }
}
