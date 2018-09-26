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
//    @GetMapping("/historyNodeData")
//    public PageInfo<NodeData> getHistoryNodeData(@RequestParam  String buildIds,
//                                                 @RequestParam Integer type,
//                                                 @RequestParam String name,
//                                                 @RequestParam Date startDate,
//                                                 @RequestParam Date endDate,
//                                                 @RequestParam int num,
//                                                 @RequestParam int size){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<NodeData> historyNodeData=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        PageHelper.startPage(num,size);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("startDate", startDate);
//            map.put("endDate", endDate);
//            historyNodeData= nodeDataService.getHistoryNodeData(map);
//        }
//        return new PageInfo<NodeData>(historyNodeData);
//    }
//    @GetMapping("/zoneDayHeat")
//    public JSONObject getZoneDayHeat(@RequestParam  String buildIds,
//                                                 @RequestParam Integer type,
//                                                 @RequestParam String name,
//                                                 @RequestParam Date date){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<UseOfHeat> useOfHeats=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("date", date);
//            useOfHeats= nodeDataService.getZoneDayHeat(map);
//            return JsonUtils.fillResultString(0,"成功",useOfHeats);
//        }
//        return JsonUtils.fillResultString(1,"失败",useOfHeats);
//    }
//    @GetMapping("/zoneMonthHeat")
//    public JSONObject getZoneMonthHeat(@RequestParam  String buildIds,
//                                     @RequestParam Integer type,
//                                     @RequestParam String name,
//                                     @RequestParam Date date){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<UseOfHeat> useOfHeats=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("date", date);
//            useOfHeats= nodeDataService.getZoneMonthHeat(map);
//            return JsonUtils.fillResultString(0,"成功",useOfHeats);
//        }
//        return JsonUtils.fillResultString(1,"失败",useOfHeats);
//    }
//
//    @GetMapping("/buildDayHeat")
//    public PageInfo<UseOfHeat> getBuildDayHeat(@RequestParam  String buildIds,
//                                     @RequestParam Integer type,
//                                     @RequestParam String name,
//                                     @RequestParam Date date,
//                                      @RequestParam int num,
//                                      @RequestParam int size){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<UseOfHeat> useOfHeats=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        PageHelper.startPage(num,size);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("date", date);
//            useOfHeats= nodeDataService.getBuildDayHeat(map);
//        }
//        return new PageInfo<UseOfHeat>(useOfHeats);
//    }
//    @GetMapping("/buildMonthHeat")
//    public PageInfo<UseOfHeat> getBuildMonthHeat(@RequestParam  String buildIds,
//                                       @RequestParam Integer type,
//                                       @RequestParam String name,
//                                       @RequestParam Date date,
//                                        @RequestParam int num,
//                                        @RequestParam int size){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<UseOfHeat> useOfHeats=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        PageHelper.startPage(num,size);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("date", date);
//            useOfHeats= nodeDataService.getBuildMonthHeat(map);
//        }
//        return new PageInfo<UseOfHeat>(useOfHeats);
//    }
//
//    @GetMapping("/zoneContrast")
//    public JSONObject getZoneContrast(@RequestParam  String buildIds,
//                                      @RequestParam Integer type,
//                                      @RequestParam String name,
//                                      @RequestParam Date startDate,
//                                      @RequestParam Date endDate){
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<Contrast> zoneContrasts=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("startDate", startDate);
//            map.put("endDate", endDate);
//            zoneContrasts = nodeDataService.getZoneContrast(map);
//            return JsonUtils.fillResultString(0,"成功",zoneContrasts);
//        }
//        return JsonUtils.fillResultString(1,"失败",null);
//    }
//
//    @GetMapping("/buildContrast")
//    public PageInfo<Contrast> getBuildContrast(@RequestParam  String buildIds,
//                                      @RequestParam Integer type,
//                                      @RequestParam String name,
//                                      @RequestParam Date startDate,
//                                      @RequestParam Date endDate,
//                                       @RequestParam int num,
//                                       @RequestParam int size){
//        Map<String, Object> map = new HashMap<String, Object>();
//        if(buildIds.equals("*")) {
//            map.put("buildIds", '*');
//        }else {
//            map.put("buildIds",buildIds.split(","));
//        }
//        map.put("type",type);
//        map.put("name",name);
//        List<Contrast> buildContrasts=new ArrayList<>();
//        List<Integer> builds = projectService.getBuilds(map);
//        PageHelper.startPage(num,size);
//        if (builds.size()>0) {
//            String[] strBuilds = new String[builds.size()];
//            Integer[] inBuilds = new Integer[builds.size()];
//            map.put("buildIds", builds.toArray(inBuilds));
//            map.put("startDate", startDate);
//            map.put("endDate", endDate);
//            buildContrasts = nodeDataService.getBuildContrast(map);
//        }
//        return new PageInfo<Contrast>(buildContrasts);
//    }
}
