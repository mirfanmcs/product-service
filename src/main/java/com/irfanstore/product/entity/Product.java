package com.irfanstore.product.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Product")
public class Product implements Serializable {

    public Product() {

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


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="product_code")
    private String code;

    @Column(name="short_description")
    private String shortDescription;

    @Column(name="long_description")
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
