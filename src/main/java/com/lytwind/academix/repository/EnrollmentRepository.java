package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Enrollment;
import com.lytwind.academix.repository.projection.EnrollmentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Check if a student is already enrolled in a specific course
    boolean existsByStudentIdAndCourseCourseCode(Long studentId, String courseCode);

    // Get all enrollments for a specific course
    List<EnrollmentView> findByCourseCourseCode(String courseCode);
}
