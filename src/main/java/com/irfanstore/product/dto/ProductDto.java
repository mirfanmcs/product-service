package com.irfanstore.product.dto;


import java.io.Serializable;

public class ProductDto implements Serializable {

    public ProductDto() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    private Long id;

    private String code;

    private String shortDescription;

    private String longDescription;


    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription=" + longDescription +
                '}';
    }
}
