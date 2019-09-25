package com.example.student_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public int insertStudent(Student student) {
        return studentDAO.insertStudent(student);
    }
}
