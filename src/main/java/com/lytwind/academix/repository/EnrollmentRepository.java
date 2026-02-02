package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Check if a student is already enrolled in a specific course
    boolean existsByStudentIdAndCourseCourseCode(Long studentId, String courseCode);

    // Get all enrollments for a specific course
    List<Enrollment> findByCourseCourseCode(String courseCode);
}
