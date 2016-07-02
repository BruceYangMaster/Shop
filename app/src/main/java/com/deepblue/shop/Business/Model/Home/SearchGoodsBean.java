package com.deepblue.shop.Business.Model.Home;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class SearchGoodsBean implements Serializable {
    private String goodsImgUrl;
    private String goodsName;
    private double goodsPrice;
    private int goodsSaleVolume;

    public SearchGoodsBean() {
    }

    public SearchGoodsBean(String goodsImgUrl, String goodsName, double goodsPrice, int goodsSaleVolume) {
        this.goodsImgUrl = goodsImgUrl;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsSaleVolume = goodsSaleVolume;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsSaleVolume() {
        return goodsSaleVolume;
    }

    public void setGoodsSaleVolume(int goodsSaleVolume) {
        this.goodsSaleVolume = goodsSaleVolume;
    }
}
