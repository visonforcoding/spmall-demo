package com.vison.demo.entity;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(appliesTo = "goods_cat", comment = "商品类别")
public class GoodsCat extends BaseEntity {
    @Column(columnDefinition = "varchar(25) NOT NULL COMMENT '类别名称'")
    private String name;

    @Column(columnDefinition = "bigint NOT NULL COMMENT '类别父级id'")
    private Long pid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
