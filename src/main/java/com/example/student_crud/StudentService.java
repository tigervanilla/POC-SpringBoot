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

    public int updateStudent(int roll, Student student) {
        if(student.getName()!=null && student.getPhone()!=null) {
            return studentDAO.updateStudent(roll,student.getName(),student.getPhone());
        } else if(student.getName()!=null) {
            return studentDAO.updateName(roll,student.getName());
        } else if(student.getPhone()!=null) {
            return studentDAO.updatePhone(roll,student.getPhone());
        }
        return -1;
    }
}
