package com.example.student_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

 /*
 * @Repository annotation is used to indicate that the class provides the mechanism for
 * storage, retrieval, search, update and delete operation on objects.
 */

@Repository
public class StudentDAO {
 /*
 * @Autowiring enables you to inject the object dependency implicitly.
 * It internally uses setter or constructor injection.
 * Autowiring can't be used to inject primitive and string values.
 * It works with reference only.
 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertStudent(Student student) {
        String query="INSERT INTO student(roll,name,phone) VALUES(?,?,?)";
        return jdbcTemplate.update(query,student.getRoll(),student.getName(),student.getPhone());
    }

    public int updateStudent(int roll, String newName, String newPhone) {
        String query="UPDATE student SET name=?, phone=? WHERE roll=?";
        return jdbcTemplate.update(query,newName,newPhone,roll);
    }

    public int updateName(int roll, String newName) {
        String query="UPDATE student SET name=? WHERE roll=?";
        return jdbcTemplate.update(query,newName,roll);
    }

    public int updatePhone(int roll, String newPhone) {
        String query="UPDATE student SET phone=? WHERE roll=?";
        return jdbcTemplate.update(query,newPhone,roll);
    }
}
