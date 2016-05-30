package com.deepblue.shop.Business.Activity.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.deepblue.shop.R;

public class MyFootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_collection);
        initWight();
    }

    public void initWight(){
        TextView mBackTxt = (TextView) findViewById(R.id.back_txt);  //返回
        mBackTxt.setText("我的足迹");
        mBackTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        GridView mGridView = (GridView) findViewById(R.id.collection_grid);   //gird布局

    }

}
