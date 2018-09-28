package com.minol.repository;

import com.minol.domain.entity.MeterData;
import com.minol.domain.entity.MeterECA;
import com.minol.domain.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BillMapper {
    List<Room> getBillData(Map map);
}
