package com.vison.demo.entity;


import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(appliesTo = "goods", comment = "商品表")
public class Goods extends BaseEntity {

    @Column(columnDefinition = "varchar(25) NOT NULL comment '商品名'")
    @NotBlank(message = "商品名不可为空")
    private String name;
    private String cover;
    @NotNull(message = "商品单价必填")
    private Integer unitPriceFen;
    @Column(columnDefinition = "int NOT NULL comment '采购价'")
    @NotNull(message = "商品采购价不可为空")
    private Integer purchasingPriceFen;
    @Transient
    private String purchasingPrice;

    @Column(columnDefinition = "bigint NOT NULL comment '商品类别'")
    @NotNull(message = "商品分类不可为空")
    private Long goodsCatId;

    @Transient
    @OneToOne
    private GoodsCat goodsCat;

    private String description;

    @OneToMany(mappedBy = "goods")
    private Set<OrderGoods> orderGoods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getUnitPriceFen() {
        return unitPriceFen;
    }

    public void setUnitPriceFen(Integer unitPriceFen) {
        this.unitPriceFen = unitPriceFen;
    }

    public Integer getPurchasingPriceFen() {
        return purchasingPriceFen;
    }

    public void setPurchasingPriceFen(Integer purchasingPriceFen) {
        this.purchasingPriceFen = purchasingPriceFen;
    }

    public String getPurchasingPrice() {
        return String.format("%d", this.purchasingPriceFen / 100);
    }

    public void setPurchasingPrice(String purchasingPrice) {

        this.purchasingPrice = purchasingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGoodsCatId() {
        return goodsCatId;
    }

    public void setGoodsCatId(Long goodsCatId) {
        this.goodsCatId = goodsCatId;
    }

    public GoodsCat getGoodsCat() {
        return goodsCat;
    }

    public void setGoodsCat(GoodsCat goodsCat) {
        this.goodsCat = goodsCat;
    }
}
