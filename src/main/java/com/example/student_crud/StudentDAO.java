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
        String query="INSERT INTO student(id,name,phone) VALUES(?,?,?)";
        try {
            return jdbcTemplate.update(query,student.getRoll(),student.getName(),student.getPhone());
        } catch (Exception e) {
            System.err.println(e);
        }
        return -1;
    }
}