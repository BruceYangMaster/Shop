package com.deepblue.shop.Business.Adapter.CategoryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class CategoryLeftAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<GoodsInfo> mGoodsList;

    public CategoryLeftAdapter(Context context, ArrayList<GoodsInfo> list) {
        this.mContext = context;
        this.mGoodsList = list;
    }

    public void setData(ArrayList<GoodsInfo> list) {
        this.mGoodsList = list;
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_left, null);
        }
        return null;
    }

    class ViewHolder {

    }
}
