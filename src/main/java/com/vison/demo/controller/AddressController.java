package com.vison.demo.controller;

import com.vison.demo.Response;
import com.vison.demo.ResponseCode;
import com.vison.demo.dao.AddressRepository;
import com.vison.demo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @PostMapping(name = "添加地址", path = "/address/add")
    public Response add(@Valid @RequestBody Address address) {
        Address saveAddress = addressRepository.save(address);
        return new Response(ResponseCode.success, "插入成功", saveAddress);
    }
}
