package com.unknown_energy.baas.mapper;

import com.unknown_energy.baas.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUsers();

    void insertUser(@Param("user") User user);

    Long checkIfUserExists(String username);
}
