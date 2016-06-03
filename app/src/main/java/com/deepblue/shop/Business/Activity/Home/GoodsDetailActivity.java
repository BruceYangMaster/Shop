package com.deepblue.shop.Business.Activity.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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
        /**
         * 客服
         */
        findViewById(R.id.lin_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * 店铺
         */
        findViewById(R.id.lin_shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * 收藏
         */
        findViewById(R.id.get_goods).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * 加入购物车
         */
        final Button addBtn = (Button) findViewById(R.id.add_shopping_car_btn);
        final PopupWindow addPop = new PopupWindow(GoodsDetailActivity.this);
        View view = LayoutInflater.from(GoodsDetailActivity.this).inflate(R.layout.add_shoppingcar_pop, null);
        addPop.setContentView(view);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addPop.isShowing()) {
                    addPop.dismiss();
                } else {
                    addPop.showAtLocation(addBtn, Gravity.BOTTOM, 0, 0);
                }
            }
        });
        /**
         * 购买按钮
         */
        findViewById(R.id.commodity_buy_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodsDetailActivity.this, EnsureOrderDetailActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * vp下面的内容，例如参数，销量等
     */
    private void initContent() {
        /**
         * 初始化商品详情名字和分享
         */
        initGoodsDetailNameAndShare();
        /**
         * 初始化价钱和销量产地，运费
         */
        initPriceSaleNumProduct();
    }

    /**
     * 初始化价钱和销量产地，运费
     */
    private void initPriceSaleNumProduct() {
        TextView oldPriceTv = (TextView) findViewById(R.id.old_price_tv);
        TextView nowPriceTv = (TextView) findViewById(R.id.now_price_tv);
        TextView kuaidiTv = (TextView) findViewById(R.id.kuaidi_tv);
        TextView yuexiaoliangTv = (TextView) findViewById(R.id.yuexiaoliang_tv);
        TextView shagnjiadizhiTv = (TextView) findViewById(R.id.shagnjiadizhi_tv);
    }

    /**
     * 初始化商品详情名字和分享
     */
    private void initGoodsDetailNameAndShare() {
        /**
         * 商品详情的名字
         */
        TextView goodsDetailNameTv = (TextView) findViewById(R.id.goods_detail_name_tv);
        String goodsDetailNameStr = "衣品天成 2016夏装新款 男士休闲裤 时尚潮流直筒青年休闲长裤男";
        goodsDetailNameTv.setText(goodsDetailNameStr);
        /**
         * 分享商品
         */
        findViewById(R.id.goods_share_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GoodsDetailActivity.this, "分享商品", Toast.LENGTH_SHORT).show();
            }
        });
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
