package com.vison.demo.controller;

import com.vison.demo.Response;
import com.vison.demo.ResponseCode;
import com.vison.demo.dao.GoodsRepository;
import com.vison.demo.dao.OrderRepository;
import com.vison.demo.entity.Goods;
import com.vison.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping(path = "/order/create", name = "订单创建", method = RequestMethod.POST)
    public Response createOrder(@Valid @RequestBody Order order) {
        order.setOrderNo(String.format("%d", new Date().getTime()));
        order.setUid(3L);
        Set<Goods> orderGoods = new HashSet<>();
        for (Goods g : order.getGoods()) {
            Optional<Goods> goods = goodsRepository.findById(g.getId());
            goods.ifPresent(orderGoods::add);
        }
        order.setGoods(orderGoods);
        orderRepository.save(order);
        return new Response(ResponseCode.success, "创建成功", order);
    }
}
