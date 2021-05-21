package com.albert.service.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    /**
     * 前置通知
     */
    @Before(value = "execution(* com.albert.service.impl.SomeServiceImpl.doSome(..))")
    public void myBefore(){
        System.out.println("前置通知：在目标方法执行之前先执行，例如输出日志");
    }

    @Before(value = "execution(* com.albert.service.impl.SomeServiceImpl.doSome(..))")
    public void myBefore(JoinPoint jp){
        // JointPoint能够获得方法的定义，方法的参数等信息
        System.out.println("方法的定义："+jp.getSignature());
        System.out.println("方法的参数："+jp.getArgs().length);
    }

    /**
     * 后置通知
     * @param result 目标方法的返回结果
     */
    @AfterReturning(value = "execution(* com.albert.service.impl.SomeServiceImpl.doOther(..))", returning = "result")
    public void myAfterReturning(Object result){
        // 该注解的 returning 属性就是用于指定接收方法返回值的变量名的
        // 修改目标方法的执行结果
        if(result != null){
            String s = (String)result;
            result = s.toUpperCase();
        }
        System.out.println("后置通知：在目标方法之后执行的功能增强，例如执行事务处理：" + result);
    }

    /**
     * 环绕通知
     * 在目标方法执行之前之后执行。被注解为环绕增强的方法要有返回值，Object 类型。
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;

        // 功能增强
        System.out.println("环绕通知：在目标方法之前执行，例如输出日志");

        // 执行目标方法的调用，等同于 method.invoke(target, args)
        obj = pjp.proceed();
        System.out.println("连接点的方法定义："+pjp.getSignature());
        System.out.println("连接点的方法参数："+pjp.getArgs().length);

        // 功能增强
        System.out.println("环绕通知：在目标方法之后执行，例如处理事务");

        // 返回目标方法的执行结果
        return obj;
    }

    /**
     * 最终通知
     */
    @After(value = "mypt()")
    public void myAfter(){
        System.out.println("最终通知：总是会被执行的方法");
    }

    /**
     * @Pointcut 定义切入点
     */
    @Pointcut(value = "execution( * *..SomeServiceImpl.doThird(..))")
    private void mypt(){
        // 无需代码
    }
}
