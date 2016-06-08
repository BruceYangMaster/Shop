package com.deepblue.shop.Business.Activity.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.deepblue.shop.Business.Adapter.personadapter.AddressAdapter;
import com.deepblue.shop.Business.Model.User;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initWight();
    }

    public void initWight(){
        TextView mBack = (TextView) findViewById(R.id.back_txt);
        ListView mList = (ListView) findViewById(R.id.address_item_list);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        AddressAdapter adapter = new AddressAdapter(this);
        adapter.setData(initData());
        mList.setAdapter(adapter);
    }

    public ArrayList<User> initData(){
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0;i<3;i++){
            User user = new User();
            user.setUserName("小明"+i);
            user.setUserAddress("四川省简阳市"+i);
            user.setUserPhone("12345678901");
            list.add(user);
        }
        return list;
    }
}
