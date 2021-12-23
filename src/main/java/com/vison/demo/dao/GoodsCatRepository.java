package com.vison.demo.dao;

import com.vison.demo.entity.GoodsCat;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface GoodsCatRepository extends PagingAndSortingRepository<GoodsCat, Long> {
    Optional<GoodsCat> findByName(String name);
}
