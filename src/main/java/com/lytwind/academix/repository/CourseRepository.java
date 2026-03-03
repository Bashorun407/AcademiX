package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Course;
import com.lytwind.academix.repository.projection.CourseView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByCourseCode(String courseCode);

    Optional<Course> findByCourseCode(String courseCode);
    // List all courses belonging to a specific department
    List<CourseView> findByDepartmentId(Long departmentId);
}
