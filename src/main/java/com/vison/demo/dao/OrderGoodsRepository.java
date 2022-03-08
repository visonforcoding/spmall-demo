package com.vison.demo.dao;

import com.vison.demo.entity.OrderGoods;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderGoodsRepository extends PagingAndSortingRepository<OrderGoods, Long> {

}
