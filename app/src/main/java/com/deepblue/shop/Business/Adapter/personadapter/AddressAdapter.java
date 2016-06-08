package com.deepblue.shop.Business.Adapter.personadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.deepblue.shop.Business.Model.User;
import com.deepblue.shop.R;

import java.util.ArrayList;

/**
 * Created by 欢大哥 on 2016/6/7.
 */
public class AddressAdapter extends BaseAdapter {
    private ArrayList<User> mList;
    private Context context;
    public AddressAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<User> list){
        this.mList = list;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.address_item,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.address_name);
            viewHolder.address = (TextView) view.findViewById(R.id.address_txt);
            viewHolder.phone = (TextView) view.findViewById(R.id.address_phone);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        User user = (User) getItem(i);
        viewHolder.phone.setText(user.getUserPhone());
        viewHolder.name.setText(user.getUserName());
        viewHolder.address.setText(user.getUserAddress());
        return view;
    }

    class ViewHolder{
        TextView name;
        TextView address;
        TextView phone;

    }
}
