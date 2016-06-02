package com.deepblue.shop.Business.Activity.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.deepblue.shop.R;

/**
 * 搜索页面
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initWidget();
    }

    /**
     * 初始化控件
     */
    private void initWidget() {
        initTitle();
        initContent();
    }

    private void initContent() {

    }

    private void initTitle() {
        findViewById(R.id.search_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        EditText searchEt = (EditText) findViewById(R.id.search_et);
        Button searchBtn = (Button) findViewById(R.id.search_btn);
    }
}
