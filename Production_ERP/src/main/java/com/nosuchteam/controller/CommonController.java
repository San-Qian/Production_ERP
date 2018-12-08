package com.nosuchteam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {


    @RequestMapping("/{name}")
    public String forward(@PathVariable String name) {
        return name;
    }
}
