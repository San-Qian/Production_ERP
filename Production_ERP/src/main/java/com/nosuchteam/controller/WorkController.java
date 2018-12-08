package com.nosuchteam.controller;

import com.nosuchteam.bean.Device;
import com.nosuchteam.bean.Product;
import com.nosuchteam.bean.Work;
import com.nosuchteam.service.WorkService;
import com.nosuchteam.util.commons.Data;
import com.nosuchteam.util.commons.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Evan
 * @Date: 2018/12/5 15:56
 * @Description:
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    @Qualifier("workService")
    WorkService workService;

    @ResponseBody
    @RequestMapping(path = {"/list"
            , "/search_work_by_workId"
            , "/search_work_by_workProduct"
            , "/search_work_by_workProcess"
            , "/search_work_by_workDevice"})
    public Object list(Work work, Integer page, HttpServletRequest request, String getData,
                       String searchValue, Integer rows) throws Exception {
        String requestURI = request.getRequestURI();
        if (searchValue != null && !searchValue.isEmpty()) {
            switch (requestURI.substring(requestURI.lastIndexOf("work") + "work".length())) {
                case "Id":
                    work.setWorkId(searchValue);
                    break;
                case "Product":
                    Product product = new Product();
                    product.setProductName(searchValue);
                    work.setProduct(product);
                    break;
                case "Process":
                    work.setProcessId(searchValue);
                    break;
                case "Device":
                    Device device = new Device();
                    device.setDeviceName(searchValue);
                    work.setDevice(device);
                    break;
            }
        }
        PageInfo pager = workService.selectByPage(work, page, rows);
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
    public Data add(@Valid Work work, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
            }
            workService.save(work);
            return new Data(200, "OK", null);
        } catch (DuplicateKeyException de) {
            de.printStackTrace();
            return new Data(500, "该编号已存在", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }
    }

    @ResponseBody
    @RequestMapping(path = {"/update_all", "/update_note"})
    public Data edit(@Valid Work work, BindingResult bindingResult, HttpServletRequest request) {
        try {
            if (bindingResult.hasErrors()) {
                if (bindingResult.hasFieldErrors("wordId") || request.getRequestURI().endsWith("/update_all")) {
                    return new Data(500, bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
                }
            }
            workService.update(work);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }
    }

    @ResponseBody
    @RequestMapping({"/delete", "/delete_batch"})
    public Data delete(String[] ids) {
        try {
            workService.delete(ids);
            return new Data(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Data(500, "操作失败", null);
        }

    }

}
