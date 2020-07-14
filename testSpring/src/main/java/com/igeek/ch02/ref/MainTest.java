package com.igeek.ch02.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch02_ref.xml");
        Person person = ac.getBean(Person.class);
        System.out.println(person);
    }

}
