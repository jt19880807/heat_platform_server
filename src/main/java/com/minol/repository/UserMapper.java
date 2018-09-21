package com.minol.repository;

import com.minol.domain.entity.Core_User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    Core_User getUserByName(String userName);
}
