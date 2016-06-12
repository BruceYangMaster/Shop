package com.deepblue.shop.Business.Activity.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deepblue.shop.Business.CustomView.MyDialog;
import com.deepblue.shop.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initWight();
    }

    public void initWight(){
        TextView mBack = (TextView) findViewById(R.id.back_txt);
        TextView mExit = (TextView) findViewById(R.id.exit_txt);

        RelativeLayout mBodyInfo = (RelativeLayout) findViewById(R.id.person_info_relat);

        mBack.setOnClickListener(this);
        mBodyInfo.setOnClickListener(this);
        mExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_txt:
                finish();
                break;
            case R.id.person_info_relat:
                Intent intent = new Intent(this,BodyInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.exit_txt:
                dialogInfo();
                break;
        }
    }

    /**
     * 自定义对话框信息
     */
    public void dialogInfo(){
        MyDialog myDialog = new MyDialog(this,R.layout.dialog_exit_layout,R.style.myDialog);
        myDialog.show();
    }
}
