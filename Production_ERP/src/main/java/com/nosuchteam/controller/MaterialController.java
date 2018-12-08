package com.nosuchteam.controller;


import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.Material;
import com.nosuchteam.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/material")
@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    //三个按钮
    @RequestMapping("/find")
    public String find(HttpSession session) {
        ArrayList<String> func = new ArrayList();
        func.add("material:add");
        func.add("material:edit");
        func.add("material:delete");

        session.setAttribute("sysPermissionList", func);
        return "meterial_monitoring/material_list";
    }

    //显示所有Material
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(Integer page,Integer rows) {
        PageInfo<Material> materials = materialService.findAllMaterial(page, rows);

        Map<String, Object> info = new HashMap<>();

        info.put("total", materials.getTotal());
        info.put("rows", materials.getList());

        return info;

    }

    //显示add.jsp
    @ResponseBody
    @RequestMapping("/add_judge")
    public HashMap<String,Object> add() {
        HashMap<String,Object> ret = new HashMap<>();
        ret.put("msg",null);
        return null;
    }

    @RequestMapping("/add")
    public String addWindow() {
        return "meterial_monitoring/material_add";
    }

    //新增
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(@Valid Material material, BindingResult result) {

        //新增时数据库也要进行相应的变化
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
            boolean ret = materialService.insert(material);
            if (ret) {
                info.put("status", 200);
            }
            return info;
        }
    }

    //edit.jsp
    @ResponseBody
    @RequestMapping("/edit_judge")
    public HashMap<String,Object> edit() {
        HashMap<String,Object> ret = new HashMap<>();
        ret.put("msg",null);
        return null;
    }

    @RequestMapping("/edit")
    public String editWindow() {
        return "meterial_monitoring/material_edit";
    }

    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map<String, Object> update(String materialId, String note) {

        Map<String, Object> info = new HashMap<>();

        boolean ret = materialService.updateNote(materialId, note);

        if (ret) {
            info.put("status", 200);
            info.put("msg", "OK");
        }
        return info;

    }

    //修改
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update(@Valid Material material, BindingResult result) {

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
            boolean ret = materialService.update(material);
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
            boolean b = materialService.delectById(id);
            if (b) {
                times++;
            }
        }
        if (length == times) {
            Map<String, Object> info = new HashMap<>();
            info.put("status", 200);
            info.put("msg","OK");
            return info;
        }
        return null;
    }

    //搜索
    @ResponseBody
    @RequestMapping(value="/{formName}")
    public Map<String, Object> search(@PathVariable String formName, String searchValue,Integer page,Integer rows) {
        Map<String, Object> info = new HashMap<>();
        //物料编号
        if (formName.endsWith("materialId")){

            PageInfo<Material> pageInfo = materialService.serachMaterialsById(searchValue, page, rows);
            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            return info;
        }

        if (formName.contains("materialType")){
            PageInfo<Material> pageInfo = materialService.searchByType(searchValue, page, rows);
            info.put("total", pageInfo.getTotal());
            info.put("rows",pageInfo.getList());
            return info;

        }
        return null;
    }

    //新增时传递所有物料编号和信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Material> getMaterialsId() {
        List<Material> materials = materialService.findAllMaterial();

        return  materials;
    }

    //打开物料信息对话框
    @ResponseBody
    @RequestMapping(value = "/get/{materialId}")
    public Material getMaterial(@PathVariable String materialId) {
        Material material = materialService.serachById(materialId);
        return material;
    }
}
