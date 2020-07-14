package com.igeek.ch04.annotation.controller;

import com.igeek.ch04.annotation.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    public void find(){
        deptService.selectOne();
        System.out.println("DeptController find()");
    }

}
