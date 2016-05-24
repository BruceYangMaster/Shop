package com.deepblue.shop.Business.Model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/24 0024.
 */

/**
 * 首页的广告
 */
public class Adv implements Serializable {
    private String imgUrl;
    private String linkUrl;

    public Adv(String imgUrl, String linkUrl) {
        this.imgUrl = imgUrl;
        this.linkUrl = linkUrl;
    }

    public Adv() {

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
