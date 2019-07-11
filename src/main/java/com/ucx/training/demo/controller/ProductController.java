package com.ucx.training.demo.controller;

import com.ucx.training.demo.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shop/product")
public class ProductController extends BaseController<Product, Integer> {
}
