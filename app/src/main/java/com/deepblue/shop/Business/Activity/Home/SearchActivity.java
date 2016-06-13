package com.deepblue.shop.Business.Activity.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.deepblue.shop.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

/**
 * 搜索页面_包含——————历史搜索+热门搜索
 */
public class SearchActivity extends AppCompatActivity {

    private TagFlowLayout mHistorySearchLayout;
    private TagFlowLayout mHotSearchLayout;

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

    /**
     * 用来展示标签的layout
     */
    private void initContent() {
        /**
         * 历史搜索
         */
        initHistorySearchLayout();
        /**
         * 热门搜索
         */
        initHotSearchLayout();
    }

    private void initHotSearchLayout() {
        /**
         * 第三方的标签layout_热门搜索
         */
        mHotSearchLayout = (TagFlowLayout) findViewById(R.id.search_flow_hot_layout);
        /**
         * 得到热门标签数据
         */
        final ArrayList<String> hotListData = getHotTagListData();
        //设置给tagflowlayout
        mHotSearchLayout.setAdapter(new TagAdapter<String>(hotListData) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tv,
                        mHotSearchLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        /**
         * 设置点击事件
         */
        mHotSearchLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String searchKey = hotListData.get(position);
                Intent intent = new Intent(SearchActivity.this, SearchGoodsActivity.class);
                if (!TextUtils.isEmpty(searchKey)) {
                    intent.putExtra("SEARCH", searchKey);
                }
                startActivity(intent);
                return true;
            }
        });
    }

    private ArrayList<String> getHotTagListData() {
        ArrayList<String> tagLists = new ArrayList<>();
        tagLists.add("韩版");
        tagLists.add("夏季");
        tagLists.add("夏季");
        tagLists.add("长款大衣");
        tagLists.add("夏季");
        tagLists.add("夏季");
        tagLists.add("韩版");
        tagLists.add("韩版");
        tagLists.add("韩版");
        return tagLists;
    }

    private void initHistorySearchLayout() {
        /**
         * 第三方的标签layout_历史搜索
         */
        mHistorySearchLayout = (TagFlowLayout) findViewById(R.id.search_flow_history_layout);
        /**
         * 得到历史标签数据
         */
        final ArrayList<String> historyListData = getHistoryTagListData();

        /**
         * 没有搜索历史的时候是否显示提示信息
         */
        checkIsHavaHistory(historyListData);
        /**
         *
         *设置给mHistorySearchLayout
         */
        mHistorySearchLayout.setAdapter(new TagAdapter<String>(historyListData) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tv,
                        mHistorySearchLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        /**
         * 设置点击事件
         */
        mHistorySearchLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String searchKey = historyListData.get(position);
                Intent intent = new Intent(SearchActivity.this, SearchGoodsActivity.class);
                if (!TextUtils.isEmpty(searchKey)) {
                    intent.putExtra("SEARCH", searchKey);
                }
                startActivity(intent);
                return true;
            }
        });
    }

    /**
     * 没有搜索历史的时候是否显示提示信息
     *
     * @param historyListData
     */
    private void checkIsHavaHistory(ArrayList<String> historyListData) {
        TextView isHavaHistoryTv = (TextView) findViewById(R.id.is_hava_history_tv);
        if (historyListData == null) {
            return;
        }
        if (historyListData.size() <= 0) {
            isHavaHistoryTv.setVisibility(View.VISIBLE);
        } else {
            isHavaHistoryTv.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化title
     */
    private void initTitle() {
        findViewById(R.id.search_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * 搜索编辑框
         */
        EditText searchEt = (EditText) findViewById(R.id.search_et);
        /**
         * 点击搜索按钮
         */
        Button searchBtn = (Button) findViewById(R.id.search_btn);
    }

    public ArrayList<String> getHistoryTagListData() {
        ArrayList<String> tagLists = new ArrayList<>();
        tagLists.add("韩版");
        tagLists.add("夏季");
        tagLists.add("夏季");
        tagLists.add("长款大衣");
        tagLists.add("夏季");
        tagLists.add("夏季");
        tagLists.add("阿里的介绍了房间");
        tagLists.add("韩版");
        tagLists.add("女士大头皮鞋");
        tagLists.add("韩版");
        tagLists.add("男士休闲皮鞋");
        tagLists.add("韩版");
        tagLists.add("韩版");
        tagLists.add("韩版");
        return tagLists;
    }

}
