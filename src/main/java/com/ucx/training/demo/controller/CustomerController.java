package com.ucx.training.demo.controller;

import com.ucx.training.demo.entity.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shop/customer")
public class CustomerController extends BaseController<Customer, Integer> {
}
