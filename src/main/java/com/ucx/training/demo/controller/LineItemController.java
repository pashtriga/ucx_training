package com.ucx.training.demo.controller;

import com.ucx.training.demo.entity.LineItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shop/lineItem")
public class LineItemController extends BaseController<LineItem, Integer> {

}
