package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Teacher;
import com.lytwind.academix.repository.projection.TeacherView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    boolean existsByEmployeeId(String employeeId);
    Optional<TeacherView> findByEmployeeId(String employeeId);
}
