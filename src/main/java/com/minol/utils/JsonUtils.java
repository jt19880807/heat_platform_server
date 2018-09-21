package com.minol.utils;

//import org.json.JSONObject;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
    public static JSONObject fillResultString(Integer status,String msg,Object result){
        JSONObject jsonObject=new JSONObject(){{
            put("status",status);
            put("msg",msg);
            put("result",result);
        }};
        return jsonObject;
    }
}
