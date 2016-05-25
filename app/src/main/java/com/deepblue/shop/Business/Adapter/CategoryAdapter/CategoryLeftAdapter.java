package com.deepblue.shop.Business.Adapter.CategoryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepblue.shop.Business.Model.Category.MainCategoryModel;
import com.deepblue.shop.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class CategoryLeftAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<MainCategoryModel> mGoodsList;

    public CategoryLeftAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<MainCategoryModel> list) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_categorys_left, null);
            viewHolder.categoryName = (TextView) convertView.findViewById(R.id.category_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MainCategoryModel mainCategoryModel = (MainCategoryModel) getItem(position);
        /**
         * 加载图片
         */
//        Glide.with(mContext).load(mainCategoryModel.getImagUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.categoryImageView);
        viewHolder.categoryName.setText(mainCategoryModel.getCategoryName());

        return convertView;
    }

//    private void copy() {
//        ViewHolder viewHolder = null;
//        if (convertView == null) {
//            viewHolder = new ViewHolder();
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_left, null);
//            viewHolder.categoryImageView = (ImageView) convertView.findViewById(R.id.main_category_img);
//            viewHolder.categoryName = (TextView) convertView.findViewById(R.id.main_category_name);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        MainCategoryModel mainCategoryModel = (MainCategoryModel) getItem(position);
//        /**
//         * 加载图片
//         */
////        Glide.with(mContext).load(mainCategoryModel.getImagUrl()).placeholder(R.mipmap.loading_small_icon).into(viewHolder.categoryImageView);
//        viewHolder.categoryName.setText(mainCategoryModel.getCategoryName());
//        return convertView;
//    }

    class ViewHolder {
        ImageView categoryImageView;
        TextView categoryName;
    }
}
