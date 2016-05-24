package com.deepblue.shop.Business.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 欢大哥 on 2016/5/23.
 */
public class GoodsInfo implements Parcelable {
    private String goodsUrl;    //商品图片
    private String goodsTitle;   //商品名称
    private double goodsPrice;   //商品价格
    private int goodsNum;    //商品数量
    private String goodsBusinessName;   //商家名字

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsBusinessName() {
        return goodsBusinessName;
    }

    public void setGoodsBusinessName(String goodsBusinessName) {
        this.goodsBusinessName = goodsBusinessName;
    }

    public GoodsInfo(){

    }
    protected GoodsInfo(Parcel in) {
        goodsUrl = in.readString();
        goodsTitle = in.readString();
        goodsPrice = in.readDouble();
        goodsNum = in.readInt();
        goodsBusinessName = in.readString();
    }

    public static final Creator<GoodsInfo> CREATOR = new Creator<GoodsInfo>() {
        @Override
        public GoodsInfo createFromParcel(Parcel in) {
            return new GoodsInfo(in);
        }

        @Override
        public GoodsInfo[] newArray(int size) {
            return new GoodsInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(goodsUrl);
        parcel.writeString(goodsTitle);
        parcel.writeDouble(goodsPrice);
        parcel.writeInt(goodsNum);
        parcel.writeString(goodsBusinessName);
    }
}
