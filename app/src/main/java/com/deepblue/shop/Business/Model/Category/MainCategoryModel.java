package com.deepblue.shop.Business.Model.Category;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/25 0025.
 */

/**
 * 分类左边main类别的model
 */
public class MainCategoryModel implements Serializable {
    private String ImagUrl;//类别的图片url
    private String CategoryName;//类别名字
    private boolean isChecked;//是否被选中

    public String getImagUrl() {
        return ImagUrl;
    }

    public void setImagUrl(String imagUrl) {
        ImagUrl = imagUrl;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
