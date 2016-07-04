package com.deepblue.shop.UnlessBusiness.Login;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.deepblue.shop.Business.Adapter.HomeAdapter.GoodsMainAdapter;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class LoginInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        initWidget();
    }

    private void initWidget() {
        /**
         * 初始化title
         */
        initTitle();
        /**
         * 得到下面的内容
         */
        initContent();
    }

    private void initContent() {
        ViewPager mLoginVp = (ViewPager) findViewById(R.id.login_content_vp);
        /**
         * 登录界面
         */
        View loginView = LayoutInflater.from(this).inflate(R.layout.login_login_layout, null);
        /**
         * 注册界面
         */
        View registerView = LayoutInflater.from(this).inflate(R.layout.login_register_layout, null);
        /**
         * list（里面是三个view）
         *
         */
        ArrayList<View> viewArrayList = new ArrayList<>();
        viewArrayList.add(loginView);
        viewArrayList.add(registerView);
        /**
         * 初始化适配器，讲控件vp绑定到适配器上
         */
        GoodsMainAdapter goodsMainAdapter = new GoodsMainAdapter(viewArrayList, this);
        mLoginVp.setAdapter(goodsMainAdapter);
    }

    private void initText() {

    }

    private void initTitle() {
        /**
         * 点击销毁当前界面
         */
        findViewById(R.id.login_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * 初始化登录和注册这两个字
         */
        initText();
    }

    // -------------------------------------隐藏输入法-----------------------------------------------------
    // 获取点击事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            if (isHideInput(view, ev)) {
                HideSoftInput(view.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    // 判定是否需要隐藏
    private boolean isHideInput(View v, MotionEvent ev) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top
                    && ev.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    // 隐藏软键盘
    private void HideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
