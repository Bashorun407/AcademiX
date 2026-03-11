package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Enrollment;
import com.lytwind.academix.repository.projection.EnrollmentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Check if a student is already enrolled in a specific course
    boolean existsByStudentIdAndCourseCourseCode(Long studentId, String courseCode);

    Optional<Enrollment> findByStudentIdAndCourseCourseCode(Long studentId, String courseCode);

    List<EnrollmentView> findByStudentId(Long id);
    // Get all enrollments for a specific course
    List<EnrollmentView> findByCourseCourseCode(String courseCode);
}
