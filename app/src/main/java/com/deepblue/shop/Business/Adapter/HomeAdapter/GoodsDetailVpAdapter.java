package com.deepblue.shop.Business.Adapter.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.deepblue.shop.Business.Activity.Home.ShowImageActivity;
import com.deepblue.shop.UnlessBusiness.Utils.DensityUtils;
import com.deepblue.shop.UnlessBusiness.Utils.ShowImageInstance;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public class GoodsDetailVpAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<String> mGoodsList;
    private int count;

    public GoodsDetailVpAdapter(Context context, ArrayList<String> list) {
        this.mGoodsList = list;
        this.mContext = context;
        count = mGoodsList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        /**
         * 初始化imageview
         */
        ImageView imageView = initImageView();
        /**
         * 加载图片
         */
        Glide.with(mContext).load(mGoodsList.get(position)).into(imageView);
//添加到容器里面
        container.addView(imageView);
        //点击跳到链接
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowImageActivity.class);
                intent.putStringArrayListExtra(ShowImageInstance.SHOWIMAGE, mGoodsList);
                intent.putExtra(ShowImageInstance.CURRENT_POSITION, position);
                mContext.startActivity(intent);
            }
        });
        return imageView;
    }

    /**
     * 初始化imageview
     *
     * @return
     */
    private ImageView initImageView() {
        ImageView imageView = new ImageView(mContext);
        imageView.setClickable(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.height = DensityUtils.dp2px(mContext, 350);
        layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
