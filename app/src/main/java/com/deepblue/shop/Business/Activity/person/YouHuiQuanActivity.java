package com.deepblue.shop.Business.Activity.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.deepblue.shop.Business.Adapter.personadapter.CouponAdapter;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class YouHuiQuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_layout);
        initWight();
    }

    public void initWight(){
        ImageView mImageView = (ImageView) findViewById(R.id.back_img);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListView mListview = (ListView) findViewById(R.id.coupon_list);

        CouponAdapter adapter = new CouponAdapter(this);
        adapter.setData(initPointInfo());
        mListview.setAdapter(adapter);

    }

    public ArrayList<GoodsInfo> initPointInfo(){
        ArrayList<GoodsInfo> info = new ArrayList<>();
        for (int i = 0;i<5;i++){
            GoodsInfo goods = new GoodsInfo();
            goods.setGoodsUrl("http://pic64.nipic.com/file/20150414/11820937_154942836000_2.jpg");
            goods.setCouponPrice(20);
            goods.setCouponTime("2016.05.30-2016.07.30");
            goods.setCouponLimit("满80使用");
            goods.setGoodsTitle("优惠券"+i);
            info.add(goods);
        }
        return info;
    }
}
