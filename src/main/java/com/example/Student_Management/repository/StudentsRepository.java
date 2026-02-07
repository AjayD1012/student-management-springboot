package com.example.Student_Management.repository;

import com.example.Student_Management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface StudentsRepository extends JpaRepository<Student,Integer> {
}
