package com.albert;


import com.albert.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void test01(){

        String resource = "classpath:applicationContext.xml";

        ApplicationContext ac = new ClassPathXmlApplicationContext(resource);

        SomeService st = (SomeService) ac.getBean("someServiceTarget");

        System.out.println("------------前置通知--------------");
        st.doSome("tom", 20);

        System.out.println("------------后置通知--------------");
        st.doOther("jerry", 21);

        System.out.println("------------环绕通知--------------");
        String jack = st.doFirst("jack", 22);
        System.out.println(jack);

        System.out.println("------------最终通知--------------");
        st.doThird("alien", 23);
    }
}
