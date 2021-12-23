package com.vison.demo.dao;

import com.vison.demo.entity.Address;
import com.vison.demo.entity.GoodsCat;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
