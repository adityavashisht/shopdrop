package com.indasil.shopdrop.web.feature.item.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vashishta on 10/12/15.
 */
@Controller
@RequestMapping(value="/restItem")
public class ItemEntryController {

    @RequestMapping(method = RequestMethod.GET, value="show")
    public String show() {
        return "rest/list";
    }
}
