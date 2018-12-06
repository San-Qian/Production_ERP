package com.nosuchteam.controller;

import com.nosuchteam.service.UserService;
import com.nosuchteam.service.iml.UserServiceiml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService service;

}
