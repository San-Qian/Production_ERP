package com.nosuchteam.controller;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.service.CustomService;
import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.Method;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    @Qualifier("customService")
    CustomService customService;

    @RequestMapping("/{name}")
    public String forward(@PathVariable String name, HttpSession session) {
        if ("find".equals(name)) {
            ArrayList<String> sysPermissionList = new ArrayList<>();
            sysPermissionList.add("custom:add");
            sysPermissionList.add("custom:edit");
            sysPermissionList.add("custom:delete");
            session.setAttribute("sysPermissionList", sysPermissionList);
            name = "list";
        }
        return "plan_scheduling/custom_" + name;
    }

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_custom_by_customId"
            , "/search_custom_by_customName"})
    public Object list(Custom custom, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            String methodName = "set" + (requestURI.endsWith("customId") ? "CustomId" : "CustomName");
            Method method = Custom.class.getMethod(methodName, String.class);
            method.invoke(custom, searchValue);
        }
        PageInfo pager = customService.selectByPage(custom, page, rows);
        getData = getData == null ? "" : getData;
        switch (getData) {
            case "List":
                return pager.getRows();
            case "Object":
                return pager.getRows().get(0);
            default:
                return pager;
        }
    }


    @ResponseBody
    @RequestMapping({"/insert"})
    public Data add(@Valid Custom custom, BindingResult bindingResult) {
            try {
                if(bindingResult.hasErrors()){
                    return new Data(500,bindingResult.getAllErrors().get(0).getDefaultMessage(),null) ;
                }
                customService.save(custom);

                return new Data(200, "OK", null);

            }catch (DuplicateKeyException de){
                de.printStackTrace();
                return new Data(500, "该编号已存在", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
    }

    @ResponseBody
    @RequestMapping(path = { "/update_all", "/update_note"})
    public Data edit(@Valid Custom custom, BindingResult bindingResult, HttpServletRequest request) {
            try {
                if(bindingResult.hasErrors()){
                    if(bindingResult.hasFieldErrors("customId") || request.getRequestURI().endsWith("/update_all")){
                        return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
                    }
                }
                customService.updateSelective(custom);
                return new Data(200, "OK", null);
            }  catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
    }

    @ResponseBody
    @RequestMapping({"/delete","/delete_batch"})
    public Data delete(String[] ids, HttpServletRequest request) {

            try {
                customService.delete(ids);
                return new Data(200, "OK", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Data(500, "操作失败", null);
            }
    }

    @ResponseBody
    @RequestMapping({"/check"})
    public Object checkStatus(String customId){
        try{
            Custom custom = customService.selectById(customId);
            if(custom.getStatus() == 2){
                return new Data(400, "警告！客户“" + custom.getCustomName() + "”为无效客户",null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
