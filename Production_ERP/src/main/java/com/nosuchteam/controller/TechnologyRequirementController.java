package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Technology;
import com.nosuchteam.bean.TechnologyRequirement;
import com.nosuchteam.service.TechnologyRequirementService;
import com.nosuchteam.service.TechnologyService;
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
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;


    @RequestMapping("/find")
    public String technologyRequirementFind(HttpSession session) {
        ArrayList<Object> arrayList = new ArrayList<>();

        arrayList.add("technologyRequirement:add");
        arrayList.add("technologyRequirement:edit");
        arrayList.add("technologyRequirement:delete");

        session.setAttribute("sysPermissionList", arrayList);
        return "technology_manage/technologyRequirement_list";
    }

    @ResponseBody
    @RequestMapping({"/add_judge", "/delete_judge", "/edit_judge"})

    public Map technologyRequirementJudge() {

        HashMap<Object, Object> hashMap = new HashMap<>();
        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map technologyRequirementList(String page, String rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        PageInfo<TechnologyRequirement> pageInfo = technologyRequirementService.selectByPage(page, rows);

        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }
        return hashMap;
    }

    @RequestMapping("/add")
    public String technologyRequirementAdd() {

        return "technology_manage/technologyRequirement_add";
    }

    @RequestMapping("/edit")
    public String technologyRequirementEdit() {

        return "technology_manage/technologyRequirement_edit";
    }


    @ResponseBody
    @RequestMapping("/get/{id}")
    public TechnologyRequirement getTechnologyRequirement(@PathVariable String id) {


        TechnologyRequirement technologyRequirement = technologyRequirementService.selectById(id);

        return technologyRequirement;
    }

    @ResponseBody
    @RequestMapping("/get_data")

    public List<TechnologyRequirement> getData() {

        List<TechnologyRequirement> list = technologyRequirementService.select();

        return list;

    }


    @ResponseBody
    @RequestMapping("/insert")
    public Map technologyRequirementInsert(TechnologyRequirement technologyRequirement) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        try {
            technologyRequirementService.insert(technologyRequirement);

            hashMap.put("status", 200);

        } catch (DuplicateKeyException e) {
            hashMap.put("msg", "已经存在的工艺要求编号");
        } catch (Exception e) {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;

    }

    @ResponseBody
    @RequestMapping({"/update_all", "/update_requirement"})
    public Map technologyRequirementUpdateAll(TechnologyRequirement technologyRequirement) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        boolean result = technologyRequirementService.update(technologyRequirement);
        if (result) {
            hashMap.put("status", 200);
        } else {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;

    }


    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map technologyRequirementDelete(String[] ids) {

        int length = ids.length;
        int times = 0;
        HashMap<Object, Object> hashMap = new HashMap<>();

        for (String id : ids) {
            boolean result = technologyRequirementService.deleteTechnologyRequirementById(id);
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
    public Map searchTechnologyRequirement(@PathVariable String name, String searchValue, String page, String rows) {


        HashMap<Object, Object> hashMap = new HashMap<>();

        PageInfo<TechnologyRequirement> pageInfo = technologyRequirementService.selectByAmbiguous(name, searchValue, page, rows);

        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }
        return hashMap;
    }

}
