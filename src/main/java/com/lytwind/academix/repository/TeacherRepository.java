package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Teacher;
import com.lytwind.academix.repository.projection.TeacherView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<TeacherView> findByEmployeeId(String employeeId);
}
