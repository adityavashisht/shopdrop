package com.indasil.shopdrop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vashishta on 10/8/15.
 */
@Controller
@RequestMapping("/app/order")
public class OrderController {


    @RequestMapping(method = RequestMethod.GET)
    public String show() {
        return "order/show";
    }

}
