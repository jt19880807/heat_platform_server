package com.minol.controller;

import com.alibaba.fastjson.JSONObject;
import com.minol.domain.entity.Core_User;
import com.minol.service.UserService;
import com.minol.utils.Coder;
import com.minol.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JSONObject login(@RequestBody Core_User user) throws NoSuchAlgorithmException {
        JSONObject result;
        Core_User core_user=userService.getUserByName(user.getUsername());
        if (core_user!=null){
            String password=Coder.encryptionMD5(Coder.encodeBASE64(user.getPassword()));
            if (core_user.getPassword().equals(password)){
                result= JsonUtils.fillResultString(0,"登录成功", Arrays.asList(core_user));
            }
            else {//密码不正确
                result= JsonUtils.fillResultString(2,"密码不正确",null);
            }
        }
        else {//用户名不存在
            result= JsonUtils.fillResultString(1,"用户不存在",null);
        }
//       return user.getUsername();
        return result;
    }
}
