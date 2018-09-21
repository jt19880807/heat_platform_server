package com.minol.service;

import com.minol.domain.entity.Core_User;
import com.minol.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public Core_User getUserByName(String userName){
        return userMapper.getUserByName(userName);
    }
}
