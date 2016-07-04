package com.deepblue.shop.Business.Activity.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.deepblue.shop.Business.Adapter.HomeAdapter.SearchGoodsGvAdapter;
import com.deepblue.shop.Business.Model.Home.SearchGoodsBean;
import com.deepblue.shop.R;

import java.util.ArrayList;

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
         * 初始化top
         */
        initTop();
        /**
         * 初始化搜索出的商品gv
         */
        initSearchGoodsVp();
    }

    private void initTop() {
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
        filterTv.setOnClickListener(FliterClickListener);
    }

    public View.OnClickListener FliterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(SearchGoodsActivity.this, "筛选按钮", Toast.LENGTH_SHORT).show();
        }

    };

    /**
     * 初始化搜索出的商品gv
     */
    private void initSearchGoodsVp() {
        GridView searchGoodsGv = (GridView) findViewById(R.id.search_goods_gv);
        ArrayList<SearchGoodsBean> searchGoodsList = getSearchGoodsData();
        SearchGoodsGvAdapter gvAdapter = new SearchGoodsGvAdapter(searchGoodsList, this);
        searchGoodsGv.setAdapter(gvAdapter);
    }

    public ArrayList<SearchGoodsBean> getSearchGoodsData() {
        ArrayList<SearchGoodsBean> searchGoodsList = new ArrayList<>();
        //
        SearchGoodsBean searchGoodsBean = new SearchGoodsBean();
        searchGoodsBean.setGoodsImgUrl("http://avatar.csdn.net/F/7/D/1_zhoubin1992.jpg");
        searchGoodsBean.setGoodsName("亿型阁 短袖衬衫男修身纯色夏季韩版薄款寸衫大码半袖衬衣男装 钻石兰 XXL/180");
        searchGoodsBean.setGoodsPrice(100);
        searchGoodsBean.setGoodsSaleVolume(25);
        //
        searchGoodsList.add(searchGoodsBean);
        searchGoodsList.add(searchGoodsBean);
        searchGoodsList.add(searchGoodsBean);
        searchGoodsList.add(searchGoodsBean);
        searchGoodsList.add(searchGoodsBean);
        return searchGoodsList;
    }

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
