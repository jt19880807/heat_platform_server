package com.minol.service;

import com.minol.domain.entity.*;
import com.minol.domain.model.ProjectMap;
import com.minol.repository.ProjectMapper;
import com.minol.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    public List<ProjectTree> getProjectsByBuildIds(Map map){
        return projectMapper.getProjectsByBuildIds(map);
    }
    public ProjectBaseInfo getProjectBaseInfoByBuildIds(Map map){
        return projectMapper.getProjectBaseInfoByBuildIds(map);
    }
    public ProjectBaseInfo getProjectBaseInfoByBuildIdAndProvince(Map map){
        return projectMapper.getProjectBaseInfoByBuildIdAndProvince(map);
    }
    public List<ProjectMap> getProvinceByBuildIds(Map map){
        return projectMapper.getProvinceByBuildIds(map);
    }

    public List<Integer> getBuilds(Map map){return  projectMapper.getBuilds(map);}

    public ProjectBaseInfo getHouseholdsAndArea(Map map){return projectMapper.getHouseholdsAndArea(map);}

    public List<UseHeaAndArea> getAreaHeat(Map map){ return  projectMapper.getAreaHeat(map);}

    public EntranceTempAnalyse entrance_temp_analyse(Map map){return projectMapper.entrance_temp_analyse(map);}
}
