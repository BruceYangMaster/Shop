package com.deepblue.shop.Business.Fragment.ShoppingCar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.deepblue.shop.Business.Adapter.shopcaradapter.MyBaseExpandableListAdapter;
import com.deepblue.shop.Business.Model.bean.GoodsBean;
import com.deepblue.shop.Business.Model.bean.StoreBean;
import com.deepblue.shop.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ShoppingCarFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCarFragmentTwo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View mView;
    private TextView mTotalPrice;
    private CheckBox mAllCheck;
    MyBaseExpandableListAdapter myBaseExpandableListAdapter;
    ExpandableListView expandableListView;
    //定义父列表项List数据集合
    List<Map<String, Object>> parentMapList = new ArrayList<Map<String, Object>>();
    //定义子列表项List数据集合
    List<List<Map<String, Object>>> childMapList_list = new ArrayList<List<Map<String, Object>>>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ShoppingCarFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingCarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingCarFragmentTwo newInstance(String param1, String param2) {
        ShoppingCarFragmentTwo fragment = new ShoppingCarFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(getActivity());
        initCarData();   //初始化数据
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_shopping_car, container, false);

        initWight();

        return mView;
    }

    /**
     * 初始化控件
     */
    public void initWight(){
        expandableListView = (ExpandableListView) mView.findViewById(R.id.car_content);   //list
        mAllCheck = (CheckBox) mView.findViewById(R.id.car_allcheck);  //全选
        mTotalPrice = (TextView) mView.findViewById(R.id.car_price_all);    //总价

        initAdapter();

        mAllCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) v;
                    myBaseExpandableListAdapter.setupAllChecked(checkBox.isChecked());
                }
            }
        });

        for (int i = 0; i < parentMapList.size(); i++) {
            expandableListView.expandGroup(i);
        }

        myBaseExpandableListAdapter.setOnGoodsCheckedChangeListener(new MyBaseExpandableListAdapter.OnGoodsCheckedChangeListener() {
            @Override
            public void onGoodsCheckedChange(int totalCount, double totalPrice) {
                mTotalPrice.setText(String.format(getString(R.string.price), totalPrice));
//                id_tv_totalCount_jiesuan.setText(String.format(getString(R.string.jiesuan), totalCount));   //结算时的总数量
            }
        });

        myBaseExpandableListAdapter.setOnAllCheckedBoxNeedChangeListener(new MyBaseExpandableListAdapter.OnAllCheckedBoxNeedChangeListener() {
            @Override
            public void onCheckedBoxNeedChange(boolean allParentIsChecked) {
                mAllCheck.setChecked(allParentIsChecked);
            }
        });

        myBaseExpandableListAdapter.setOnEditingTvChangeListener(new MyBaseExpandableListAdapter.OnEditingTvChangeListener() {
            @Override
            public void onEditingTvChange(boolean allIsEditing) {

//                changeFootShowDeleteView(allIsEditing);//这边类似的功能 后期待使用观察者模式

            }
        });

        myBaseExpandableListAdapter.setOnCheckHasGoodsListener(new MyBaseExpandableListAdapter.OnCheckHasGoodsListener() {
            @Override
            public void onCheckHasGoods(boolean isHasGoods) {
//                setupViewsShow(isHasGoods);
            }
        });
    }

    public void initAdapter(){

        myBaseExpandableListAdapter = new MyBaseExpandableListAdapter(getActivity(), parentMapList, childMapList_list);
        expandableListView.setAdapter(myBaseExpandableListAdapter);
    }

    public void initCarData(){

        //提供父列表的数据
        Map<String, Object> parentMap = new HashMap<String, Object>();
                StoreBean ben = new StoreBean();
                ben.setName("电商平台1");
                parentMap.put("parentName", ben);
            parentMapList.add(parentMap);
            //提供当前父列的子列数据
            List<Map<String, Object>> childMapList = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < 3; j++) {
                Map<String, Object> childMap = new HashMap<String, Object>();
                GoodsBean goodsBean = new GoodsBean();
                goodsBean.setCount(1);
                goodsBean.setName("成都老火锅");
                goodsBean.setPrice(123.00);
                goodsBean.setImageLogo("http://img4.duitang.com/uploads/item/201301/26/20130126225257_QkaSQ.thumb.600_0.jpeg");
                childMap.put("childName", goodsBean);
                childMapList.add(childMap);
            }
            childMapList_list.add(childMapList);
//            listInfo.add(info);

        //提供父列表的数据
        parentMap = new HashMap<String, Object>();
                ben = new StoreBean();
                ben.setName("电商平台2");
                parentMap.put("parentName", ben);

            parentMapList.add(parentMap);
            //提供当前父列的子列数据
            childMapList = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < 3; j++) {
                Map<String, Object> childMap = new HashMap<String, Object>();
                GoodsBean goodsBean = new GoodsBean();
                goodsBean.setCount(1);
                goodsBean.setName("重庆老火锅");
                goodsBean.setPrice(345.00);
                goodsBean.setImageLogo("http://img4.duitang.com/uploads/item/201301/26/20130126225257_QkaSQ.thumb.600_0.jpeg");
                childMap.put("childName", goodsBean);
                childMapList.add(childMap);
            }
            childMapList_list.add(childMapList);
//            listInfo.add(info);
        //提供父列表的数据
        parentMap = new HashMap<String, Object>();
                ben = new StoreBean();
                ben.setName("电商平台3");
                parentMap.put("parentName", ben);

            parentMapList.add(parentMap);
            //提供当前父列的子列数据
            childMapList = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < 3; j++) {
                Map<String, Object> childMap = new HashMap<String, Object>();
                GoodsBean goodsBean = new GoodsBean();
                goodsBean.setCount(1);
                goodsBean.setName("重庆老火锅2");
                goodsBean.setPrice(200.00);
                goodsBean.setImageLogo("http://life.xiancn.com/images/site2/20100414/e4e30fd40f281c0d71103bf79ff00e2b.jpg");
                childMap.put("childName", goodsBean);
                childMapList.add(childMap);
            }
            childMapList_list.add(childMapList);
//            listInfo.add(info);


    }


}