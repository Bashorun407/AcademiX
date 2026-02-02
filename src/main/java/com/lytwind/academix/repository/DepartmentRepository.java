package com.lytwind.academix.repository;

import com.lytwind.academix.entity.Department;
import com.lytwind.academix.repository.projection.DepartmentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Find department by name (useful for setup scripts)
    Optional<DepartmentView> findByNameIgnoreCase(String name);
}
