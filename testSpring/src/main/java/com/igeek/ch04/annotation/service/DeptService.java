package com.igeek.ch04.annotation.service;

import com.igeek.ch04.annotation.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptService {

    @Resource(name="deptDao")
    private IDao dao;

    public void selectOne(){
        dao.select();
        System.out.println("DeptService selectOne()");
    }
}
