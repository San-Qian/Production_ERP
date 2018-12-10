package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.UnqualifyApply;
import com.nosuchteam.bean.vo.UnqualifyApplyVo;
import com.nosuchteam.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2018/12/7-11:40
 */

@Controller
@RequestMapping("/unqualify")
public class UnqualifyController {

    @Autowired
    UnqualifyService unqualifyService;

    @RequestMapping("/find")
    public String forward(HttpSession session) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("unqualify:add");
        arrayList.add("unqualify:edit");
        arrayList.add("unqualify:delete");

        session.setAttribute("sysPermissionList", arrayList);

        return "quality_monitoring/unqualify_list";
    }

    @RequestMapping({"/add_judge","/edit_judge","delete_judge"})
    @ResponseBody
    public Map show() {
        //HashMap hashMap = new HashMap();

        return null;
    }

    //显示所有不合格产品
    @ResponseBody
    @RequestMapping("/list")
    public Map listUnqualify(int page, int rows) {

        PageInfo<UnqualifyApplyVo> unqualifyApplys = unqualifyService.findUnqualifyApplys(page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", unqualifyApplys.getSize());
        map.put("rows", unqualifyApplys.getList());

        return map;
    }

    //显示不合格页面
    @RequestMapping("/add")
    public String show3(){

        return "quality_monitoring/unqualify_add";

    }

    //显示编辑页面
    @RequestMapping("/edit")
    public String show4(){
        return "quality_monitoring/unqualify_edit";
    }


    //新增一个不合格产品
    @ResponseBody
    @RequestMapping("/insert")
    public Map insertUnqualifyApply(UnqualifyApply unqualifyApply){

        int i = unqualifyService.addUnqualifyApply(unqualifyApply);

        HashMap hashMap = new HashMap();

        hashMap.put("data",null);
        hashMap.put("msg","OK");
        hashMap.put("status",200);

        if(i!=1){
            return null;
        }

        return hashMap;
    }

    //编辑不合格产品
    @ResponseBody
    @RequestMapping("/update_all")
    public Map updateUnqualifyApply(UnqualifyApply unqualifyApply){

        int i = unqualifyService.editUnqualifyApply(unqualifyApply);

        HashMap hashMap = new HashMap();

        hashMap.put("data",null);
        hashMap.put("msg","OK");
        hashMap.put("status",200);

        if(i!=1){
            return null;
        }

        return hashMap;
    }


    //删除不合格产品
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map deleteUnqualifyApplys(String ids){

        int i = 0;

        String[] split = ids.split(",");

        for(String toDelete:split){
            i = unqualifyService.deleteUnqualifyApply(toDelete);
            if(i!=1){
                break;
            }
        }

        HashMap hashMap = new HashMap();

        hashMap.put("data",null);
        hashMap.put("msg","OK");
        hashMap.put("status",200);

        if(i!=1){
            return null;
        }

        return hashMap;
    }

    //搜索功能
    @ResponseBody
    @RequestMapping("/{name}")
    public Map searchUnqualifyApplies(@PathVariable String name, String searchValue, int page, int rows){

        PageInfo<UnqualifyApplyVo> unqualifyApplyById = unqualifyService.findUnqualifyApplyById (name,searchValue, page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", unqualifyApplyById.getSize());
        map.put("rows", unqualifyApplyById.getList());

        return map;
    }


    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateNote(String unqualifyApplyId,String note){

        UnqualifyApply unqualifyApply = new UnqualifyApply();
        unqualifyApply.setUnqualifyApplyId(unqualifyApplyId);
        unqualifyApply.setNote(note);

        int i = unqualifyService.updateNote(unqualifyApply);

        HashMap hashMap = new HashMap();

        hashMap.put("data",null);
        hashMap.put("msg","OK");
        hashMap.put("status",200);

        if(i!=1){
            hashMap.put("msg","修改失败");
            return hashMap;
        }

        return hashMap;
    }
}
