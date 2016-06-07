package com.deepblue.shop.Business.Activity.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.deepblue.shop.Business.Adapter.personadapter.OrderThingAdapter;
import com.deepblue.shop.Business.CustomView.MyListView;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class OrderThingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_thing);
        initWight();
    }

    public void initWight(){
        TextView mBack = (TextView) findViewById(R.id.back_txt);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        OrderThingAdapter adapter = new OrderThingAdapter(this);
        MyListView mList = (MyListView) findViewById(R.id.order_thing_list);
        adapter.setData(initData());
        mList.setAdapter(adapter);
    }

    public ArrayList<GoodsInfo> initData(){

        ArrayList<GoodsInfo> list = new ArrayList<>();
        for (int i = 0;i<3;i++){
            GoodsInfo info = new GoodsInfo();
            info.setGoodsUrl("http://img14.360buyimg.com/n6/jfs/t2914/174/23338368/166447/3b0b6f64/574827a4N6a400ea5.jpg");
            info.setGoodsTitle("本店产品"+i);
            info.setGoodsPrice(19.99);
            info.setGoodsNum(1);
            list.add(info);
        }
        return list;
    }


}
