package com.minol.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.minol.domain.entity.Room;
import com.minol.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BillController {
    @Autowired
    BillService billService;
    @GetMapping("/bills")
    public PageInfo<Room> getBuill(@RequestParam int num,
                                   @RequestParam int size){
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(num,size);//分页语句
        List<Room> rooms=billService.getBillData(map);
        PageInfo<Room> pageInfo=new PageInfo<>(rooms);
        List<Room> list = pageInfo.getList();
        return null;
    }
}
