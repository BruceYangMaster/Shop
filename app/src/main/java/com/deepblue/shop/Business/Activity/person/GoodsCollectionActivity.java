package com.deepblue.shop.Business.Activity.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.deepblue.shop.Business.Adapter.personadapter.CollectionAdapter;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class GoodsCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_collection);
        initWight();
    }

    public void initWight(){
        TextView mBackTxt = (TextView) findViewById(R.id.back_txt);  //返回
        mBackTxt.setText("商品收藏");
        mBackTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        GridView mGridView = (GridView) findViewById(R.id.collection_grid);   //gird布局
        CollectionAdapter adapter = new CollectionAdapter(this);
        adapter.setData(initGoodsInfo());
        mGridView.setAdapter(adapter);

    }


    public ArrayList<GoodsInfo> initGoodsInfo(){
        ArrayList<GoodsInfo> goods = new ArrayList<>();
        for (int i = 0;i<10;i++){
            GoodsInfo info = new GoodsInfo();
            info.setGoodsUrl("http://www.78.cn/imgs/2016-04-15/201604151721111.gif");
            info.setGoodsTitle("测试信息"+i);
            info.setGoodsPrice(100.00);
            goods.add(info);
        }
        return goods;
    }
}
