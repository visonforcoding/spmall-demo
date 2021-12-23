package com.vison.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(appliesTo = "address", comment = "地址表")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Address extends BaseEntity {
    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '详细地址'")
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
