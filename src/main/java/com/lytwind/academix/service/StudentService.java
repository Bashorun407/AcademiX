package com.lytwind.academix.service;

import com.lytwind.academix.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student registerStudent(Student student);
    Optional<Student> getStudentById(Long id);
    List<Student> getAllStudents();
    void updateStudentGuardian(Long studentId, Long guardianId);
}
