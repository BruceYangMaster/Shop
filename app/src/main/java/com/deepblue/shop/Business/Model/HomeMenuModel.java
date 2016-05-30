package com.deepblue.shop.Business.Model;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
public class HomeMenuModel {
    private String imgUrl;
    private String menuName;
    private String menuId;

    public HomeMenuModel(String imgUrl, String menuName, String menuId) {
        this.imgUrl = imgUrl;
        this.menuName = menuName;
        this.menuId = menuId;
    }

    public HomeMenuModel() {

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
