package com.minol.controller;

import com.alibaba.fastjson.JSONObject;
import com.minol.domain.entity.EntranceTempAnalyse;
import com.minol.domain.entity.ProjectBaseInfo;
import com.minol.domain.entity.ProjectTree;
import com.minol.domain.entity.UseHeaAndArea;
import com.minol.domain.model.AreaHeatModel;
import com.minol.domain.model.MapNode;
import com.minol.domain.model.Node;
import com.minol.domain.model.ProjectMap;
import com.minol.service.ProjectService;
import com.minol.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/projectTree/{buildIds}")
    public JSONObject getProjectTree(@PathVariable String buildIds) throws NoSuchAlgorithmException {
        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        //根据buildID获取所有的项目信息
        List<ProjectTree> projectsTrees = projectService.getProjectsByBuildIds(map);
        Map<String,Node> company=new HashMap<>();//热力公司
        Map<String,Node> source_plant=new HashMap<>();//热源厂
        Map<String,Node> exchange_station=new HashMap<>();//换热站
        Map<String,Node> zone=new HashMap<>();//小区
        Map<String,Node> build=new HashMap<>();//楼栋
        Node treeNode;
        for (int i=0;i<projectsTrees.size();i++){
            //1、存储热力公司
            if (company.get(projectsTrees.get(i).getCompany_id() + "")==null) {
                treeNode = new Node();
                treeNode.setId(projectsTrees.get(i).getCompany_id());
                treeNode.setTitle(projectsTrees.get(i).getCompany_name());
                treeNode.setName(projectsTrees.get(i).getCompany_name());
                treeNode.setParentId(0);
                treeNode.setType("0");
                if (i == 0) {
                    treeNode.setExpand(true);
                }
//                treeNode.setDisabled(true);
                company.put(projectsTrees.get(i).getCompany_id() + "", treeNode);
            }

            //2、热源厂
            if (source_plant.get(projectsTrees.get(i).getSource_plant_id() + "")==null) {
                treeNode = new Node();
                treeNode.setId(projectsTrees.get(i).getSource_plant_id());
                treeNode.setTitle(projectsTrees.get(i).getSource_plant_name());
                treeNode.setName(projectsTrees.get(i).getSource_plant_name());
                treeNode.setParentId(projectsTrees.get(i).getCompany_id());
                treeNode.setType("1");
                //if (i == 0) {
                treeNode.setExpand(true);
                //}
//                treeNode.setDisabled(true);
                source_plant.put(projectsTrees.get(i).getSource_plant_id() + "", treeNode);
            }

            //3、换热站
            if (exchange_station.get(projectsTrees.get(i).getExchange_station_id()+"")==null) {
                treeNode=new Node();
                treeNode.setId(projectsTrees.get(i).getExchange_station_id());
                treeNode.setTitle(projectsTrees.get(i).getExchange_station_name());
                treeNode.setName(projectsTrees.get(i).getExchange_station_name());
                treeNode.setParentId(projectsTrees.get(i).getSource_plant_id());
                treeNode.setType("2");
                if (i==0){
                    treeNode.setSelected(true);
                }
                exchange_station.put(projectsTrees.get(i).getExchange_station_id() + "", treeNode);
            }

            //4、小区
            if (zone.get(projectsTrees.get(i).getZone_id()+"")==null) {
                treeNode=new Node();
                treeNode.setId(projectsTrees.get(i).getZone_id());
                treeNode.setTitle(projectsTrees.get(i).getZone_name());
                treeNode.setName(projectsTrees.get(i).getZone_name());
                treeNode.setParentId(projectsTrees.get(i).getExchange_station_id());
                treeNode.setType("3");
                zone.put(projectsTrees.get(i).getZone_id() + "", treeNode);
            }

            //5、楼栋
            if (build.get(projectsTrees.get(i).getBuild_id() + "")==null) {
                treeNode = new Node();
                treeNode.setId(projectsTrees.get(i).getBuild_id());
                treeNode.setTitle(projectsTrees.get(i).getBuild_name());
                treeNode.setName(projectsTrees.get(i).getZone_name()+projectsTrees.get(i).getBuild_name());
                treeNode.setParentId(projectsTrees.get(i).getZone_id());
                treeNode.setType("4");
                build.put(projectsTrees.get(i).getBuild_id() + "", treeNode);
            }
        }

        for (Node n:build.values()){
            zone.get(n.getParentId()+"").getChildren().add(n);
        }
        for (Node n:zone.values()){
            exchange_station.get(n.getParentId()+"").getChildren().add(n);
        }
        for (Node n:exchange_station.values()){
            source_plant.get(n.getParentId()+"").getChildren().add(n);
        }
        for (Node n:source_plant.values()){
            company.get(n.getParentId()+"").getChildren().add(n);
        }
        //return user.getUsername();
        return JsonUtils.fillResultString(0,"成功",company.values());
    }

    @GetMapping("/projectBaseInfo/{buildIds}")
    public JSONObject getProjectBaseInfo(@PathVariable String buildIds) throws NoSuchAlgorithmException {
        JSONObject result;
        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        ProjectBaseInfo projectBaseInfo = projectService.getProjectBaseInfoByBuildIds(map);
        result=JsonUtils.fillResultString(0,"成功",projectBaseInfo);
        return result;
    }

    @GetMapping("/projectMapData/{buildIds}")
    public JSONObject getProjectMapData(@PathVariable String buildIds){

        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        List<ProjectMap> provinces = projectService.getProvinceByBuildIds(map);
        ProjectBaseInfo baseInfo;
        List<MapNode> mapNodes=new ArrayList<>();
        MapNode mapNode;
        for (ProjectMap p:provinces){
            map.put("province",p.getName());
            baseInfo=projectService.getProjectBaseInfoByBuildIdAndProvince(map);
            mapNode=new MapNode("热源厂",baseInfo.getSource_plant_count());
            p.getValue().add(mapNode);
            mapNode=new MapNode("换热站",baseInfo.getExchange_station_count());
            p.getValue().add(mapNode);
            mapNode=new MapNode("小区",baseInfo.getZone_count());
            p.getValue().add(mapNode);
            mapNode=new MapNode("楼栋",baseInfo.getBuild_count());
            p.getValue().add(mapNode);
            mapNode=new MapNode(p.getName(),baseInfo.getCompany_count());
            mapNodes.add(mapNode);
        }
        JSONObject result=new JSONObject(){{
            put("data",mapNodes);
            put("toolTipData",provinces);
        }};
        return result;
    }

    @GetMapping("/householdsAndArea")
    public JSONObject getHouseholdsAndArea(@RequestParam  String buildIds, @RequestParam Integer type,@RequestParam String name){
        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<Integer> builds = projectService.getBuilds(map);
        if(builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            ProjectBaseInfo householdsAndArea = projectService.getHouseholdsAndArea(map);
            return JsonUtils.fillResultString(0, "成功", householdsAndArea);
        }
        return JsonUtils.fillResultString(1, "失败", null);
    }

    /**
     * 获取区域热耗
     * @param buildIds
     * @param type
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/areaHeat")
    public JSONObject getAreaHeat(@RequestParam  String buildIds,
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
        List<Integer> builds = projectService.getBuilds(map);
        List<AreaHeatModel> areaHeatModels=new ArrayList<>();
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            map.put("startDate", startDate);
            map.put("endDate", endDate);
            List<UseHeaAndArea> areaHeats = projectService.getAreaHeat(map);

            Double allArea = areaHeats.get(0).getV1();
            Double sideArea = areaHeats.get(0).getV2();
            Double topArea = areaHeats.get(0).getV3();
            if (areaHeats.get(0) != null) {
                allArea = areaHeats.get(0).getV1() == null ? 0.0 : areaHeats.get(0).getV1();
                sideArea = areaHeats.get(0).getV2() == null ? 0.0 : areaHeats.get(0).getV2();
                topArea = areaHeats.get(0).getV3() == null ? 0.0 : areaHeats.get(0).getV3();
            }
            Double allHeat = 0.0;
            Double sideHeat = 0.0;
            Double topHeat = 0.0;
            if (areaHeats.get(1) != null) {
                allHeat = areaHeats.get(1).getV1() == null ? 0.0 : areaHeats.get(1).getV1();
                sideHeat = areaHeats.get(1).getV2() == null ? 0.0 : areaHeats.get(1).getV2();
                topHeat = areaHeats.get(1).getV3() == null ? 0.0 : areaHeats.get(1).getV3();
            }

            AreaHeatModel areaHeatModel;
            areaHeatModel = new AreaHeatModel();
            areaHeatModel.setName("用热量");
            areaHeatModel.setAll(allHeat + "");
            areaHeatModel.setSide(sideHeat + "");
            areaHeatModel.setTop(topHeat + "");
            areaHeatModels.add(areaHeatModel);

            areaHeatModel = new AreaHeatModel();
            areaHeatModel.setName("供热面积");
            areaHeatModel.setAll(allArea + "");
            areaHeatModel.setSide(sideArea + "");
            areaHeatModel.setTop(topArea + "");
            areaHeatModels.add(areaHeatModel);

            areaHeatModel = new AreaHeatModel();
            areaHeatModel.setName("平均单耗");
            areaHeatModel.setAll(String.format("%.2f", allArea == 0 ? 0 : allHeat / allArea));
            areaHeatModel.setSide(String.format("%.2f", sideArea == 0 ? 0 : sideHeat / sideArea));
            areaHeatModel.setTop(String.format("%.2f", topArea == 0 ? 0 : topHeat / topArea));
            areaHeatModels.add(areaHeatModel);
            return JsonUtils.fillResultString(0,"成功",areaHeatModels);
        }
        return JsonUtils.fillResultString(1,"失败",areaHeatModels);
    }

    @GetMapping("/entrance_temp_analyse")
    public JSONObject entrance_temp_analyse(@RequestParam  String buildIds,
                                            @RequestParam Integer type,
                                            @RequestParam String name){
        Map<String, Object> map = new HashMap<String, Object>();
        if(buildIds.equals("*")) {
            map.put("buildIds", '*');
        }else {
            map.put("buildIds",buildIds.split(","));
        }
        map.put("type",type);
        map.put("name",name);
        List<Integer> builds = projectService.getBuilds(map);
        if (builds.size()>0) {
            String[] strBuilds = new String[builds.size()];
            Integer[] inBuilds = new Integer[builds.size()];
            map.put("buildIds", builds.toArray(inBuilds));
            EntranceTempAnalyse entranceTempAnalyse = projectService.entrance_temp_analyse(map);
            return JsonUtils.fillResultString(0, "成功", entranceTempAnalyse);
        }
        return JsonUtils.fillResultString(1, "失败", null);

    }
}
