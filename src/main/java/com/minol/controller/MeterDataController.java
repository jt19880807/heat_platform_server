package com.minol.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.minol.domain.entity.*;
import com.minol.domain.model.AreaHeatModel;
import com.minol.service.MeterDataService;
import com.minol.service.NodeDataService;
import com.minol.service.ProjectService;
import com.minol.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 楼栋大表Controller
 */
@RestController
public class MeterDataController {

    @Autowired
    MeterDataService meterDataService;
    @Autowired
    NodeDataService nodeDataService;
    @Autowired
    ProjectService projectService;

    /**
     * 获取楼栋大表读数
     * @param zoneId
     * @param buildId
     * @param meterId
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/meterData")
    public PageInfo<MeterData> getMeterData(@RequestParam  Integer zoneId,
                                              @RequestParam Integer buildId,
                                              @RequestParam Integer meterId,
                                              @RequestParam Date startDate,
                                              @RequestParam Date endDate,
                                              @RequestParam int num,
                                              @RequestParam int size){

        Map<String, Object> map = new HashMap<String, Object>();
       if (zoneId!=0){
           map.put("zoneId",zoneId);
       }
        if (buildId!=0){
            map.put("buildId",buildId);
        }
        if (meterId!=0){
            map.put("meterId",meterId);
        }
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        List<MeterData> meterDatas=new ArrayList<>();
        PageHelper.startPage(num,size);//分页语句
        meterDatas=meterDataService.getMeterData(map);
        return new PageInfo<MeterData>(meterDatas);
    }
    /**
     * 获取楼栋大表读数
     * @param zoneId
     * @param buildId
     * @param meterId
     * @return
     */
    @GetMapping("/meterECA")
    public JSONObject getMeterECA(@RequestParam  Integer zoneId,
                                            @RequestParam Integer buildId,
                                            @RequestParam Integer meterId,
                                            @RequestParam Date startDate,
                                            @RequestParam Date endDate){

        Map<String, Object> map = new HashMap<String, Object>();
        if (zoneId!=0){
            map.put("zoneId",zoneId);
        }
        if (buildId!=0){
            map.put("buildId",buildId);
        }
        if (meterId!=0){
            map.put("meterId",meterId);
        }
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        List<MeterECA> meterECA=new ArrayList<>();
        meterECA=meterDataService.getBuildMeterECA(map);
        return JsonUtils.fillResultString(0,"成功",meterECA);
    }
}
