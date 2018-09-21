package com.minol.controller;

import com.minol.domain.entity.Core_User;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    public String login(@RequestBody Core_User user){

        return "";
    }
}
