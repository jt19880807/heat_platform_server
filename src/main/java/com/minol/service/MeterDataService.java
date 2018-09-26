package com.minol.service;

import com.minol.domain.entity.*;
import com.minol.repository.MeterDataMapper;
import com.minol.repository.NodeDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MeterDataService {
    @Autowired
    MeterDataMapper meterDataMapper;
    public List<MeterData> getMeterData(Map map){return meterDataMapper.getMeterData(map);}
    public List<MeterECA> getBuildMeterECA(Map map){return meterDataMapper.getBuildMeterECA(map);}

}
