package com.deepblue.shop.Business.Activity.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.deepblue.shop.Business.Adapter.personadapter.PointAdapter;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class PointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
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

        ListView mListview = (ListView) findViewById(R.id.point_list);

        PointAdapter adapter = new PointAdapter(this);
        adapter.setData(initPointInfo());
        mListview.setAdapter(adapter);

    }

    public ArrayList<GoodsInfo> initPointInfo(){
        ArrayList<GoodsInfo> info = new ArrayList<>();
        for (int i = 0;i<5;i++){
            GoodsInfo goods = new GoodsInfo();
            goods.setGoodsUrl("http://image3.suning.cn/uimg/b2c/newcatentries/0070074640-000000000142631401_1_200x200.jpg");
            goods.setGoodsTitle("测试积分"+i);
            goods.setPointNum(10);
            goods.setPointTime("05-30");
            info.add(goods);
        }
        return info;
    }
}
