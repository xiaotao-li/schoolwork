package com.igeek.ch05.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class CountLogProxy {

    private ICount target;

    public CountLogProxy(ICount target){
        this.target = target;
    }

    public ICount getProxy(){

        ICount proxy = null;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                List<Object> arg = Arrays.asList(args);
                System.out.println("日志追踪：the methods "+methodName+" begin with " + arg);
                Object result = null;
                try {
                    result = method.invoke(target, args);
                    System.out.println("日志追踪：the methods "+methodName+" end with "+result);
                }catch (Exception e){
                    System.out.println("日志追踪： the method "+methodName+" 抛出异常： "+e.getMessage());
                }
                System.out.println("日志追踪：the methods "+methodName+" end with ");
                return result;
            }
        };

        proxy = (ICount) Proxy.newProxyInstance(classLoader,interfaces,h);
        return proxy;
    }

}
