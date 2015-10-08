package com.indasil.shopdrop.web.controller;


import com.indasil.shopdrop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vashishta on 10/8/15.
 */
@Controller
public class OrderController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("name", "hussein");
        model.addAttribute("products", itemService.getAllItems());
        return "order/show";
    }

}
