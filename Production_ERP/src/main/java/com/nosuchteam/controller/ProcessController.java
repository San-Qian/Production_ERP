package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Process;
import com.nosuchteam.service.ProcessService;
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
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping("/find")
    public String processFind(HttpSession session) {

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("process:add");
        arrayList.add("process:edit");
        arrayList.add("process:delete");

        session.setAttribute("sysPermissionList", arrayList);
        return "technology_manage/process_list";
    }

    @ResponseBody
    @RequestMapping({"/add_judge", "/delete_judge", "/edit_judge"})

    public Map technologyRequirementJudge() {

        HashMap<Object, Object> hashMap = new HashMap<>();
        return hashMap;
    }

    @RequestMapping("/add")
    public String technologyAdd() {
        return "technology_manage/process_add";
    }

    @RequestMapping("/edit")
    public String technologyEdit() {

        return "technology_manage/process_edit";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map processList(String page, String rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        PageInfo<Process> pageInfo = processService.selectByPage(page, rows);
        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }
        return hashMap;
    }


    @ResponseBody
    @RequestMapping("/get/{id}")
    public Process getTechnology(@PathVariable String id) {


        Process process = processService.selectById(id);

        return process;
    }

    @ResponseBody
    @RequestMapping("/get_data")

    public List<Process> getData() {

        List<Process> list = processService.select();

        return list;

    }


    @ResponseBody
    @RequestMapping("/insert")
    public Map processInsert(Process process) {

        HashMap<Object, Object> hashMap = new HashMap<>();
        try {
            processService.insert(process);

            hashMap.put("status", 200);

        } catch (DuplicateKeyException e) {
            hashMap.put("msg", "已经存在的工序编号");
        } catch (Exception e) {
            hashMap.put("msg", "操作失败，请重试");
        }
        return hashMap;

    }

    @ResponseBody
    @RequestMapping("/update_all")
    public Map processUpdateAll(Process process) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        boolean result = processService.update(process);
        if (result) {
            hashMap.put("status", 200);
        } else {
            hashMap.put("msg", "操作失败，请重试");
        }

        return hashMap;

    }


    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map processDelete(String[] ids) {

        int length = ids.length;
        int times = 0;
        HashMap<Object, Object> hashMap = new HashMap<>();

        for (String id : ids) {
            boolean result = processService.deleteTechnologyById(id);
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
    public Map searchProcess(@PathVariable String name, String searchValue, String page, String rows) {


        HashMap<Object, Object> hashMap = new HashMap<>();

        PageInfo<Process> pageInfo = processService.selectByAmbiguous(name, searchValue, page, rows);

        if (pageInfo != null) {
            hashMap.put("total", pageInfo.getTotal());
            hashMap.put("rows", pageInfo.getList());
        }
        return hashMap;
    }

}
