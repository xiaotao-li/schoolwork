package com.igeek.ch04.annotation.test;

import com.igeek.ch04.annotation.controller.DeptController;
import com.igeek.ch04.annotation.entity.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch04_annotation.xml");

        Dept dept = ac.getBean(Dept.class);
        System.out.println(dept);

        DeptController controller = ac.getBean(DeptController.class);
        controller.find();

    }

}
