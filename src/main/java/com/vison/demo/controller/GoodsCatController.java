package com.vison.demo.controller;

import com.vison.demo.Response;
import com.vison.demo.ResponseCode;
import com.vison.demo.dao.GoodsCatRepository;
import com.vison.demo.dao.GoodsRepository;
import com.vison.demo.entity.Goods;
import com.vison.demo.entity.GoodsCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GoodsCatController {

    @Autowired
    GoodsCatRepository goodsCatRepository;

    @PostMapping(name = "添加商品类别", path = "/goods_cat/add")
    public Response add(@Valid @RequestBody GoodsCat goodsCat) {
        if (goodsCatRepository.findByName(goodsCat.getName()).isPresent()) {
            return new Response(10001, "商品名已存在");
        }
        goodsCatRepository.save(goodsCat);
        return new Response(ResponseCode.success, "插入成功");
    }

}
