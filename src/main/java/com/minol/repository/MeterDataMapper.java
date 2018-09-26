package com.minol.repository;

import com.minol.domain.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MeterDataMapper {
    List<MeterData> getMeterData(Map map);
    List<MeterECA> getBuildMeterECA(Map map);
}
