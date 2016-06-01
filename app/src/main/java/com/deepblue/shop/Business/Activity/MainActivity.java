package com.deepblue.shop.Business.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepblue.shop.Business.Activity.Basic.BasicActivity;
import com.deepblue.shop.Business.Fragment.Category.CategoryFragment;
import com.deepblue.shop.Business.Fragment.Home.HomeFragment;
import com.deepblue.shop.Business.Fragment.Personal.PersonFragment;
import com.deepblue.shop.Business.Fragment.ShoppingCar.ShoppingCarFragmentTwo;
import com.deepblue.shop.R;

public class MainActivity extends BasicActivity {
    public static Boolean isFirst = false;   //判断是否跳转回首页的标记
    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initTab();


    }

    //自定义tab
    public View setTabMenu(String name, int image) {
        View v = LayoutInflater.from(this).inflate(R.layout.tab_own_item_layout, null);
        TextView menuText = (TextView) v.findViewById(R.id.tab_menu_txt);
        ImageView menuImg = (ImageView) v.findViewById(R.id.tab_image);
        menuText.setText(name);
        menuImg.setImageResource(image);
        return v;
    }


    public void initTab(){
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //使用fragment代替activity转换实现
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(setTabMenu("首页", R.drawable.tab_item1_selector)), HomeFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(setTabMenu("分类", R.drawable.tab_item2_selector)), CategoryFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(setTabMenu("购物车", R.drawable.tab_item3_selector)), ShoppingCarFragmentTwo.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(setTabMenu("我的", R.drawable.tab_item4_selector)), PersonFragment.class, null);

    }
    @Override
    protected void onResume() {
        super.onResume();
        if (isFirst){
            tabHost.setCurrentTab(0);
            isFirst = false;
        }

    }




}
