package com.deepblue.shop.Business.Activity.Home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.deepblue.shop.Business.Adapter.HomeAdapter.GoodsDetailVpAdapter;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class GoodsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        initWidget();
    }

    /**
     * 初始化控件
     */
    private void initWidget() {
        //顶上的vp
        initVp();
        //vp下面的内容
        initContent();
        //点击购买和购物车的PopWindow
        initPop();
    }

    /**
     * 点击购买和购物车的popwindow
     */
    private void initPop() {

    }

    /**
     * vp下面的内容，例如参数，销量等
     */
    private void initContent() {

    }

    /**
     * 初始化vp，这个是展示商品图片的一个控件
     */
    private void initVp() {
        /**
         * 首先得到数据
         */
        ArrayList<String> goodsList = getVpData();
        ViewPager viewPager = (ViewPager) findViewById(R.id.goods_detail_vp);
        GoodsDetailVpAdapter goodsDetailAdapter = new GoodsDetailVpAdapter(this, goodsList);
        viewPager.setAdapter(goodsDetailAdapter);
    }

    /**
     * 得到vp的数据
     *
     * @return
     */
    private ArrayList<String> getVpData() {
        ArrayList<String> goodsList = new ArrayList<>();

        goodsList.add("https://gdp.alicdn.com/imgextra/i3/729426279/TB2rlRjpFXXXXXvXFXXXXXXXXXX-729426279.jpg");
        goodsList.add("https://img.alicdn.com/imgextra/i1/729426279/TB2st0unVXXXXbCXXXXXXXXXXXX-729426279.jpg");
        goodsList.add("https://img.alicdn.com/imgextra/i4/729426279/TB2A6pnnVXXXXctXXXXXXXXXXXX-729426279.jpg");
        goodsList.add("https://img.alicdn.com/imgextra/i2/729426279/TB2u1Z2nFXXXXcrXpXXXXXXXXXX-729426279.jpg");
        goodsList.add("https://img.alicdn.com/imgextra/i3/729426279/TB2lFFDnVXXXXX2XXXXXXXXXXXX-729426279.jpg");
        goodsList.add("https://img.alicdn.com/imgextra/i1/729426279/TB268gLmpXXXXXcXpXXXXXXXXXX-729426279.jpg");
        return goodsList;
    }
}
