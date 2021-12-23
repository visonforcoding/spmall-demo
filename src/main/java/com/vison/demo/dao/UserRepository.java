package com.vison.demo.dao;

import com.vison.demo.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    Optional<User> findByName(String name);

}
