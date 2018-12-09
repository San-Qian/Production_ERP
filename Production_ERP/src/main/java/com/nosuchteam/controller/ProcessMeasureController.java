package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.ProcessMeasureCheck;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import com.nosuchteam.bean.vo.ProcessMeasureCheckVo;
import com.nosuchteam.service.ProcessMeasureCheckService;
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
@RequestMapping("/p_measure_check")
public class ProcessMeasureController {

    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("/find")
    public String forward(HttpSession session) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("pMeasureCheck:add");
        arrayList.add("pMeasureCheck:edit");
        arrayList.add("pMeasureCheck:delete");

        session.setAttribute("sysPermissionList", arrayList);

        return "quality_monitoring/p_measure_check_list";
    }

    //显示工序计量质检
    @ResponseBody
    @RequestMapping("/list")
    public Map listPMeasureCheck(int page, int rows) {

        PageInfo<ProcessMeasureCheckVo> allProcessMeasureCheck = processMeasureCheckService.findAllProcessMeasureCheckByPage(page,rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", allProcessMeasureCheck.getSize());
        map.put("rows", allProcessMeasureCheck.getList());

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

        return "quality_monitoring/p_measure_check_add";

    }

    //显示编辑页面
    @RequestMapping("/edit")
    public String show4(){
        return "quality_monitoring/p_measure_check_edit";
    }


    //新增一个成品计量
    @ResponseBody
    @RequestMapping("/insert")
    public Map insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck){

        int i = processMeasureCheckService.addProcessMeasureCheck(processMeasureCheck);

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
    public Map updateProcessMeasureCheck(ProcessMeasureCheck ProcessMeasureCheck){

        int i = processMeasureCheckService.editProcessMeasureCheck(ProcessMeasureCheck);

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
    public Map deleteProcessMeasureChecks(String ids){

        int i = 0;

        String[] split = ids.split(",");

        for(String toDelete:split){
            i = processMeasureCheckService.deleteProcessMeasureCheck(toDelete);
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

        PageInfo<ProcessMeasureCheckVo> ProcessMeasureCheckById = processMeasureCheckService.findProcessMeasureCheck (name,searchValue, page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", ProcessMeasureCheckById.getSize());
        map.put("rows", ProcessMeasureCheckById.getList());

        return map;
    }


    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateNote(String pMeasureCheckId,String note){

        ProcessMeasureCheck processMeasureCheck = new ProcessMeasureCheck();
        processMeasureCheck.setpMeasureCheckId(pMeasureCheckId);
        processMeasureCheck.setNote(note);

        int i = processMeasureCheckService.updateNote(processMeasureCheck);

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
