package com.deepblue.shop.Business.Fragment.Category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.deepblue.shop.Business.Adapter.CategoryAdapter.CategoryLeftAdapter;
import com.deepblue.shop.R;

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
        categoryLeftAdapter = new CategoryLeftAdapter(getContext());
        mLeftListView.setAdapter(categoryLeftAdapter);
    }

    /**
     * 初始化右边listview
     *
     * @param view
     */
    private void initRightList(View view) {
        mRightListView = (ListView) view.findViewById(R.id.category_rightlist);
    }
}
