package com.deepblue.shop.Business.Activity.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.deepblue.shop.R;

/**
 * 用来展示搜索商品详情的界面
 */
public class SearchGoodsActivity extends AppCompatActivity {

    private String mSearchKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_goods);
        /**
         * 得到前一个页面传递过来的搜索关键字
         */
        initSearchVari();
        /**
         * 初始化控件
         */
        initWidget();
    }

    private void initWidget() {
        /**
         * 返回键点击事件响应
         */
        findViewById(R.id.search_goods_back_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * 搜索编辑框
         */
        EditText searchKeyEd = (EditText) findViewById(R.id.search_key_ed);
        searchKeyEd.setText(mSearchKey);
        /**
         * 筛选
         */
        TextView filterTv = (TextView) findViewById(R.id.filter_tv);
        filterTv.setOnClickListener(OnFliterClickListener);
    }

    public View.OnClickListener OnFliterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(SearchGoodsActivity.this, "筛选按钮", Toast.LENGTH_SHORT).show();
        }

    };

    /**
     * 得到intent传过来的数据
     */
    private void initSearchVari() {
        Intent intent = getIntent();
        String string = intent.getStringExtra("SEARCH");
        if (!TextUtils.isEmpty(string)) {
            mSearchKey = string;
        } else {
            mSearchKey = "默认数据";
        }
    }
}
