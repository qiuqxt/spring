package com.albert.service.impl;

import com.albert.dao.StudentDao;
import com.albert.entity.Student;
import com.albert.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    // 定义dao的引用类型的属性
    private StudentDao studentDao;

    // 为了设置注入
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Student selectStudentById(Integer id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public List<Student> selectAllStudents() {
        return studentDao.selectAllStudents();
    }
}
