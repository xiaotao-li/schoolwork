package com.igeek.ch01.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        
        HelloWorld helloWorld = new HelloWorld();    
        helloWorld.setUsername1("陶李");       
        helloWorld.work();

        System.out.println();
        System.out.println("-------------Spring IOC------------");

        
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld h = ac.getBean(HelloWorld.class);
        h.work();
    }

}
