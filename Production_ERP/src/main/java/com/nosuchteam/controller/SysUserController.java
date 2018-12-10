package com.nosuchteam.controller;

import com.nosuchteam.bean.SysUser;
import com.nosuchteam.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysUserController {
    @Autowired
    SysUserService service;
    @RequestMapping("ajaxLogin")
    public String login(SysUser sysUser,Model model){
        SysUser login = service.login(sysUser);
        model.addAttribute("activeUser",login);

        return "home";
    }
}
