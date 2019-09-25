package com.webservice.rest.controller;

import java.util.List;

import com.webservice.rest.model.Student;
import com.webservice.rest.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/")
    public List<Student> index() {
        return repository.findAll();
    }

    @PostMapping("/")
    public Student store(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @GetMapping("/{id}")
    public Student show(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student newStudent, @PathVariable Long id) {
        return repository.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            return repository.save(student);
        }).orElseGet(() -> {
            newStudent.setId(id);
            return repository.save(newStudent);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
