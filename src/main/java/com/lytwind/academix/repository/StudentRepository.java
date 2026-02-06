package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Student;
import com.lytwind.academix.repository.projection.StudentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<StudentView> findByStudentRegNumber(String regNumber);
    List<StudentView> findByLastNameContainingIgnoreCase(String name);
}
