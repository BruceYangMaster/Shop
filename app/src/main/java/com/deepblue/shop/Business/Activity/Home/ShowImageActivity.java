package com.deepblue.shop.Business.Activity.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.deepblue.shop.R;
import com.deepblue.shop.UnlessBusiness.Utils.ShowImageInstance;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ShowImageActivity extends AppCompatActivity {

    private int mCurrentPositon;//当前显示的位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        initVar();
    }

    /**
     * 展示image
     *
     * @param mImageList
     */
    private void initWidget(ArrayList<String> mImageList) {
        ViewPager showImageVp = (ViewPager) findViewById(R.id.show_image_vp);

        ShowImageAdapter adapter = new ShowImageAdapter(this, mImageList);
        showImageVp.setAdapter(adapter);
        if (mCurrentPositon > 0) {
            showImageVp.setCurrentItem(mCurrentPositon);
        }
    }

    /**
     * 初始化intent穿过来的数据——一个list
     */
    private void initVar() {
        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<String> mImageList = intent.getStringArrayListExtra(ShowImageInstance.SHOWIMAGE);
            mCurrentPositon = intent.getIntExtra(ShowImageInstance.CURRENT_POSITION, 0);
            if (mImageList != null) {
                initWidget(mImageList);
            }
        }
    }

    /**
     * 适配器
     */
    class ShowImageAdapter extends PagerAdapter {

        private ArrayList<String> mImageList;
        private Context mContext;

        /**
         * 传入数据
         *
         * @param mContext
         * @param mImageList
         */
        public ShowImageAdapter(Context mContext, ArrayList<String> mImageList) {
            this.mContext = mContext;
            this.mImageList = mImageList;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photo = new PhotoView(mContext);
            photo.setMaxScale(4.0f);
            photo.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }
            });
            String path = mImageList.get(position % mImageList.size());
            if (!TextUtils.isEmpty(path)) {
                Glide.with(mContext).load(path).placeholder(R.mipmap.loading_small_icon).into(photo);
            }
            container.addView(photo);
            return photo;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return mImageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
