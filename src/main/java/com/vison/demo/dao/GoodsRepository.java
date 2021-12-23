package com.vison.demo.dao;

import com.vison.demo.entity.Goods;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface GoodsRepository extends PagingAndSortingRepository<Goods, Long> {
    Optional<Goods> findByName(String name);
}
