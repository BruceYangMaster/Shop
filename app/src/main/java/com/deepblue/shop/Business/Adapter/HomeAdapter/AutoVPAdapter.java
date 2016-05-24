package com.deepblue.shop.Business.Adapter.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.deepblue.shop.Business.Model.Adv;
import com.deepblue.shop.UnlessBusiness.Utils.DensityUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24 0024.
 */

/**
 * 首页的自动轮播vp的适配器
 */
public class AutoVPAdapter extends PagerAdapter {
    private Context mContext;
    private List<Adv> mAdvList;
    private int count;

    /**
     * 在构造函数中传入数据
     */
    public AutoVPAdapter(Context context, List<Adv> advList) {
        this.mAdvList = advList;
        this.mContext = context;
        count = mAdvList.size();
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final Adv adv = mAdvList.get(position % count);
/**
 * 初始化imageview
 */
        ImageView imageView = initImageView();
        /**
         * 加载图片
         */
        Glide.with(mContext).load(adv.getImgUrl()).into(imageView);
//添加到容器里面
        container.addView(imageView);
        //点击跳到链接
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAdvLink(mContext, adv);
            }
        });
        return imageView;
    }

    /**
     * 跳转到广告页面
     *
     * @param mContext
     * @param adv
     */
    private void toAdvLink(Context mContext, Adv adv) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(adv.getLinkUrl());
        intent.setData(content_url);
        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        mContext.startActivity(intent);
    }

    /**
     * 初始化imageview
     *
     * @return
     */
    private ImageView initImageView() {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.height = DensityUtils.dp2px(mContext, 230);
        layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
