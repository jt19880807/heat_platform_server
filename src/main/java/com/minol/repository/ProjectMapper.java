package com.minol.repository;

import com.minol.domain.entity.*;
import com.minol.domain.model.ProjectMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProjectMapper {
    List<ProjectTree> getProjectsByBuildIds(Map map);
    ProjectBaseInfo getProjectBaseInfoByBuildIds(Map map);
    ProjectBaseInfo getProjectBaseInfoByBuildIdAndProvince(Map map);
    List<ProjectMap> getProvinceByBuildIds(Map map);
    List<Integer> getBuilds(Map map);
    ProjectBaseInfo getHouseholdsAndArea(Map map);
    List<UseHeaAndArea> getAreaHeat(Map map);
    EntranceTempAnalyse entrance_temp_analyse(Map map);
}
