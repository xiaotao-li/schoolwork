package com.igeek.ch03.mapper;

import com.igeek.pojo.User;

import java.util.List;

public interface UserMapper {

    public User findOne(Integer id);
    public List<User> findByName(String username);
    public void insert(User user);
}
