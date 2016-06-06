package com.deepblue.shop.Business.Activity.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.deepblue.shop.R;

public class EnsureOrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensure_order_detail);
        initWidget();
    }

    private void initWidget() {
        initTitle();
        initBottom();
    }

    private void initTitle() {
        findViewById(R.id.back_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initBottom() {
        //应付款钱数
        TextView orderPayMoney = (TextView) findViewById(R.id.order_pay_money);
        //商品数
        TextView goodsNum = (TextView) findViewById(R.id.goods_num);

    }
}
