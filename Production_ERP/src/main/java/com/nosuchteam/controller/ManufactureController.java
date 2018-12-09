package com.nosuchteam.controller;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.Technology;
import com.nosuchteam.service.ManufactureService;
import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    @Qualifier("manufactureService")
    ManufactureService manufactureService;

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_manufacture_by_manufactureSn"
            , "/search_manufacture_by_manufactureOrderId"
            , "/search_manufacture_by_manufactureTechnologyName"})
    public Object list(Manufacture manufacture, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("manufacture") + "manufacture".length())) {
                case "Sn":
                    manufacture.setManufactureSn(searchValue);
                    break;
                case "OrderId":
                    Order order = new Order();
                    order.setOrderId(searchValue);
                    manufacture.setcOrder(order);
                    break;
                case "TechnologyName":
                    Technology technology = new Technology();
                    technology.setTechnologyName(searchValue);
                    manufacture.setTechnology(technology);
                    break;
            }
        }
        PageInfo pager = manufactureService.selectByPage(manufacture, page, rows);
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
    public Data add(@Valid Manufacture manufacture, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
            }
            manufactureService.save(manufacture);
            return new Data(200, "OK", null);
        } catch (DuplicateKeyException de) {
            de.printStackTrace();
            return new Data(500, "该编号已存在", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data(500, "操作失败", null);
    }

    @ResponseBody
    @RequestMapping(path = {"/update_all", "/update_note"})
    public Data edit(@Valid Manufacture manufacture, BindingResult bindingResult, HttpServletRequest request) {
        try {
            if(bindingResult.hasErrors()){
                if(bindingResult.hasFieldErrors("manufactureSn") || request.getRequestURI().endsWith("/update_all")){
                    return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
                }
            }
            manufactureService.update(manufacture);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data(500, "操作失败", null);
    }

    @ResponseBody
    @RequestMapping({"/delete", "/delete_batch"})
    public Data delete(@NotNull String[] ids) {
        try {
            manufactureService.delete(ids);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Data(500, "操作失败", null);
    }
}
