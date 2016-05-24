package com.deepblue.shop.Business.Fragment.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.deepblue.shop.Business.Adapter.HomeAdapter.AutoVPAdapter;
import com.deepblue.shop.Business.Model.Adv;
import com.deepblue.shop.R;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * 主页的fragment，该布局要求非常灵活，所以比较复杂
 */
public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private AutoScrollViewPager mAutoSVP;
    private AutoVPAdapter mAutoAdapter;
    private GridView mGridView;

    /**
     * 默认的一个无参数的构造函数
     */
    public HomeFragment() {
    }

    /**
     * newInstance
     *
     * @param param1
     * @param param2
     * @return
     */
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 初始化
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * 创建布局
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initWidget(view);
        return view;
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initWidget(View view) {
        initAutoVp(view);
        initGridView(view);
    }

    private void initGridView(View view) {
//        mGridView = (GridView) view.findViewById(R.id.gridview);

    }

    /**
     * 初始化自动轮播vp
     *
     * @param view
     */
    private void initAutoVp(View view) {
        mAutoSVP = (AutoScrollViewPager) view.findViewById(R.id.auto_viewpager);

        List<Adv> advList = initAutoVpData();
        mAutoAdapter = new AutoVPAdapter(getContext(), advList);
        mAutoSVP.setAdapter(mAutoAdapter);
        //

        //配置自动轮播参数
        mAutoSVP.setCycle(true);
        mAutoSVP.startAutoScroll();
        mAutoSVP.setInterval(1500);
    }

    private List<Adv> initAutoVpData() {
        List<Adv> mlist = new ArrayList<>();
        String imgUrl = "http://b166.photo.store.qq.com/psb?/V13pmlLQ1l6YT7/wwYdDMfb3z*tfjOdL8dgtqpnZhad7avkqLigOvSySAQ!/c/dKYAAAAAAAAA&ek=1&kp=1&pt=0&bo=9AFiAfQBYgEFACM!&sce=0-12-12&rf=0-18";
        String advUrl = "https://www.baidu.com/";
        mlist.add(new Adv(imgUrl, advUrl));
        mlist.add(new Adv("http://a4.qpic.cn/psb?/V12AurWQ0oasVT/Tnqg37iHMtIB5nU0t6ZWgmqS3d5XOt8bolLPpW4t45k!/c/dAcBAAAAAAAA&ek=1&kp=1&pt=0&bo=gQHWAIEB1gAFACM!&sce=0-12-12&rf=0-18", advUrl));
        mlist.add(new Adv("http://a3.qpic.cn/psb?/V12AurWQ0oasVT/CIERbWrfTjSkP*mlsLAQ3FTpz851O0BAajebSKq6sEQ!/c/dAYBAAAAAAAA&ek=1&kp=1&pt=0&bo=kAHZAJAB2QACACQ!&sce=0-12-12&rf=0-18", advUrl));
        return mlist;
    }
}
