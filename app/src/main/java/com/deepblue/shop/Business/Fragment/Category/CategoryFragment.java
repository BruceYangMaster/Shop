package com.deepblue.shop.Business.Fragment.Category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.deepblue.shop.Business.Adapter.CategoryAdapter.CategoryLeftAdapter;
import com.deepblue.shop.Business.Model.Category.MainCategoryModel;
import com.deepblue.shop.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private ListView mLeftListView;
    private ListView mRightListView;
    private CategoryLeftAdapter categoryLeftAdapter;


    public CategoryFragment() {

    }


    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initLeftList(view);
        initRightList(view);
        return view;
    }


    /**
     * 初始化左边listview
     *
     * @param view
     */
    private void initLeftList(View view) {
        mLeftListView = (ListView) view.findViewById(R.id.category_leftlist);
/**
 * 初始化左边的list数据
 */
        ArrayList<MainCategoryModel> mainCategoryModelArrayList = initLeftListData();
        //初始化适配器
        categoryLeftAdapter = new CategoryLeftAdapter(getContext());
        categoryLeftAdapter.setData(mainCategoryModelArrayList);
        mLeftListView.setAdapter(categoryLeftAdapter);
        /**
         * 给listview添加点击变色事件
         */
//        mLeftListView.setSelectionFromTop(1, 1);
        mLeftListView.setSelection(0);
        mLeftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                parent.requestFocusFromTouch(); // IMPORTANT!
//                parent.setSelection(position);
                //

                mRightListView.setItemChecked(position, true);
            }
        });

    }

    /**
     * 初始化左边list数据
     *
     * @return
     */
    private ArrayList<MainCategoryModel> initLeftListData() {
        ArrayList<MainCategoryModel> list = new ArrayList<>();
        MainCategoryModel mainCategoryModel = new MainCategoryModel();
        mainCategoryModel.setCategoryName("耐克");
        mainCategoryModel.setImagUrl("http://d.ifengimg.com/w140_h100/p3.ifengimg.com/a/2016_22/edb675d163ac6e2.jpg");
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        list.add(mainCategoryModel);
        return list;
    }

    /**
     * 初始化右边listview
     *
     *
     * @param view
     */
    private void initRightList(View view) {
        mRightListView = (ListView) view.findViewById(R.id.category_rightlist);
        /**
         * 初始化左边的list数据
         */
        ArrayList<MainCategoryModel> mainCategoryModelArrayList = initLeftListData();
        //初始化适配器
        categoryLeftAdapter = new CategoryLeftAdapter(getContext());
        categoryLeftAdapter.setData(mainCategoryModelArrayList);
        mRightListView.setAdapter(categoryLeftAdapter);


    }
}
