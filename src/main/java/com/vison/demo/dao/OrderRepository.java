package com.vison.demo.dao;

import com.vison.demo.entity.Address;
import com.vison.demo.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
