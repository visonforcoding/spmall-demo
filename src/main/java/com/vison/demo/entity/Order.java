package com.vison.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "dorder")
@Table(appliesTo = "dorder", comment = "订单表")
public class Order extends BaseEntity {

    private String orderNo;

    private Long uid;

    private Integer status;

    private Integer orderPriceFen;


    @OneToMany(mappedBy = "order")
    @Transient
    @JsonIgnoreProperties(value = {"order"})
    private Set<OrderGoods> orderGoods;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderPriceFen() {
        return orderPriceFen;
    }

    public void setOrderPriceFen(Integer orderPriceFen) {
        this.orderPriceFen = orderPriceFen;
    }

    public Set<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Set<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
