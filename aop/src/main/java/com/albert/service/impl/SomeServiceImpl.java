package com.albert.service.impl;

import com.albert.service.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, Integer age) {
        System.out.println("执行了业务方法doSome");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("执行了业务方法doOther");
        return "doOther";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("执行了业务方法doFirst");
        return "doFirst";
    }

    @Override
    public void doThird(String name, Integer age) {
        System.out.println(10/0);
    }
}
