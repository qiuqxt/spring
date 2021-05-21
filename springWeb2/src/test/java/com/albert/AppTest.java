package com.albert;

import com.albert.entity.Student;
import com.albert.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test01(){
        String resource = "classpath:applicationContext.xml";

        ApplicationContext ac = new ClassPathXmlApplicationContext(resource);

        StudentService myStudentService = (StudentService) ac.getBean("myStudentService");
        List<Student> students = myStudentService.selectAllStudents();
        students.forEach(e -> System.out.println(e));


    }
}
