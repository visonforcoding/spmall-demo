package com.vison.demo.controller;

import com.vison.demo.Response;
import com.vison.demo.ResponseCode;
import com.vison.demo.dao.GoodsCatRepository;
import com.vison.demo.dao.GoodsRepository;
import com.vison.demo.entity.Goods;
import com.vison.demo.entity.GoodsCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class GoodsController {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsCatRepository goodsCatRepository;

    @PostMapping(name = "添加商品", path = "/goods/add")
    public Response add(@Valid @RequestBody Goods goods) {
        if (goodsRepository.findByName(goods.getName()).isPresent()) {
            return new Response(10001, "商品名已存在");
        }
        if (goodsCatRepository.findById(goods.getGoodsCatId()).isEmpty()) {
            return new Response(10002, "商品类别不存在");
        }
        Goods saveGoods = goodsRepository.save(goods);
        return new Response(ResponseCode.success, "插入成功", saveGoods);
    }

    @GetMapping(name = "商品详情", path = "/goods/{id}")
    public Response detail(@PathVariable Long id) {
        Optional<Goods> goods = goodsRepository.findById(id);
        if (goods.isPresent()) {
            Optional<GoodsCat> goodsCat = goodsCatRepository.findById(goods.get().getGoodsCatId());
            goodsCat.ifPresent(cat -> goods.get().setGoodsCat(cat));
            return new Response(ResponseCode.success, "获取成功", goods.get());
        }
        return new Response(ResponseCode.noDataFound, "获取失败");
    }
}
