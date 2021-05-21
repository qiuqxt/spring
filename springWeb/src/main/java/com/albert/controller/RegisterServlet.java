package com.albert.controller;

import com.albert.entity.Student;
import com.albert.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取请求参数信息
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");

        System.out.println(name);
        System.out.println(age);
        System.out.println(email);

        // 创建spring容器，获取Service对象
        String resource = "classpath:applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(resource);

        StudentService myStudentService = (StudentService) ac.getBean("myStudentService");

        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setEmail(email);

        int res = myStudentService.insertStudent(student);
        request.setAttribute("res", res);

        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }
}
