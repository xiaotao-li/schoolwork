package com.igeek.ch05.aop.proxy;

public class MainTest {

    public static void main(String[] args) {

        ICount target = new CountImpl();
        ICount proxy = new CountLogProxy(target).getProxy();
        System.out.println(proxy.getClass().getName());
        int result1 = proxy.add(5, 6);
        System.out.println("-->result1 = "+result1);

        int result2 = proxy.div(10, 0);
        System.out.println("-->result2 = "+result2);
    }

}
