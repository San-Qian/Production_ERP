package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.ProcessCountCheck;
import com.nosuchteam.bean.vo.ProcessCountCheckVo;
import com.nosuchteam.service.ProcessCountCheckService;
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
 * @date 2018/12/8-11:11
 */
@Controller
@RequestMapping("/p_count_check")
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;

    @RequestMapping("/find")
    public String forward(HttpSession session) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("pCountCheck:add");
        arrayList.add("pCountCheck:edit");
        arrayList.add("pCountCheck:delete");

        session.setAttribute("sysPermissionList", arrayList);
        return "quality_monitoring/p_count_check_list";
    }

    //显示工序计量质检
    @ResponseBody
    @RequestMapping("/list")
    public Map listPCountCheck(int page, int rows) {

        PageInfo<ProcessCountCheckVo> allProcessCountCheck = processCountCheckService.findAllProcessCountCheckByPage(page,rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", allProcessCountCheck.getSize());
        map.put("rows", allProcessCountCheck.getList());

        return map;

    }

    @RequestMapping({"/add_judge","/edit_judge","delete_judge"})
    @ResponseBody
    public Map show() {
        //HashMap hashMap = new HashMap();

        return null;
    }


    //显示增加页面
    @RequestMapping("/add")
    public String show3(){

        return "quality_monitoring/p_count_check_add";

    }

    //显示编辑页面
    @RequestMapping("/edit")
    public String show4(){
        return "quality_monitoring/p_count_check_edit";
    }


    //新增一个成品计量
    @ResponseBody
    @RequestMapping("/insert")
    public Map insertProcessCountCheck(ProcessCountCheck processCountCheck){

        int i = processCountCheckService.addProcessCountCheck(processCountCheck);

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
    public Map updateProcessCountCheck(ProcessCountCheck ProcessCountCheck){

        int i = processCountCheckService.editProcessCountCheck(ProcessCountCheck);

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
    public Map deleteProcessCountChecks(String ids){

        int i = 0;

        String[] split = ids.split(",");

        for(String toDelete:split){
            i = processCountCheckService.deleteProcessCountCheck(toDelete);
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

        PageInfo<ProcessCountCheckVo> ProcessCountCheckById = processCountCheckService.findProcessCountCheck (name,searchValue, page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", ProcessCountCheckById.getSize());
        map.put("rows", ProcessCountCheckById.getList());

        return map;
    }


    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateNote(String pCountCheckId,String note){

        ProcessCountCheck processCountCheck = new ProcessCountCheck();
        processCountCheck.setpCountCheckId(pCountCheckId);
        processCountCheck.setNote(note);

        int i = processCountCheckService.updateNote(processCountCheck);

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
