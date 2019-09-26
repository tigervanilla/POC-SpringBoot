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
    public @ResponseBody int insertStudent(@Valid @NotNull @RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @PutMapping(path = "{roll}")
    public @ResponseBody int updateStudent(@Valid @NotNull @PathVariable(value = "roll", required = true) Integer roll,
                                           @Valid @NotNull @RequestBody Student student) {
        System.out.println("This is it->"+student.getName()+student.getPhone()+student.getRoll());
        return studentService.updateStudent(roll,student);
    }

    @GetMapping
    public @ResponseBody List<Student> getStudent(@Valid @RequestParam(value = "roll", required = false) Integer roll) {
        try {
            return studentService.getStudent(roll);
        } catch (EmptyResultDataAccessException e) {
            return Arrays.asList();
        }

    }

    @DeleteMapping
    public @ResponseBody int deleteStudent(@Valid @NotNull @RequestParam(value = "roll", required = true) Integer roll) {
        return studentService.deleteStudent(roll);
    }
}
