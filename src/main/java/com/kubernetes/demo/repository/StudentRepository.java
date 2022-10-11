package com.kubernetes.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kubernetes.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}