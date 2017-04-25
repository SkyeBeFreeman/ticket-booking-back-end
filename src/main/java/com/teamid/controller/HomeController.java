package com.teamid.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Skye on 2017/4/21.
 */
@RestController
public class HomeController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}
