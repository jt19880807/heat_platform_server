package com.minol.service;

import com.minol.domain.entity.MeterData;
import com.minol.domain.entity.MeterECA;
import com.minol.domain.entity.Room;
import com.minol.repository.BillMapper;
import com.minol.repository.MeterDataMapper;
import org.apache.poi.ss.formula.functions.Roman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BillService {
    @Autowired
    BillMapper billMapper;
    public List<Room> getBillData(Map map){return billMapper.getBillData(map);}
}
