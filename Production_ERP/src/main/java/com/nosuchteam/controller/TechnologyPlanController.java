package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.TechnologyPlan;
import com.nosuchteam.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public String technologyPlanFind(HttpSession session) {

        ArrayList<Object> arrayList = new ArrayList<>();

        arrayList.add("technologyPlan:add");
        arrayList.add("technologyPlan:edit");
        arrayList.add("technologyPlan:delete");

        session.setAttribute("sysPermissionList", arrayList);
        return "technology_manage/technologyPlan_list";
    }

    @ResponseBody
    @RequestMapping({"/add_judge", "/delete_judge", "/edit_judge"})

    public Map technologyPlanJudge() {

        HashMap<Object, Object> hashMap = new HashMap<>();
        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map technologyPlanList(String page, String rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        PageInfo<TechnologyPlan> pageInfo = technologyPlanService.selectByPage(page, rows);

        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }
        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public TechnologyPlan getTechnology(@PathVariable String id) {


        TechnologyPlan technologyPlan = technologyPlanService.selectById(id);

        return technologyPlan;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<TechnologyPlan> getData() {
        List<TechnologyPlan> list = technologyPlanService.select();

        return list;
    }

    @RequestMapping("/add")
    public String technologyPlanAdd() {
        return "technology_manage/technologyPlan_add";
    }

    @RequestMapping("/edit")
    public String technologyPlanEdit() {

        return "technology_manage/technologyPlan_edit";
    }


    @ResponseBody
    @RequestMapping("/insert")
    public Map technologyPlanInsert(TechnologyPlan technologyPlan) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        try {
            technologyPlanService.insert(technologyPlan);

            hashMap.put("status", 200);

        } catch (DuplicateKeyException e) {
            hashMap.put("msg", "已经存在的工艺计划编号");
        } catch (Exception e) {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;

    }

    @ResponseBody
    @RequestMapping("/update_all")
    public Map technologyPlanUpdateAll(TechnologyPlan technologyPlan) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        boolean result = technologyPlanService.update(technologyPlan);
        if (result) {
            hashMap.put("status", 200);
        } else {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;

    }


    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map technologyPlanDelete(String[] ids) {

        int length = ids.length;
        int times = 0;
        HashMap<Object, Object> hashMap = new HashMap<>();

        for (String id : ids) {
            boolean result = technologyPlanService.deleteTechnologyById(id);
            if (result) {
                times++;
            }
        }

        if (times == length) {
            hashMap.put("status", 200);
        } else {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping("/{name}")
    public Map searchTechnologyPlan(@PathVariable String name, String searchValue, String page, String rows) {


        HashMap<Object, Object> hashMap = new HashMap<>();

        PageInfo<TechnologyPlan> pageInfo = technologyPlanService.selectByAmbiguous(name, searchValue, page, rows);

        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }
        return hashMap;

    }


}
