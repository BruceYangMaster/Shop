package com.deepblue.shop.Business.Adapter.shopcaradapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepblue.shop.Business.Model.bean.GoodsBean;
import com.deepblue.shop.Business.Model.bean.StoreBean;
import com.deepblue.shop.R;
import com.deepblue.shop.UnlessBusiness.Utils.Logs;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by louisgeek on 2016/4/27.
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "MyBaseEtAdapter";
    List<Map<String, Object>> parentMapList;
    List<List<Map<String, Object>>> childMapList_list;
    Context context;
    private ArrayList<String> name = new ArrayList<>();
    int totalCount = 0;
    double totalPrice = 0.00;
    public static final String EDITING = "编辑";
    public static final String FINISH_EDITING = "完成";
    OnAllCheckedBoxNeedChangeListener onAllCheckedBoxNeedChangeListener;
    OnGoodsCheckedChangeListener onGoodsCheckedChangeListener;
    OnCheckHasGoodsListener onCheckHasGoodsListener;

    public void setOnCheckHasGoodsListener(OnCheckHasGoodsListener onCheckHasGoodsListener) {
        this.onCheckHasGoodsListener = onCheckHasGoodsListener;
    }

    public void setOnEditingTvChangeListener(OnEditingTvChangeListener onEditingTvChangeListener) {
        this.onEditingTvChangeListener = onEditingTvChangeListener;
    }

    OnEditingTvChangeListener onEditingTvChangeListener;

    public void setOnGoodsCheckedChangeListener(OnGoodsCheckedChangeListener onGoodsCheckedChangeListener) {
        this.onGoodsCheckedChangeListener = onGoodsCheckedChangeListener;
    }

    public void setOnAllCheckedBoxNeedChangeListener(OnAllCheckedBoxNeedChangeListener onAllCheckedBoxNeedChangeListener) {
        this.onAllCheckedBoxNeedChangeListener = onAllCheckedBoxNeedChangeListener;
    }

    public MyBaseExpandableListAdapter(Context context, List<Map<String, Object>> parentMapList, List<List<Map<String, Object>>> childMapList_list) {
        this.parentMapList = parentMapList;
        this.childMapList_list = childMapList_list;
        this.context = context;
    }


    //获取当前父item的数据数量
    @Override
    public int getGroupCount() {
        return parentMapList.size();
    }

    //获取当前父item下的子item的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return childMapList_list.get(groupPosition).size();
    }

    //获取当前父item的数据
    @Override
    public Object getGroup(int groupPosition) {
        return parentMapList.get(groupPosition);
    }

    //得到子item需要关联的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMapList_list.get(groupPosition).get(childPosition);
    }

    //得到父item的ID
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //得到子item的ID
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        //return false;
        return true;
    }

    //设置父item组件
    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.parent_layout, null);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tv_title_parent = (TextView) convertView
                    .findViewById(R.id.tv_title_parent);
            groupViewHolder.id_cb_select_parent = (CheckBox) convertView
                    .findViewById(R.id.id_cb_select_parent);

            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
        final String parentName = storeBean.getName();
        groupViewHolder.tv_title_parent.setText(parentName);


        //覆盖原有收起展开事件
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "店铺：" + parentName, Toast.LENGTH_SHORT).show();
            }
        });


        groupViewHolder.id_cb_select_parent.setChecked(storeBean.isChecked());
        final boolean nowBeanChecked = storeBean.isChecked();
        groupViewHolder.id_cb_select_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupOneParentAllChildChecked(!nowBeanChecked, groupPosition);
                //控制总checkedbox 接口
                onAllCheckedBoxNeedChangeListener.onCheckedBoxNeedChange(dealAllParentIsChecked());
            }
        });
        return convertView;
    }

    //设置子item的组件
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.car_item_content, null);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tv_items_child = (TextView) convertView
                    .findViewById(R.id.car_item_content_title);

            childViewHolder.id_cb_select_child = (CheckBox) convertView
                    .findViewById(R.id.car_checkbox);

            childViewHolder.id_im_image  = (SimpleDraweeView) convertView.findViewById(R.id.car_item_content_img);  //图片
            //常规下：
//            childViewHolder.tv_items_child_desc = (TextView) convertView
//                    .findViewById(R.id.tv_items_child_desc);    //此处后面再写（描述）
            childViewHolder.id_tv_price = (TextView) convertView
                    .findViewById(R.id.car_item_content_price);

//            childViewHolder.id_tv_discount_price = (TextView) convertView
//                    .findViewById(R.id.id_tv_discount_price);   //此处后面再写（折扣价格）

            childViewHolder.id_tv_count = (TextView) convertView
                    .findViewById(R.id.num_textview);     //数量
//            childViewHolder.id_ed_count = (EditText) convertView.findViewById(R.id.num_textview);
            childViewHolder.id_iv_add = (TextView) convertView.findViewById(R.id.num_add_textview);   //加
            childViewHolder.id_iv_reduce = (TextView) convertView.findViewById(R.id.num_desc_textview);  //减
            childViewHolder.id_tv_goods_delete = (TextView) convertView.findViewById(R.id.car_delete_img);   //删除

            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }


        final GoodsBean goodsBean = (GoodsBean) childMapList_list.get(groupPosition).get(childPosition).get("childName");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "商品：" + goodsBean.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        if (!TextUtils.isEmpty(goodsBean.getImageLogo())){
            Uri uri = Uri.parse(goodsBean.getImageLogo());
            childViewHolder.id_im_image.setImageURI(uri);
        }


        childViewHolder.tv_items_child.setText(goodsBean.getName());
        childViewHolder.id_tv_price.setText(String.format(context.getString(R.string.price), goodsBean.getPrice()));
        // childViewHolder.id_tv_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//数字划线效果
//        childViewHolder.id_tv_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并抗锯齿

//        childViewHolder.id_tv_discount_price.setText(String.format(context.getString(R.string.price), goodsBean.getDiscountPrice()));
//        childViewHolder.tv_items_child_desc.setText(String.valueOf(goodsBean.getDesc()));

//        childViewHolder.id_tv_count.setText(String.format(context.getString(R.string.good_count), goodsBean.getCount()));
//        childViewHolder.id_tv_count_now.setText(String.valueOf(goodsBean.getCount()));

        childViewHolder.id_tv_count.setText(goodsBean.getCount()+"");

//        double priceNow = goodsBean.getCount() * goodsBean.getDiscountPrice();//小结
//        childViewHolder.id_tv_price_now.setText(String.format(context.getString(R.string.price), priceNow));
//        childViewHolder.id_tv_des_now.setText(goodsBean.getDesc());

        childViewHolder.id_cb_select_child.setChecked(goodsBean.isChecked());
        childViewHolder.id_cb_select_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean nowBeanChecked = goodsBean.isChecked();
                //更新数据
                goodsBean.setIsChecked(!nowBeanChecked);

                boolean isOneParentAllChildIsChecked = dealOneParentAllChildIsChecked(groupPosition);

                StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
                storeBean.setIsChecked(isOneParentAllChildIsChecked);


                notifyDataSetChanged();
                //控制总checkedbox 接口
                onAllCheckedBoxNeedChangeListener.onCheckedBoxNeedChange(dealAllParentIsChecked());
                dealPrice();
            }
        });


        childViewHolder.id_iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView textView= (TextView) v.getRootView().findViewById(R.id.id_tv_num);
                dealAdd(goodsBean);
            }
        });
        childViewHolder.id_iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView textView= (TextView) v.getRootView().findViewById(R.id.id_tv_num);
                dealReduce(goodsBean);
            }
        });
        childViewHolder.id_tv_goods_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(context, "删除商品：" + goodsBean.getName(), Toast.LENGTH_SHORT).show();
                removeOneGood(groupPosition, childPosition);
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // return false;
        return true;
    }

    //供全选按钮调用
    public void setupAllChecked(boolean isChecked) {
        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            storeBean.setIsChecked(isChecked);

            String parent = storeBean.getName();
            if (!name.contains(parent))
                name.add(parent);    //保存店名，以判断是否分别付款

            List<Map<String, Object>> childMapList = childMapList_list.get(i);
            for (int j = 0; j < childMapList.size(); j++) {
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                goodsBean.setIsChecked(isChecked);
            }
        }
        if (!isChecked){
            name.clear();
        }
        notifyDataSetChanged();
        dealPrice();
    }

    private void setupOneParentAllChildChecked(boolean isChecked, int groupPosition) {
        StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
        storeBean.setIsChecked(isChecked);
        String parent = storeBean.getName();
        if (isChecked){
            if (!name.contains(parent))
                name.add(parent);
        }else {
            if (name.contains(parent))
                name.remove(parent);
        }

        List<Map<String, Object>> childMapList = childMapList_list.get(groupPosition);
        for (int j = 0; j < childMapList.size(); j++) {
            GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
            goodsBean.setIsChecked(isChecked);
        }
        notifyDataSetChanged();
        dealPrice();
    }

    public boolean dealOneParentAllChildIsChecked(int groupPosition) {
         StoreBean storeBean= (StoreBean) parentMapList.get(groupPosition).get("parentName");
        String parent = storeBean.getName();
//        if (storeBean.isChecked()){
            if (!name.contains(parent))
                name.add(parent);
//        }else {
//            if (name.contains(parent))
//                name.remove(parent);
//        }
        Logs.d("name------4444--"+name);//  此处保存下来之后不能移除，待思考，但绝大多数情况下仍可正常运行

        List<Map<String, Object>> childMapList = childMapList_list.get(groupPosition);
        for (int j = 0; j < childMapList.size(); j++) {
            GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
            if (!goodsBean.isChecked()) {
                return false;//如果有一个没选择  就false
            }
        }
        return true;
    }

    public boolean dealAllParentIsChecked() {

        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            if (!storeBean.isChecked()) {
                return false;//如果有一个没选择  就false
            }
        }
        return true;
    }

    public void dealPrice() {
        // showList();
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < parentMapList.size(); i++) {
            //StoreBean storeBean= (StoreBean) parentMapList.get(i).get("parentName");

            List<Map<String, Object>> childMapList = childMapList_list.get(i);
            for (int j = 0; j < childMapList.size(); j++) {
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                int count = goodsBean.getCount();
//                double discountPrice = goodsBean.getDiscountPrice();   //处理折扣价格
                double discountPrice = goodsBean.getPrice();   //处理实价价格
                if (goodsBean.isChecked()) {
                    totalCount++;//单品多数量只记1
                    totalPrice += discountPrice * count;
                }

            }
        }
        Logs.w("name--22--"+name);
        //计算回调
        onGoodsCheckedChangeListener.onGoodsCheckedChange(totalCount, totalPrice,name);
    }

    //供总编辑按钮调用
    public void setupEditingAll(boolean isEditingAll) {
        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            storeBean.setIsEditing(isEditingAll);

            List<Map<String, Object>> childMapList = childMapList_list.get(i);
            for (int j = 0; j < childMapList.size(); j++) {
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                goodsBean.setIsEditing(isEditingAll);
            }
        }
        notifyDataSetChanged();
    }

    public boolean dealAllEditingIsEditing() {
        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            if (storeBean.isEditing()) {//!!!
                return true;//如果有一个是编辑状态  就true
            }
        }
        return false;
    }

    public void setupEditing(int groupPosition) {
        StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
        boolean isEditing = !storeBean.isEditing();
        storeBean.setIsEditing(isEditing);
        List<Map<String, Object>> childMapList = childMapList_list.get(groupPosition);
        for (int j = 0; j < childMapList.size(); j++) {
            GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
            goodsBean.setIsEditing(isEditing);
        }
        notifyDataSetChanged();
    }

    public void dealAdd(GoodsBean goodsBean) {
        int count = goodsBean.getCount();
        count++;
        goodsBean.setCount(count);
        //  textView.setText(String.valueOf(count));
        notifyDataSetChanged();
        dealPrice();
    }

    public void dealReduce(GoodsBean goodsBean) {
        int count = goodsBean.getCount();
        if (count == 1) {
            return;
        }
        count--;
        goodsBean.setCount(count);
        // textView.setText(String.valueOf(count));
        notifyDataSetChanged();
        dealPrice();
    }

    public void removeOneGood(int groupPosition, int childPosition) {
        //StoreBean storeBean = (StoreBean) parentMapList.get(groupPosition).get("parentName");
        List<Map<String, Object>> childMapList = childMapList_list.get(groupPosition);
       // GoodsBean goodsBean = (GoodsBean) childMapList.get(childPosition).get("childName");
        childMapList.remove(childPosition);

        //通过子项
       if (childMapList!=null&&childMapList.size()>0){

        }else {
             parentMapList.remove(groupPosition);
             childMapList_list.remove(groupPosition);//！！！！因为parentMapList和childMapList_list是pos关联的  得保持一致
        }
        if (parentMapList != null && parentMapList.size() > 0) {
            onCheckHasGoodsListener.onCheckHasGoods(true);//
        } else {
            onCheckHasGoodsListener.onCheckHasGoods(false);//
        }
        notifyDataSetChanged();
        dealPrice();
    }

    public void removeGoods() {
    /*    for (int i = 0; i <parentMapList.size(); i++) {
            StoreBean storeBean= (StoreBean) parentMapList.get(i).get("parentName");

                List<Map<String, Object>> childMapList = childMapList_list.get(i);
                for (int j = 0; j < childMapList.size(); j++) {
                    GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                    Log.d(TAG, "removeGoods:============goodsBean:" + goodsBean.isChecked());
                    if (goodsBean.isChecked()) {
                        childMapList.remove(j);
                        j--;//!!!!!!!!!!  List remove方法比较特殊 每移除一个元素以后再把pos移回来
                    }
                }
        }*/

        for (int i = parentMapList.size()-1; i>=0; i--) {//倒过来遍历  remove
            StoreBean storeBean= (StoreBean) parentMapList.get(i).get("parentName");
            if (storeBean.isChecked()){
                parentMapList.remove(i);
                childMapList_list.remove(i);
            }else {
            List<Map<String, Object>> childMapList = childMapList_list.get(i);
            for (int j = childMapList.size()-1; j >=0; j--) {//倒过来遍历  remove
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                if (goodsBean.isChecked()) {
                    childMapList.remove(j);
                }
            }
            }

        }
       // showList("begin###############");
        /**1.不要边遍历边删除，容易出现数组越界的情况<br>
         * 2.现将要删除的对象放进相应的列表容器中，待遍历完后，以removeAll的方式进行删除*/  //还是有问题
        /*List<Map<String, Object>> needRemoreParentMapList = new ArrayList<>();// 待删除的组元素列表
        List<List<Map<String, Object>>> needRemoreChildMapList_List = new ArrayList<>();// 待删除的  最大的

        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");

            if(storeBean.isChecked()){
                needRemoreParentMapList.add(parentMapList.get(i));
                needRemoreChildMapList_List.add(childMapList_list.get(i));//！！！！因为parentMapList和childMapList_list是pos关联的  得保持一致
            }
                //
                List<Map<String, Object>> childMapList = childMapList_list.get(i);//最大的

                List<Map<String, Object>> needRemoreChildMapList = new ArrayList<>();// 待删除的子元素列表

                for (int j = 0; j < childMapList.size(); j++) {
                    GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                    if (goodsBean.isChecked()) {
                        needRemoreChildMapList.add(childMapList.get(j));
                    }
                }

                childMapList.removeAll(needRemoreChildMapList);//正式删除子元素  不是childMapList_list  ！！！

        }
        parentMapList.removeAll(needRemoreParentMapList);//正式删除父元素
        Log.d(TAG, "removeGoods: needRemoreChildMapList_List"+needRemoreChildMapList_List);
        childMapList_list.remove(needRemoreChildMapList_List);//！！！！因为parentMapList和childMapList_list是pos关联的  得保持一致
*/
        //!!!!!!!!!!!!!!!删除完 状态需要重置   待思考  why？
        //resetViewAfterDelete();
        if (parentMapList != null && parentMapList.size() > 0) {
            onCheckHasGoodsListener.onCheckHasGoods(true);//
        } else {
            onCheckHasGoodsListener.onCheckHasGoods(false);//
        }
        notifyDataSetChanged();//
        dealPrice();//重新计算
    }

    private void resetViewAfterDelete() {
        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            storeBean.setIsChecked(false);
            storeBean.setIsEditing(false);
            List<Map<String, Object>> childMapList = childMapList_list.get(i);

            for (int j = 0; j < childMapList.size(); j++) {
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                goodsBean.setIsChecked(false);
                goodsBean.setIsEditing(false);
            }
        }
    }

    void showList(String tempStr) {
        Log.d(TAG, "showList:"+tempStr);
        for (int i = 0; i < parentMapList.size(); i++) {
            StoreBean storeBean = (StoreBean) parentMapList.get(i).get("parentName");
            Log.d(TAG, "showList:  parentName:【" + storeBean.getName()+"】isChecked:" + storeBean.isChecked());
            List<Map<String, Object>> childMapList = childMapList_list.get(i);
            for (int j = 0; j < childMapList.size(); j++) {
                GoodsBean goodsBean = (GoodsBean) childMapList.get(j).get("childName");
                Log.d(TAG, "showList:  childName:" + goodsBean.getName()+"isChecked:" + goodsBean.isChecked());
            }
        }
    }

    public interface OnAllCheckedBoxNeedChangeListener {
        void onCheckedBoxNeedChange(boolean allParentIsChecked);
    }

    public interface OnEditingTvChangeListener {
        void onEditingTvChange(boolean allIsEditing);
    }

    public interface OnGoodsCheckedChangeListener {
        void onGoodsCheckedChange(int totalCount, double totalPrice,ArrayList<String> nameList);
    }

    public interface OnCheckHasGoodsListener {
        void onCheckHasGoods(boolean isHasGoods);
    }

    class GroupViewHolder {
        TextView tv_title_parent;
//        TextView id_tv_edit;
        CheckBox id_cb_select_parent;
    }

    class ChildViewHolder {
        TextView tv_items_child;
        CheckBox id_cb_select_child;
//        LinearLayout id_ll_normal;
//        LinearLayout id_ll_edtoring;

//        TextView tv_items_child_desc;
        TextView id_tv_price;
//        TextView id_tv_discount_price;
        TextView id_tv_count;
        ImageView id_im_image;
//        EditText id_ed_count;

        TextView id_iv_reduce;
        TextView id_iv_add;
//        TextView id_tv_des_now;
//        TextView id_tv_count_now;
        TextView id_tv_price_now;
//        TextView id_tv_goods_star;
        TextView id_tv_goods_delete;

    }

}
