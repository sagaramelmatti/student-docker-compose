package com.kubernetes.demo.controller;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kubernetes.demo.entity.Student;
import com.kubernetes.demo.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private Logger logger = Logger.getLogger(StudentController.class.getName());

    @PostMapping(value = "/create",produces = "application/json")
    public Student saveStudent(@RequestBody Student student){
        logger.info("Saving a new student");
        Student student1 = studentRepository.save(student);
        return student1;
    }

    @GetMapping(value = "/",produces = "application/json")
    public List<Student> getStudents(){
        logger.info("Retrieving all students");
        return studentRepository.findAll();
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public Optional<Student> getStudent(@PathVariable("id") Integer id){
        logger.info("Retrieving student by id");
        return studentRepository.findById(id);
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        logger.info("Deleting student by id");
        studentRepository.deleteById(id);
    }
}
