package com.example.Student_Management.service;
import com.example.Student_Management.exception.StudentNotFoundException;
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
      return studentsRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id :"+ id));
    }

    public void deletestudentbyid(int id){

              if (!studentsRepository.existsById(id)){
                  throw new StudentNotFoundException("Student not found with id :"+id);
              }
      studentsRepository.deleteById(id);
    }

    public Student updatestudent(int id, Student student){
              Student existingstudent = studentsRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id :"+ id));

              if (existingstudent == null){
                  return null;

              }

              existingstudent.setName(student.getName());
              existingstudent.setEmail(student.getEmail());

              return studentsRepository.save(existingstudent);
    }
}
