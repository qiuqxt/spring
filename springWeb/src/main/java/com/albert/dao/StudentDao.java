package com.albert.dao;

import com.albert.entity.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Integer id);

    Student selectStudentById(Integer id);
    List<Student> selectAllStudents();

}
