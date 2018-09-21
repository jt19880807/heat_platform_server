package com.minol.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.minol.domain.entity.*;
import com.minol.domain.model.AreaHeatModel;
import com.minol.domain.model.MapNode;
import com.minol.domain.model.Node;
import com.minol.domain.model.ProjectMap;
import com.minol.service.NodeDataService;
import com.minol.service.ProjectService;
import com.minol.utils.JsonUtils;
import com.sun.org.apache.xalan.internal.lib.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class NodeDataController {

    @Autowired
    NodeDataService nodeDataService;
    @Autowired
    ProjectService projectService;
    /**
     * 获取实时数据
     * @param buildIds
     * @param type
     * @param name
     * @return
     */
    @GetMapping("/lastNodeData")
    public PageInfo<NodeData> getLastNodeData(@RequestParam  String buildIds,
                                              @RequestParam Integer type,
                                              @RequestParam String name,
                                              @RequestParam String entrancetemp,
                                              @RequestParam int num,
                                              @RequestParam int size){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<Integer> builds = projectService.getBuilds(map);
        List<AreaHeatModel> areaHeatModels=new ArrayList<>();
        List<NodeData> lastNodeData=new ArrayList<>();
        PageHelper.startPage(num,size);//分页语句
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("e0",Integer.parseInt(entrancetemp.split("-")[0]));
            map.put("e1",Integer.parseInt(entrancetemp.split("-")[1]));
            lastNodeData= nodeDataService.getLastNodeData(map);
        }

        return new PageInfo<NodeData>(lastNodeData);
    }
    @GetMapping("/historyNodeData")
    public PageInfo<NodeData> getHistoryNodeData(@RequestParam  String buildIds,
                                                 @RequestParam Integer type,
                                                 @RequestParam String name,
                                                 @RequestParam Date startDate,
                                                 @RequestParam Date endDate,
                                                 @RequestParam int num,
                                                 @RequestParam int size){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<NodeData> historyNodeData=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        PageHelper.startPage(num,size);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("startDate", startDate);
            map.put("endDate", endDate);
            historyNodeData= nodeDataService.getHistoryNodeData(map);
        }
        return new PageInfo<NodeData>(historyNodeData);
    }
    @GetMapping("/zoneDayHeat")
    public JSONObject getZoneDayHeat(@RequestParam  String buildIds,
                                                 @RequestParam Integer type,
                                                 @RequestParam String name,
                                                 @RequestParam Date date){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<UseOfHeat> useOfHeats=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("date", date);
            useOfHeats= nodeDataService.getZoneDayHeat(map);
            return JsonUtils.fillResultString(0,"成功",useOfHeats);
        }
        return JsonUtils.fillResultString(1,"失败",useOfHeats);
    }
    @GetMapping("/zoneMonthHeat")
    public JSONObject getZoneMonthHeat(@RequestParam  String buildIds,
                                     @RequestParam Integer type,
                                     @RequestParam String name,
                                     @RequestParam Date date){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<UseOfHeat> useOfHeats=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("date", date);
            useOfHeats= nodeDataService.getZoneMonthHeat(map);
            return JsonUtils.fillResultString(0,"成功",useOfHeats);
        }
        return JsonUtils.fillResultString(1,"失败",useOfHeats);
    }

    @GetMapping("/buildDayHeat")
    public PageInfo<UseOfHeat> getBuildDayHeat(@RequestParam  String buildIds,
                                     @RequestParam Integer type,
                                     @RequestParam String name,
                                     @RequestParam Date date,
                                      @RequestParam int num,
                                      @RequestParam int size){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<UseOfHeat> useOfHeats=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        PageHelper.startPage(num,size);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("date", date);
            useOfHeats= nodeDataService.getBuildDayHeat(map);
        }
        return new PageInfo<UseOfHeat>(useOfHeats);
    }
    @GetMapping("/buildMonthHeat")
    public PageInfo<UseOfHeat> getBuildMonthHeat(@RequestParam  String buildIds,
                                       @RequestParam Integer type,
                                       @RequestParam String name,
                                       @RequestParam Date date,
                                        @RequestParam int num,
                                        @RequestParam int size){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<UseOfHeat> useOfHeats=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        PageHelper.startPage(num,size);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("date", date);
            useOfHeats= nodeDataService.getBuildMonthHeat(map);
        }
        return new PageInfo<UseOfHeat>(useOfHeats);
    }

    @GetMapping("/zoneContrast")
    public JSONObject getZoneContrast(@RequestParam  String buildIds,
                                      @RequestParam Integer type,
                                      @RequestParam String name,
                                      @RequestParam Date startDate,
                                      @RequestParam Date endDate){
        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<Contrast> zoneContrasts=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("startDate", startDate);
            map.put("endDate", endDate);
            zoneContrasts = nodeDataService.getZoneContrast(map);
            return JsonUtils.fillResultString(0,"成功",zoneContrasts);
        }
        return JsonUtils.fillResultString(1,"失败",null);
    }

    @GetMapping("/buildContrast")
    public PageInfo<Contrast> getBuildContrast(@RequestParam  String buildIds,
                                      @RequestParam Integer type,
                                      @RequestParam String name,
                                      @RequestParam Date startDate,
                                      @RequestParam Date endDate,
                                       @RequestParam int num,
                                       @RequestParam int size){
        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<Contrast> buildContrasts=new ArrayList<>();
        List<Integer> builds = projectService.getBuilds(map);
        PageHelper.startPage(num,size);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("startDate", startDate);
            map.put("endDate", endDate);
            buildContrasts = nodeDataService.getBuildContrast(map);
        }
        return new PageInfo<Contrast>(buildContrasts);
    }
}
