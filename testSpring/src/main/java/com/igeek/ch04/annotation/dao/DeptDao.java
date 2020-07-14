package com.igeek.ch04.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "deptDao")
public class DeptDao implements IDao{

    public void select(){
        System.out.println("UserDao select()....");
    }

}
