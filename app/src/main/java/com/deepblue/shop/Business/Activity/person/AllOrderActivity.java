package com.deepblue.shop.Business.Activity.person;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.deepblue.shop.Business.Activity.MainActivity;
import com.deepblue.shop.Business.Adapter.shopcaradapter.CarContentAdapter;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.R;
import com.deepblue.shop.UnlessBusiness.Utils.Logs;
import com.deepblue.shop.UnlessBusiness.Utils.me.maxwin.view.XListView;

import java.util.ArrayList;

public class AllOrderActivity extends Activity implements XListView.IXListViewListener{
    private XListView mListView;
    private Handler mHandler;
    private CarContentAdapter mAdapter;
    private int start = 0;
    private static int refreshCnt = 0;
    private PopupWindow mPopWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order);

        mListView = (XListView) findViewById(R.id.order_listview);


        mListView.setPullLoadEnable(true);

        mAdapter = new CarContentAdapter(this);
        mAdapter.setData(initCarData());
        mListView.setAdapter(mAdapter);



        mListView.setXListViewListener(this);
        mHandler = new Handler();
        finishActivity();
        popInit();
    }


    public void popInit(){
        ImageView moreImage = (ImageView) findViewById(R.id.pop_item_img);  //更多
        moreImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopView(view);
            }
        });
    }


    /**
     * 初始化popWindow
     * @param view
     */
    public void initPopView(View view){
        if (mPopWindow == null) {
            View contentView = LayoutInflater.from(this).inflate(R.layout.item_popwindow_friend, null);
            mPopWindow = new PopupWindow(contentView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopWindow.setBackgroundDrawable(new BitmapDrawable());
            contentView.findViewById(R.id.sms_pop).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AllOrderActivity.this, MainActivity.class));
                    mPopWindow.dismiss();
                }
            });
            contentView.findViewById(R.id.search_pop).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AllOrderActivity.this, MainActivity.class));

                    mPopWindow.dismiss();
                }
            });
            contentView.findViewById(R.id.firstpage_pop).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AllOrderActivity.this, MainActivity.class);
                    MainActivity.isFirst = true;
                    startActivity(intent);
                    mPopWindow.dismiss();
                }
            });
        }
        mPopWindow.setOutsideTouchable(true);
//                mPopWindow.showAsDropDown(view, 100, 10);
        if (mPopWindow.isShowing()) {
            mPopWindow.dismiss();
        } else {
            mPopWindow.showAsDropDown(view, 20, 0);

        }

    }

    /**
     * 返回
     */
    public void finishActivity(){
        TextView backTxt = (TextView) findViewById(R.id.back_txt);   //返回
        backTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = 0;

                // mAdapter.notifyDataSetChanged();
                mAdapter.setData(initCarData());
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start++;
                Logs.e("start------"+start);
                mAdapter.addData(initCarData());
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }


    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("刚刚");
    }
    public ArrayList<GoodsInfo> initCarData(){
        ArrayList<GoodsInfo> listInfo = new ArrayList<>();
        for (int i = 0;i<3;i++){
            GoodsInfo info = new GoodsInfo();
            info.setGoodsBusinessName("电商平台1");
            info.setGoodsNum(1);
            info.setGoodsPrice(123.00);
            info.setGoodsTitle("成都老火锅");
            info.setGoodsUrl("http://img4.duitang.com/uploads/item/201301/26/20130126225257_QkaSQ.thumb.600_0.jpeg");
            if (i== 0){
                info.setHave(true);
                info.setType(1);
            }
            if (i==2){
                info.setIsEndType(1);
            }
            listInfo.add(info);
        }
        for (int j = 0;j<3;j++){
            GoodsInfo info = new GoodsInfo();
            info.setGoodsBusinessName("电商平台2");
            info.setGoodsNum(1);
            info.setGoodsPrice(345.00);
            info.setGoodsTitle("重庆老火锅");
            info.setGoodsUrl("http://life.xiancn.com/images/site2/20100414/e4e30fd40f281c0d71103bf79ff00e2b.jpg");
            if (j== 0){
                info.setHave(true);
                info.setType(1);
            }
            if (j==2){
                info.setIsEndType(1);
            }
            listInfo.add(info);
        }
        return listInfo;
    }
}
