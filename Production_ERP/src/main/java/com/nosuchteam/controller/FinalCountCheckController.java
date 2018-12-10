package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.FinalCountCheck;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.bean.vo.FinalCountCheckVo;
import com.nosuchteam.mapper.FinalCountCheckMapper;
import com.nosuchteam.service.FinalCountCheckService;
import com.nosuchteam.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018/12/8-10:52
 */
@RequestMapping("/f_count_check")
@Controller
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;

    @RequestMapping("/find")
    public String forward(HttpSession session) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("fCountCheck:add");
        arrayList.add("fCountCheck:edit");
        arrayList.add("fCountCheck:delete");

        session.setAttribute("sysPermissionList", arrayList);

        return "quality_monitoring/f_count_check_list";
    }


    @RequestMapping({"/add_judge","/edit_judge","delete_judge"})
    @ResponseBody
    public Map show() {
        //HashMap hashMap = new HashMap();

        return null;
    }


    //显示所有成品计数质检
    @ResponseBody
    @RequestMapping("/list")
    public Map listfCountCheck(int rows,int page){
        PageInfo<FinalCountCheckVo> allFinalCountCheck = finalCountCheckService.findAllFinalCountCheckByPage(page,rows);

        HashMap<Object, Object> map = new HashMap();

        map.put("total",allFinalCountCheck.getSize());
        map.put("rows",allFinalCountCheck.getList());

        return map;
    }

    //显示增加页面
    @RequestMapping("/add")
    public String show3(){

        return "quality_monitoring/f_count_check_add";

    }

    //显示编辑页面
    @RequestMapping("/edit")
    public String show4(){
        return "quality_monitoring/f_count_check_edit";
    }


    //新增一个成品计量
    @ResponseBody
    @RequestMapping("/insert")
    public Map insertFinalCountCheck(FinalCountCheck finalCountCheck){

        int i = finalCountCheckService.addFinalCountCheck(finalCountCheck);

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
    public Map updateFinalCountCheck(FinalCountCheck finalCountCheck){

        int i = finalCountCheckService.editFinalCountCheck(finalCountCheck);

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
    public Map deleteFinalCountChecks(String ids){

        int i = 0;

        String[] split = ids.split(",");

        for(String toDelete:split){
            i = finalCountCheckService.deleteFinalCountCheck(toDelete);
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

        PageInfo<FinalCountCheckVo> FinalCountCheckById = finalCountCheckService.findFinalCountCheck (name,searchValue, page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", FinalCountCheckById.getSize());
        map.put("rows", FinalCountCheckById.getList());

        return map;
    }


    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateNote(String fCountCheckId,String note){

        FinalCountCheck finalCountCheck = new FinalCountCheck();
        finalCountCheck.setfCountCheckId(fCountCheckId);
        finalCountCheck.setNote(note);

        int i = finalCountCheckService.updateNote(finalCountCheck);

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
