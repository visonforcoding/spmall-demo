package com.vison.demo.controller;

import com.vison.demo.Response;
import com.vison.demo.ResponseCode;
import com.vison.demo.dao.GoodsRepository;
import com.vison.demo.dao.OrderGoodsRepository;
import com.vison.demo.dao.OrderRepository;
import com.vison.demo.entity.Goods;
import com.vison.demo.entity.Order;
import com.vison.demo.entity.OrderGoods;
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

    @Autowired
    OrderGoodsRepository orderGoodsRepository;

    @RequestMapping(path = "/order/create", name = "订单创建", method = RequestMethod.POST)
    public Response createOrder(@Valid @RequestBody Order order) {
        order.setOrderNo(String.format("%d", new Date().getTime()));
        order.setUid(3L);
        orderRepository.save(order);
        Set<OrderGoods> orderGoods = new HashSet<>();
        for (OrderGoods g : order.getOrderGoods()) {
            Optional<Goods> goods = goodsRepository.findById(g.getGoods().getId());
            goods.ifPresent(g::setGoods);
            g.setOrder(order);
            orderGoodsRepository.save(g);
            orderGoods.add(g);
        }
        order.setOrderGoods(orderGoods);
        return new Response(ResponseCode.success, "创建成功", order);
    }
}
