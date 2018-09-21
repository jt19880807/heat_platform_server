package com.minol.service;

import com.minol.domain.entity.*;
import com.minol.domain.model.ProjectMap;
import com.minol.repository.NodeDataMapper;
import com.minol.repository.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NodeDataService {
    @Autowired
    NodeDataMapper nodeDataMapper;
    public List<NodeData> getLastNodeData(Map map){return nodeDataMapper.getLastNodeData(map);}
    public List<NodeData> getHistoryNodeData(Map map){return nodeDataMapper.getHistoryNodeData(map);}
    public List<UseOfHeat> getZoneDayHeat(Map map){return nodeDataMapper.getZoneDayHeat(map);}
    public List<UseOfHeat> getZoneMonthHeat(Map map){return nodeDataMapper.getZoneMonthHeat(map);}
    public List<UseOfHeat> getBuildDayHeat(Map map){return nodeDataMapper.getBuildDayHeat(map);}
    public List<UseOfHeat> getBuildMonthHeat(Map map){return nodeDataMapper.getBuildMonthHeat(map);}
    public List<Contrast> getZoneContrast(Map map){return nodeDataMapper.getZoneContrast(map);}
    public List<Contrast> getBuildContrast(Map map){return nodeDataMapper.getBuildContrast(map);}
}
