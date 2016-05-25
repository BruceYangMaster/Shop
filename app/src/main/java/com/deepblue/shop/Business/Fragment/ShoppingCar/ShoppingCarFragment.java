package com.deepblue.shop.Business.Fragment.ShoppingCar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.deepblue.shop.Business.Adapter.CarContentAdapter;
import com.deepblue.shop.Business.Model.GoodsInfo;
import com.deepblue.shop.Business.Model.SharePrenceUtil;
import com.deepblue.shop.R;
import com.deepblue.shop.UnlessBusiness.Utils.Logs;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ShoppingCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View mView;
    private ListView mCarList;
    private CheckBox mAllCheck;
    private CarContentAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ShoppingCarFragment() {
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
    public static ShoppingCarFragment newInstance(String param1, String param2) {
        ShoppingCarFragment fragment = new ShoppingCarFragment();
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
        mCarList = (ListView) mView.findViewById(R.id.car_content);   //list
        mAllCheck = (CheckBox) mView.findViewById(R.id.car_allcheck);  //全选

        initAdapter();

        mAllCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Logs.d("mAllCheck-----"+b);
                SharedPreferences sp = getActivity().getSharedPreferences(SharePrenceUtil.SHARE_CAR_ALLCHECK, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                if (b){
                    edit.putString(SharePrenceUtil.ISALLCHECK,"1").commit();
                    Logs.d("mAllCheck-----"+1);
                }else {
                    edit.putString(SharePrenceUtil.ISALLCHECK,"0").commit();
                    Logs.d("mAllCheck-----"+0);
                }
                adapter.notifyDataSetChanged();
            }
        });


    }

    public void initAdapter(){
        adapter = new CarContentAdapter(getContext());
        adapter.setData(initCarData());
        mCarList.setAdapter(adapter);
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
            }
            listInfo.add(info);
        }
        for (int i = 0;i<3;i++){
            GoodsInfo info = new GoodsInfo();
            info.setGoodsBusinessName("电商平台2");
            info.setGoodsNum(1);
            info.setGoodsPrice(345.00);
            info.setGoodsTitle("重庆老火锅");
            info.setGoodsUrl("http://life.xiancn.com/images/site2/20100414/e4e30fd40f281c0d71103bf79ff00e2b.jpg");
            if (i== 0){
                info.setHave(true);
            }
            listInfo.add(info);
        }
        return listInfo;
    }


}
