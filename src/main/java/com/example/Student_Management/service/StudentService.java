package com.example.Student_Management.service;
import com.example.Student_Management.model.Student;
import com.example.Student_Management.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentService {


          private StudentsRepository studentsRepository;

          public StudentService (StudentsRepository studentsRepository){
              this.studentsRepository = studentsRepository;
          }

    public Student addstudent(Student student){

        studentsRepository.save(student);

        return student;
    }

    public List<Student> getAllstudents (){

        return studentsRepository.findAll();
    }

    public Student getstudentbyid(int id){
      return studentsRepository.findById(id).orElse(null);
    }

    public void deletestudentbyid(int id){
      studentsRepository.deleteById(id);
    }
}
