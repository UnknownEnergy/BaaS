package com.unknown_energy.baas.mapper;

import com.unknown_energy.baas.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAllUsers();
}
