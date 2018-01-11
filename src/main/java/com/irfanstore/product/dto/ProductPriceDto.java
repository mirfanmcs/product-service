package com.irfanstore.product.dto;


import java.io.Serializable;

public class ProductPriceDto implements Serializable {

    public ProductPriceDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getMargin() {
        return margin;
    }

    public void setMargin(float margin) {
        this.margin = margin;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private Long id;
    private String code;
    private float buyPrice;
    private float margin;
    private float sellPrice;
    private String currency;
    private String promoCode;
    private String ipAddress;

    @Override
    public String toString() {
        return "ProductPrice {" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", buyPrice='" + buyPrice + '\'' +
                ", margin='" + margin + '\'' +
                ", sellPrice='" + sellPrice + '\'' +
                ", currency=" + currency + '\'' +
                ", promoCode=" + promoCode + '\'' +
                ", ipAddress=" + ipAddress +
                '}';
    }
}
