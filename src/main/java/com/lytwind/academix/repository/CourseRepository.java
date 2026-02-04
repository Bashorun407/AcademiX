package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Course;
import com.lytwind.academix.repository.projection.CourseView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    // List all courses belonging to a specific department
    List<CourseView> findByDepartmentId(Long departmentId);
}
