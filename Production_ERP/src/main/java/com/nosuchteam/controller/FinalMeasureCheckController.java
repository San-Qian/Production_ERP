package com.nosuchteam.controller;

import com.github.pagehelper.PageInfo;
import com.nosuchteam.bean.FinalMeasuretCheck;
import com.nosuchteam.bean.vo.FinalMeasuretCheckVo;
import com.nosuchteam.service.FinalMeasureCheckService;
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
@RequestMapping("/measure")
public class FinalMeasureCheckController {

    @Autowired
    FinalMeasureCheckService finalMeasureCheckService;

    @RequestMapping("/find")
    public String forward(HttpSession session) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("measure:add");
        arrayList.add("measure:edit");
        arrayList.add("measure:delete");

        session.setAttribute("sysPermissionList", arrayList);

        return "quality_monitoring/measurement_list";
    }


    @RequestMapping({"/add_judge","/edit_judge","delete_judge"})
    @ResponseBody
    public Map show() {
        //HashMap hashMap = new HashMap();

        return null;
    }

    //显示成品计量质检
    @ResponseBody
    @RequestMapping("/list")
    public Map listMeasuret(int page, int rows) {

        PageInfo<FinalMeasuretCheckVo> finalMeasuretCheckList = finalMeasureCheckService.findFinalMeasuretCheckByPage(page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", finalMeasuretCheckList.getSize());
        map.put("rows", finalMeasuretCheckList.getList());

        return map;

    }

    //显示增加页面
    @RequestMapping("/add")
    public String show3(){

        return "quality_monitoring/measurement_add";

    }

    //显示编辑页面
    @RequestMapping("/edit")
    public String show4(){
        return "quality_monitoring/measurement_edit";
    }


    //新增一个成品计量
    @ResponseBody
    @RequestMapping("/insert")
    public Map insertMeasureCheck(FinalMeasuretCheck finalMeasuretCheck){

        int i = finalMeasureCheckService.addFinalMeasureCheck(finalMeasuretCheck);

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
    public Map updateMeasureCheck(FinalMeasuretCheck finalMeasuretCheck){

        int i = finalMeasureCheckService.editFinalMeasureCheck(finalMeasuretCheck);

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
    public Map deleteMeasureChecks(String ids){

        int i = 0;

        String[] split = ids.split(",");

        for(String toDelete:split){
            i = finalMeasureCheckService.deleteFinalMeasureCheck(toDelete);
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

        PageInfo<FinalMeasuretCheckVo> MeasureCheckById = finalMeasureCheckService.findFinalMeasureCheck (name,searchValue, page, rows);

        HashMap<String, Object> map = new HashMap();

        map.put("total", MeasureCheckById.getSize());
        map.put("rows", MeasureCheckById.getList());

        return map;
    }


    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map updateNote(String fMeasureCheckId,String note){

        FinalMeasuretCheck finalMeasuretCheck = new FinalMeasuretCheck();
        finalMeasuretCheck.setfMeasureCheckId(fMeasureCheckId);
        finalMeasuretCheck.setNote(note);

        int i = finalMeasureCheckService.updateNote(finalMeasuretCheck);

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
