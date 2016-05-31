package com.deepblue.shop.Business.Fragment.Personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.deepblue.shop.Business.Activity.person.AllOrderActivity;
import com.deepblue.shop.Business.Activity.person.BusnessCollectionActivity;
import com.deepblue.shop.Business.Activity.person.DaiFaHuoActivity;
import com.deepblue.shop.Business.Activity.person.DaiFuKuanActivity;
import com.deepblue.shop.Business.Activity.person.DaiPingJiaActivity;
import com.deepblue.shop.Business.Activity.person.DaiShouHuoActivity;
import com.deepblue.shop.Business.Activity.person.GoodsCollectionActivity;
import com.deepblue.shop.Business.Activity.person.MyFootActivity;
import com.deepblue.shop.Business.Activity.person.PointActivity;
import com.deepblue.shop.Business.Activity.person.TuiHuanHuoActivity;
import com.deepblue.shop.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PersonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View mView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public PersonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonFragment newInstance(String param1, String param2) {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_person, container, false);
        initWight();
        return mView;
    }

    public void initWight(){
        RelativeLayout mAllOrder = (RelativeLayout) mView.findViewById(R.id.all_order_lin);   //所有订单
        RelativeLayout mAllMoney = (RelativeLayout) mView.findViewById(R.id.all_money_lin);   //我的资产
        RelativeLayout mSetting = (RelativeLayout) mView.findViewById(R.id.all_setting_lin);  //设置地址
        TextView mDaifukuan = (TextView) mView.findViewById(R.id.daifukuan_txt);   //待付款
        TextView mDaifahuo = (TextView) mView.findViewById(R.id.daifahuo_txt);   //待发货
        TextView mDaishouhuo = (TextView) mView.findViewById(R.id.daishouhuo_txt);  //待收货
        TextView mDaipingjia = (TextView) mView.findViewById(R.id.daipingjia_txt);  //待评价
        TextView mTuihuanhuo  = (TextView) mView.findViewById(R.id.tuihuanhuo_txt);   //退换货
        TextView mGouwuquan = (TextView) mView.findViewById(R.id.gouwuquan_txt);  //购物券
        TextView mYouhuiquan = (TextView) mView.findViewById(R.id.youhuiquan_txt);   //优惠券
        TextView mJifen = (TextView) mView.findViewById(R.id.jifen_txt);    //积分
        TextView mHongbao = (TextView) mView.findViewById(R.id.hongbao_txt);  //红包
        LinearLayout mGoodsshoucang = (LinearLayout) mView.findViewById(R.id.shoucang_goods_lin);   //商品收藏
        LinearLayout mBuessshoucang = (LinearLayout) mView.findViewById(R.id.shoucang_buess_lin);   //店铺收藏
        LinearLayout mZuji = (LinearLayout) mView.findViewById(R.id.my_zuji);    //我的足迹
        ImageView mInfo = (ImageView) mView.findViewById(R.id.my_sms_info);   //消息

        mInfo.setOnClickListener(this);
        mAllMoney.setOnClickListener(this);
        mAllOrder.setOnClickListener(this);
        mDaifukuan.setOnClickListener(this);
        mDaifahuo.setOnClickListener(this);
        mDaishouhuo.setOnClickListener(this);
        mDaipingjia.setOnClickListener(this);
        mTuihuanhuo.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        mGouwuquan.setOnClickListener(this);
        mYouhuiquan.setOnClickListener(this);
        mJifen.setOnClickListener(this);
        mHongbao.setOnClickListener(this);
        mGoodsshoucang.setOnClickListener(this);
        mBuessshoucang.setOnClickListener(this);
        mZuji.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.all_order_lin:
                Intent intent = new Intent(getContext(), AllOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.all_money_lin:
                Toast.makeText(getActivity(),"资产点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.all_setting_lin:
                Toast.makeText(getActivity(),"设置点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.daifukuan_txt:
                intent = new Intent(getContext(), DaiFuKuanActivity.class);
                startActivity(intent);
                break;
            case R.id.daifahuo_txt:
                intent = new Intent(getContext(), DaiFaHuoActivity.class);
                startActivity(intent);
                break;
            case R.id.daishouhuo_txt:
                intent = new Intent(getContext(), DaiShouHuoActivity.class);
                startActivity(intent);
                break;
            case R.id.daipingjia_txt:
                intent = new Intent(getContext(), DaiPingJiaActivity.class);
                startActivity(intent);
                break;
            case R.id.tuihuanhuo_txt:
                intent = new Intent(getContext(), TuiHuanHuoActivity.class);
                startActivity(intent);
                break;
            case R.id.gouwuquan_txt:
                Toast.makeText(getActivity(),"购物券",Toast.LENGTH_SHORT).show();
                break;
            case R.id.youhuiquan_txt:
                Toast.makeText(getActivity(),"优惠券",Toast.LENGTH_SHORT).show();
                break;
            case R.id.jifen_txt:
                intent = new Intent(getContext(), PointActivity.class);
                startActivity(intent);
                break;
            case R.id.hongbao_txt:
                Toast.makeText(getActivity(),"红包",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shoucang_goods_lin:
                intent = new Intent(getContext(), GoodsCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.shoucang_buess_lin:
                intent = new Intent(getContext(), BusnessCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.my_zuji:
                intent = new Intent(getContext(), MyFootActivity.class);
                startActivity(intent);
                break;
            case R.id.my_sms_info:
                Toast.makeText(getActivity(),"消息",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
