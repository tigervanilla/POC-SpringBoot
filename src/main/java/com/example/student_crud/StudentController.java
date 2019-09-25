package com.example.student_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public @ResponseBody int insertStudent(@Valid @NotNull @RequestBody Student student) {
        return studentService.insertStudent(student);
    }
}
