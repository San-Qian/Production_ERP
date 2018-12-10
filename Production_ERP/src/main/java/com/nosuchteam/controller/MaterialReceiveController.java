package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Material;
import com.nosuchteam.bean.MaterialReceive;
import com.nosuchteam.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/materialReceive")
@Controller
public class MaterialReceiveController {

    @Autowired
    MaterialReceiveService receiveService;

    //三个按钮
    @RequestMapping("/find")
    public String find(HttpSession session) {
        ArrayList<String> func = new ArrayList();
        func.add("materialReceive:add");
        func.add("materialReceive:edit");
        func.add("materialReceive:delete");

        session.setAttribute("sysPermissionList", func);
        return "meterial_monitoring/materialReceive_list";
    }

    //显示所有MaterialReceive订单
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(Integer page,Integer rows) {
        PageInfo<MaterialReceive> pageInfo = receiveService.findAllMaterialReceive(page,rows);

        Map<String, Object> info = new HashMap<>();
        info.put("total", pageInfo.getTotal());
        info.put("rows", pageInfo.getList());

        return info;
    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public HashMap<String, Object> add() {
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("msg", null);
        return null;
    }

    @RequestMapping("/add")
    public String addWindow() {
        return "meterial_monitoring/materialReceive_add";
    }

    //新增
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(@Valid MaterialReceive materialReceive, BindingResult result) {

        Map<String, Object> info = new HashMap<>();
        if (result.hasFieldErrors()) {
            //验证错误
            List<ObjectError> allErrors = result.getAllErrors();
            info.put("status", 100);

            for (ObjectError error : allErrors) {
                String defaultMessage = error.getDefaultMessage();
                info.put("msg", defaultMessage);
            }
            return info;
        } else {
            boolean ret = receiveService.insert(materialReceive);
            if (ret) {
                info.put("status", 200);
            }
            return info;
        }
    }

    @ResponseBody
    @RequestMapping("/edit_judge")
    public HashMap<String, Object> edit() {
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("msg", null);
        return null;
    }

    @RequestMapping("/edit")
    public String editWindow() {
        return "meterial_monitoring/materialReceive_edit";
    }

    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map<String, Object> update(String receiveId, String note) {

        Map<String, Object> info = new HashMap<>();

        boolean ret = receiveService.updateNote(receiveId, note);

        if (ret) {
            info.put("status", 200);
            info.put("msg", "OK");
        }
        return info;

    }

    //修改
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update(@Valid MaterialReceive materialReceive, BindingResult result) {

        Map<String, Object> info = new HashMap<>();
        if (result.hasFieldErrors()) {
            //验证错误
            List<ObjectError> allErrors = result.getAllErrors();
            info.put("status", 100);

            for (ObjectError error : allErrors) {
                String defaultMessage = error.getDefaultMessage();
                info.put("msg", defaultMessage);
            }
            return info;
        } else {
            //需要对剩余数量同时进行修改
            boolean ret = receiveService.update(materialReceive);
            if (ret) {
                info.put("status", 200);
            }
            return info;
        }
    }

    //删除
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete() {
        Map<String, Object> info = new HashMap<>();

        info.put("msg", null);
        return info;
    }

    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> deleteMulti(String[] ids) {
        int length = ids.length;
        int times = 0;

        for (String id : ids) {
            boolean b = receiveService.delectById(id);
            if (b) {
                times++;
            }
        }
        if (length == times) {
            Map<String, Object> info = new HashMap<>();
            info.put("status", 200);
            info.put("msg", "OK");
            return info;
        }
        return null;
    }

    //搜索
    @ResponseBody
    @RequestMapping(value = "/{formName}")
    public Map<String, Object> search(@PathVariable String formName, String searchValue,Integer page,Integer rows) {
        Map<String, Object> info = new HashMap<>();

        //物料收入编号
        if (formName.contains("receiveId")) {
            PageInfo<MaterialReceive> pageInfo = receiveService.searchByReceiveId(searchValue,page,rows);

            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            return info;

        }

        //物料编号
        if (formName.contains("materialId")) {
            PageInfo<MaterialReceive> pageInfo = receiveService.serachByMaterialId(searchValue,page,rows);

            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            return info;
        }
        return null;
    }
}
