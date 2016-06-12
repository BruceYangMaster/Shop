package com.deepblue.shop.Business.Activity.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deepblue.shop.Business.CustomView.MyDialog;
import com.deepblue.shop.R;

public class BodyInfoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_info);
        initWight();
    }
    public void initWight(){
        TextView mBack = (TextView) findViewById(R.id.back_txt);
        RelativeLayout mHeadImgae = (RelativeLayout) findViewById(R.id.person_image_relat);
        RelativeLayout mAddess = (RelativeLayout) findViewById(R.id.address_relat);

        mAddess.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mHeadImgae.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_txt:
                finish();
                break;
            case R.id.address_relat:
                Intent intent = new Intent(this,AddressActivity.class);
                startActivity(intent);
                break;
            case R.id.person_image_relat:
                dialogInfo();
                break;
        }
    }

    /**
     * 自定义对话框信息
     */
    public void dialogInfo(){
        MyDialog myDialog = new MyDialog(this,R.layout.head_image_item,R.style.myDialog);
        myDialog.show();
    }
}
