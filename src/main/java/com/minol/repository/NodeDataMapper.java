package com.minol.repository;

import com.minol.domain.entity.*;
import com.minol.domain.model.ProjectMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NodeDataMapper {
    List<NodeData> getLastNodeData(Map map);
    List<NodeData> getHistoryNodeData(Map map);
    List<UseOfHeat> getZoneDayHeat(Map map);
    List<UseOfHeat> getZoneMonthHeat(Map map);
    List<UseOfHeat> getBuildDayHeat(Map map);
    List<UseOfHeat> getBuildMonthHeat(Map map);
    List<Contrast> getZoneContrast(Map map);
    List<Contrast> getBuildContrast(Map map);
}
