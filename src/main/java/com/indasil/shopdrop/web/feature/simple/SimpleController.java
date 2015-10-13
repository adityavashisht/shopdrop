package com.indasil.shopdrop.web.feature.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vashishta on 10/13/15.
 */
@Controller
@RequestMapping("/simple")
public class SimpleController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "simple";
    }
}
