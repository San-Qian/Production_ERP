package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Technology;
import com.nosuchteam.service.TechnologyService;
import org.mybatis.generator.codegen.mybatis3.model.PrimaryKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;


    @RequestMapping("/find")
    public String technologyFind(HttpSession session) {


        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("technology:add");
        arrayList.add("technology:edit");
        arrayList.add("technology:delete");

        session.setAttribute("sysPermissionList", arrayList);
        return "technology_manage/technology_list";
    }


    @ResponseBody
    @RequestMapping({"/add_judge", "/delete_judge", "/edit_judge"})
    public Map techenologyAddJudge() {

        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }


    @ResponseBody
    @RequestMapping("/list")
    public Map technologyList(String page, String rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        PageInfo<Technology> pageInfo = technologyService.selectByPage(page, rows);
        long total = pageInfo.getTotal();
        List<Technology> list = pageInfo.getList();

        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public Technology getTechnology(@PathVariable String id) {


        Technology technology = technologyService.selectById(id);

        return technology;
    }

    @ResponseBody
    @RequestMapping("/get_data")

    public List<Technology> getData() {

        List<Technology> list = technologyService.select();

        return list;

    }

    @RequestMapping("/add")
    public String technologyAdd() {
        return "technology_manage/technology_add";
    }

    @RequestMapping("/edit")
    public String technologyEdit() {

        return "technology_manage/technology_edit";
    }


    @ResponseBody
    @RequestMapping("/insert")
    public Map technologyInsert(Technology technology) {

        HashMap<Object, Object> hashMap = new HashMap<>();
        try {
            technologyService.insert(technology);

            hashMap.put("status", 200);

        } catch (DuplicateKeyException e) {
            hashMap.put("msg", "已经存在的工艺编号");
        } catch (Exception e) {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/update_all")
    public Map technologyUpdateAll(Technology technology) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        try {

            technologyService.update(technology);
            hashMap.put("status", 200);
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        hashMap.put("msg", "操作失败，请重试");
        return hashMap;

    }


    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map technologyDelete(String[] ids) {

        int length = ids.length;
        int times = 0;
        HashMap<Object, Object> hashMap = new HashMap<>();

        for (String id : ids) {
            boolean result = technologyService.deleteTechnologyById(id);
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
    public Map searchTechnology(@PathVariable String name, String searchValue, String page, String rows) {


        HashMap<Object, Object> hashMap = new HashMap<>();

        PageInfo<Technology> pageInfo = technologyService.selectByAmbiguous(name, searchValue, page, rows);

        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }

        return hashMap;
    }
}
