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
import com.deepblue.shop.Business.Adapter.HomeAdapter.GoodsMainAdapter;
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
        initMainViewPager();
        initTitle();
        //点击购买和购物车的PopWindow
        initPop();
    }

    private void initOneView(View oneView) {
        //顶上的vp
        initVp(oneView);
        //vp下面的内容
        initContent(oneView);
    }

    /**
     * 用来初始化主的vp
     */
    private void initMainViewPager() {
        /**
         * 把三个view添加到vp
         */
        addViewToVp();

    }

    /**
     * 讲三个view左右滑动的view，添加到主vp上
     */
    private void addViewToVp() {
        View oneView = LayoutInflater.from(this).inflate(R.layout.view_goods_detail_one, null);
        View twoView = LayoutInflater.from(this).inflate(R.layout.view_goods_detail_two, null);
        View threeView = LayoutInflater.from(this).inflate(R.layout.view_goods_detail_three, null);
        //主vp，三个view都是添加在上面的
        ViewPager mainVp = (ViewPager) findViewById(R.id.goods_detail_viewpager);
        /**
         * list（里面是三个view）
         *
         */
        ArrayList<View> viewArrayList = new ArrayList<>();
        viewArrayList.add(oneView);
        viewArrayList.add(twoView);
        viewArrayList.add(threeView);
        /**
         * 初始化适配器，讲控件vp绑定到适配器上
         */
        GoodsMainAdapter goodsMainAdapter = new GoodsMainAdapter(viewArrayList, this);
        mainVp.setAdapter(goodsMainAdapter);

        /**
         * 用来初始化三个view
         */
        initOneView(oneView);
        initTwoView();
        initThreeView();
    }

    private void initThreeView() {

    }

    private void initTwoView() {

    }

    private void initTitle() {
        findViewById(R.id.goods_detail_back_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
    private void initContent(View oneView) {
        /**
         * 初始化商品详情名字和分享
         */
        initGoodsDetailNameAndShare(oneView);
        /**
         * 初始化价钱和销量产地，运费
         */
        initPriceSaleNumProduct(oneView);
    }

    /**
     * 初始化价钱和销量产地，运费
     */
    private void initPriceSaleNumProduct(View oneView) {
        //旧的价格
        TextView oldPriceTv = (TextView) oneView.findViewById(R.id.old_price_tv);
        //现在的价格
        TextView nowPriceTv = (TextView) oneView.findViewById(R.id.now_price_tv);
        //快递费
        TextView kuaidiTv = (TextView) oneView.findViewById(R.id.kuaidi_tv);
        //月销量
        TextView yuexiaoliangTv = (TextView) oneView.findViewById(R.id.yuexiaoliang_tv);
        //商家地址
        TextView shagnjiadizhiTv = (TextView) oneView.findViewById(R.id.shagnjiadizhi_tv);
    }

    /**
     * 初始化商品详情名字和分享
     */
    private void initGoodsDetailNameAndShare(View oneView) {
        /**
         * 商品详情的名字
         */
        TextView goodsDetailNameTv = (TextView) oneView.findViewById(R.id.goods_detail_name_tv);
        String goodsDetailNameStr = "衣品天成 2016夏装新款 男士休闲裤 时尚潮流直筒青年休闲长裤男";
        goodsDetailNameTv.setText(goodsDetailNameStr);
        /**
         * 分享商品
         */
        oneView.findViewById(R.id.goods_share_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GoodsDetailActivity.this, "分享商品", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化vp，这个是展示商品图片的一个控件
     */
    private void initVp(View oneView) {
        /**
         * 首先得到数据
         */
        ArrayList<String> goodsList = getVpData();
        ViewPager viewPager = (ViewPager) oneView.findViewById(R.id.goods_detail_vp);
        GoodsDetailVpAdapter goodsDetailAdapter = new GoodsDetailVpAdapter(this, goodsList);
        viewPager.setAdapter(goodsDetailAdapter);
        //
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
