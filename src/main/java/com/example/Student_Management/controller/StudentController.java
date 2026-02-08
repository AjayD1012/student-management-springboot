package com.example.Student_Management.controller;

import com.example.Student_Management.service.StudentService;
import org.springframework.web.bind.annotation.*;
import com.example.Student_Management.model.Student;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Student Management Application is running";
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addstudent(student);
    }


    @GetMapping
    public List<Student> getstudents (){

        return studentService.getAllstudents();
    }

    @GetMapping("/{id}")
    public Student getstudentbyid(@PathVariable int id){
        return studentService.getstudentbyid(id);
    }

    @DeleteMapping("/{id}")
    public String deletestudentbyid(@PathVariable int id){
        studentService.deletestudentbyid(id);
        return "Student deleted successfully";
    }

    @PutMapping("/{id}")
    public Student updatestudent(@PathVariable int id, @RequestBody Student student){

        return studentService.updatestudent(id, student);
    }
}
