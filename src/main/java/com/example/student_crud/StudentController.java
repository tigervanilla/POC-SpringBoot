package com.example.student_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public int insertStudent(@Valid @NotNull @RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @PutMapping(path = "{roll}")
    public int updateStudent(@Valid @NotNull @PathVariable(value = "roll", required = true) Integer roll,
                             @Valid @NotNull @RequestBody Student student) {
        try {
            System.out.println("This is it->" + student.getName() + student.getPhone() + student.getRoll());
            return studentService.updateStudent(roll, student);
        } catch (Exception e) {
            throw new RequestErrorHandler.StudentServiceException("failed to update user ");
        }
    }

    @GetMapping
    public List<Student> getStudent(@Valid @RequestParam(value = "roll", required = false) Integer roll) {
        try {
            return studentService.getStudent(roll);
        } catch (EmptyResultDataAccessException e) {
            return Arrays.asList();
        }

    }

    @DeleteMapping
    public String deleteStudent(@Valid @NotNull @RequestParam(value = "roll", required = true) Integer roll) {
        return studentService.deleteStudent(roll);
    }
}
